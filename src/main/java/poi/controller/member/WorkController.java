package poi.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.entity.ArticleT;
import poi.domain.service.ArticleService;
import poi.dto.member.ArticleTDto;
import poi.dto.member.SessionUserDto;
import poi.form.member.ArticleForm;

@Transactional
@Controller
public class WorkController extends BaseController {
	

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
	public String create(@ModelAttribute ArticleForm articleForm, Model model) {
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());

		articleService.registerArticle(articleTDto);
		model.addAttribute("hello", "新規メモ完成！");
		
		return UrlConstant.Page.Member.COMPLETE;
	}	
	
	/**
	 * 編集画面へ遷移 */	
	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE_ID, method = RequestMethod.GET)
	public String displayUpdate(Model model, @PathVariable("articleId") String articleId) {
		String username = sessionUserDto.getUsername();
		List<String> categoryList = articleService.selectCategory(username);
		
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("username", username);
		model.addAttribute("categoryList", categoryList);
		
		// 選択された記事、リスト表示へ戻るための検索条件をモデルにセット
		ArticleT article = articleService.selectArticleByArticleId(articleId);
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
	public String update(@ModelAttribute ArticleForm articleForm, @RequestParam("articleId") String articleId, Model model) {
		ArticleTDto articleTDto = new ArticleTDto();
		articleTDto.username = articleForm.getUsername();
		articleTDto.title = articleForm.getTitle();
		articleTDto.body = articleForm.getBody();
		articleTDto.category = articleForm.getCategory();
		articleTDto.level = Integer.parseInt(articleForm.getLevel());
		
		articleService.updateArticle(articleTDto, articleId);
		model.addAttribute("hello", "メモを更新！");
		return UrlConstant.Page.Member.COMPLETE;
	}	
	
	/**
	 *選択された記事を削除する
	 * @param model
	 * @param articleId
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.GET)
	public String displayDelete(Model model, @PathVariable("articleId") String articleId) {
		articleService.deleteArticle(articleId);
		model.addAttribute("hello", "記事を削除！");
		return UrlConstant.Page.Member.COMPLETE;
	}
	
	/**
	 * ユーザー設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.GET)
	public String setting() {
		return UrlConstant.Page.Member.SETTING;
	}
//	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.POST)
//	public String setting(Model model) {
//		model.addAttribute("hello", "ユーザー設定を変更しました!");
//		return UrlConstant.Page.Member.COMPLETE;
//	}


}
