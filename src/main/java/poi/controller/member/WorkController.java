package poi.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.entity.ArticleT;
import poi.domain.entity.CategoryT;
import poi.domain.entity.UserT;
import poi.domain.service.ArticleService;
import poi.domain.service.CategoryService;
import poi.domain.service.UserService;
import poi.dto.general.UserDto;
import poi.dto.member.ArticleTDto;
import poi.dto.member.CategoryTDto;
import poi.dto.member.SessionUserDto;
import poi.form.general.UserForm;
import poi.form.member.ArticleForm;
import poi.validator.seq.All;

@Transactional
@Controller
public class WorkController extends BaseController {
	
	@Autowired
	protected UserService userService;
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected CategoryService categoryService;
	@Autowired
	protected SessionUserDto sessionUserDto;

	/**
	 * 記事作成画面へ遷移
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.GET)
	public String displayCreate(Model model) {
		String username = sessionUserDto.getUsername();
		List<CategoryT> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("username", username);
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("articleForm", new ArticleForm());	
		return UrlConstant.Page.Member.CREATE;
	}
	
	/**
	 * 新規に記事を作成する
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.POST)
	public String create(@Validated(All.class) @ModelAttribute  ArticleForm articleForm, BindingResult result, Model model, RedirectAttributes attribute) {
		// エラーがある場合
		if (result.hasErrors()) {
			String username = sessionUserDto.getUsername();
			List<CategoryT> categoryList = articleService.selectCategory(username);
			model.addAttribute("username", username);
			model.addAttribute("categoryList", categoryList);
			model.addAttribute("title", articleForm.getTitle());
			model.addAttribute("body", articleForm.getBody());
			
			return UrlConstant.Page.Member.CREATE;
		}
		// 新規カテゴリの場合
		String username = articleForm.getUsername();
		String category = articleForm.getCategory();
		String newCategory = categoryService.selectCategoryByselectedCategory(username, category);
		if (newCategory == null) {
			CategoryTDto categoryTDto = new CategoryTDto();
			categoryTDto.username = username;
			categoryTDto.category = category;
			categoryService.register(categoryTDto);
		}
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = username;
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = category;
		articleTDto.level = Integer.parseInt(articleForm.getLevel());

		articleService.registerArticle(articleTDto);
		attribute.addFlashAttribute("message", "The note has been created.");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}	
	
	/**
	 * 編集画面へ遷移 */	
	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE_ID, method = RequestMethod.GET)
	public String displayUpdate(@ModelAttribute ArticleForm articleForm, Model model, @PathVariable("articleId") String articleId) {
		String username = sessionUserDto.getUsername();
		List<CategoryT> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("username", username);
		model.addAttribute("categoryList", categoryList);
		
		// 選択された記事、リスト表示へ戻るための検索条件をモデルにセット
		ArticleT article = articleService.selectArticleByArticleId(articleId);
		model.addAttribute("articleForm", articleForm);
		model.addAttribute("article", article);
		
		return UrlConstant.Page.Member.UPDATE;
	}
	
	/**
	 * 選択された記事を編集する
	 * @param articleForm
	 * @param articleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.POST)
	public String update(@Validated(All.class) @ModelAttribute  ArticleForm articleForm, BindingResult result, Model model, RedirectAttributes attribute, @RequestParam("articleId") String articleId) {
		// エラーがある場合
		if (result.hasErrors()) {
			// TODO エラー内容が引き継がれない
			return UrlConstant.Controller.Member.UPDATE;
		}
		// 新規カテゴリの場合
		String username = articleForm.getUsername();
		String category = articleForm.getCategory();
		String newCategory = categoryService.selectCategoryByselectedCategory(username, category);
		if (newCategory == null) {
			CategoryTDto categoryTDto = new CategoryTDto();
			categoryTDto.username = username;
			categoryTDto.category = category;
			categoryService.register(categoryTDto);
		}
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());
		
		articleService.updateArticle(articleTDto, articleId);
		attribute.addFlashAttribute("message", "The note has been updated.");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}	
	
	/**
	 *選択された記事を削除する
	 * @param model
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.GET)
	public String displayDelete(RedirectAttributes attribute, @PathVariable("articleId") String articleId) {
		articleService.deleteArticle(articleId);
		attribute.addFlashAttribute("message", "The note has been deleted.");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	
	/**
	 * ユーザー設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.GET)
	public String displaySetting(Model model) {
		// ユーザー情報を取得
		String username = sessionUserDto.getUsername();
		UserT userInfo = userService.selectByUserInfo(username);
		
		String birthday = userInfo.birthday;
		
		//誕生日が登録されてる場合
		if (!birthday.isEmpty()) {
			//誕生日を年月日に分ける
			String month = birthday.substring(4, 6); 
			String day = birthday.substring(6, 8); 
			String year = birthday.substring(0, 4);	
			
			//月の数字を英語変換
			month = getMonthEn(month);
			
			birthday = month + " " + day + "th " + year;
			
		}
		UserDto userDto = new UserDto();
		userDto.setUsername(userInfo.username);
		userDto.setMail(userInfo.mail);
		userDto.setPassword(userInfo.password);
		userDto.setBirthday(birthday);
		
		model.addAttribute("userForm", new UserForm());
		model.addAttribute("userInfo", userDto);
		
		return UrlConstant.Page.Member.SETTING;
	}
	/**
	 * ユーザー情報を編集する
	 * @param userForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.POST)
	public String editSetting(@Validated(All.class) @ModelAttribute UserForm userForm, BindingResult result, Model model, RedirectAttributes attribute) {
		// エラーがある場合
		if (result.hasErrors()) {
			// ユーザー情報を取得
			String username = sessionUserDto.getUsername();
			UserT userInfo = userService.selectByUserInfo(username);
			
			String birthday = userInfo.birthday;
			
			//誕生日が登録されてる場合
			if (!birthday.isEmpty()) {
				//誕生日を年月日に分ける
				String month = birthday.substring(4, 6); 
				String day = birthday.substring(6, 8); 
				String year = birthday.substring(0, 4);	
				
				//月の数字を英語変換
				month = getMonthEn(month);
				
				birthday = month + " " + day + "th " + year;
				
			}
			UserDto userDto = new UserDto();
			userDto.setUsername(userInfo.username);
			userDto.setMail(userInfo.mail);
			userDto.setPassword(userInfo.password);
			userDto.setBirthday(birthday);
			
			model.addAttribute("userInfo", userDto);
			//エラーで戻った時
			model.addAttribute("name", userForm.getUsername());
			model.addAttribute("mail", userForm.getMail());
			
			return UrlConstant.Page.Member.SETTING;
		}
		UserDto userDto = new UserDto();
		String date = userForm.getYear() + userForm.getMonth() + userForm.getDay();
		userDto.setUsername(userForm.getUsername());
		userDto.setMail(userForm.getMail());
		userDto.setBirthday(date);
		userDto.setPassword(userForm.getPassword());
		userService.editUser(userDto);
		// ユーザー名を変更した可能性があるので新たにセッションユーザーをセット
		userService.selectUserAndSetSession(userDto.getUsername());
		attribute.addFlashAttribute("message", "Account updated.");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	/**
	 * ヘルプ画面へ遷移
	 * 
	 * @param model
	 * @return ヘルプ画面
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.HELP, method = RequestMethod.GET)
	public String displayHelp(Model model) {
		return UrlConstant.Page.Member.HELP;
	}

//	/**
//	 * カテゴリ追加
//	 * 
//	 * @param model
//	 * @return 
//	 */
//	@RequestMapping(value = UrlConstant.Controller.Member.ADD_CATEGORY, method = RequestMethod.GET)
//	public String addCategory(@PathVariable("category") String category) {
//		// ユーザー情報を取得
//		String username = sessionUserDto.getUsername();
//		
//		CategoryTDto categoryTDto = new CategoryTDto();
//		categoryTDto.username = username;
//		categoryTDto.category = category;
//		categoryService.register(categoryTDto);
//		
//		return UrlConstant.Controller.Member.REDIRECT_CREATE;
//	}
	/**
	 *カテゴリ設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING_CATEGORY, method = RequestMethod.GET)
	public String displaySettingCategory(Model model) {
		String username = sessionUserDto.getUsername();
		List<CategoryT> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("categoryList", categoryList);
		return UrlConstant.Page.Member.SETTING_CATEGORY;
	}
	/**
	 *選択されたカテゴリを削除する
	 * @param model
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.DELETE_CATEGORY, method = RequestMethod.GET)
	public String displayDelete(Model model, @PathVariable("categoryId") String categoryId) {
		categoryService.deletecategory(categoryId);
		String username = sessionUserDto.getUsername();
		List<CategoryT> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("categoryList", categoryList);
		return UrlConstant.Page.Member.SETTING_CATEGORY;
	}
	private String getMonthEn(String month) {
		String monthEn;
		switch (month) {
		case "01":
			monthEn = "January";
			break;
		case "02":
			monthEn = "February";
			break;
		case "03":
			monthEn = "March";
			break;
		case "04":
			monthEn = "April";
			break;
		case "05":
			monthEn = "May";
			break;
		case "06":
			monthEn = "June";
			break;
		case "07":
			monthEn = "July";
			break;
		case "08":
			monthEn = "August";
			break;
		case "09":
			monthEn = "September";
			break;
		case "10":
			monthEn = "October";
			break;
		case "11":
			monthEn = "November";
			break;
		case "12":
			monthEn = "December";
			break;
		default:
			monthEn = "";
			break;
		}
		return monthEn;
	}

}
