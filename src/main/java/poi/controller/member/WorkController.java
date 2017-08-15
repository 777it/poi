package poi.controller.member;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
import poi.domain.entity.UserT;
import poi.domain.service.ArticleService;
import poi.domain.service.UserService;
import poi.dto.general.UserDto;
import poi.dto.member.ArticleTDto;
import poi.dto.member.SessionUserDto;
import poi.form.general.UserForm;
import poi.form.member.ArticleForm;

@Transactional
@Controller
public class WorkController extends BaseController {
	
	@Autowired
	protected UserService userService;
	@Autowired
	protected ArticleService articleService;
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
		List<String> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("username", username);
		model.addAttribute("categoryList", categoryList);
		return UrlConstant.Page.Member.CREATE;
	}
	
	/**
	 * 新規に記事を作成する
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.POST)
	public String create(@Validated @ModelAttribute ArticleForm articleForm, BindingResult result, RedirectAttributes attribute) {
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());

		articleService.registerArticle(articleTDto);
		attribute.addFlashAttribute("message", "新規メモ完成！");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}	
	
	/**
	 * 編集画面へ遷移 */	
	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE_ID, method = RequestMethod.GET)
	public String displayUpdate(@ModelAttribute ArticleForm articleForm, Model model, @PathVariable("articleId") String articleId) {
		String username = sessionUserDto.getUsername();
		List<String> categoryList = articleService.selectCategory(username);
		
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
	public String update(RedirectAttributes attribute, @ModelAttribute ArticleForm articleForm, @RequestParam("articleId") String articleId) {
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());
		
		articleService.updateArticle(articleTDto, articleId);
		attribute.addFlashAttribute("message", "メモを更新！");
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
		attribute.addFlashAttribute("message", "記事を削除！");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	
	/**
	 * ユーザー設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.GET)
	public String displaySetting(@ModelAttribute UserForm userForm, Model model) {
		// ユーザー情報を取得
		String username = sessionUserDto.getUsername();
		UserT userInfo = userService.selectByUserInfo(username);
		UserDto userDto = new UserDto();
		userDto.username = userInfo.username;
		userDto.mail = userInfo.mail;
		userDto.birthday = userInfo.birthday;
		userDto.password = userInfo.password;
		
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
	public String editSetting(@Validated @ModelAttribute UserForm userForm, BindingResult result, RedirectAttributes attribute) {
		// エラーがある場合
		if (result.hasErrors()) {
			// TODO エラー内容が引き継がれない
			return UrlConstant.Controller.Member.REDIRECT_SETTING;
		}
		UserDto userDto = new UserDto();
		userDto.username = userForm.getUsername();
		userDto.mail = userForm.getMail();
		userDto.birthday = userForm.getBirthday();
		userDto.password = userForm.getPassword();
		userService.editUser(userDto);
		// ユーザー名を変更した可能性があるので新たにセッションユーザーをセット
		userService.selectUserAndSetSession(userDto.username);
		attribute.addFlashAttribute("message", "ユーザー設定を変更しました!");
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}


}
