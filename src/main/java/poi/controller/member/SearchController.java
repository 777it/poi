package poi.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.entity.ArticleT;
import poi.domain.service.ArticleService;
import poi.dto.member.SessionUserDto;
import poi.form.member.ArticleForm;

@Controller
public class SearchController extends BaseController {
	

	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected SessionUserDto sessionUserDto;
	
	/**
	 * カテゴリに紐づく記事を検索
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.SEARCH, method = RequestMethod.POST)
	public String displayArticleselectedByCategory(RedirectAttributes attribute, @RequestParam("category") String category, @RequestParam("level") String level) {
		String username = sessionUserDto.getUsername();
    	List<ArticleT> resultArticleList = articleService.selectArticle(username, category, level);

    	// 検索結果が0件の場合
    	if (resultArticleList.isEmpty()) {
    		attribute.addFlashAttribute("resultNoArticle", "検索結果0件");
    	}
    	attribute.addFlashAttribute("resultArticleList", resultArticleList);
    	
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	
	/**
	 * 記事作成画面へ遷移 */	
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
	 * ユーザー設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.GET)
	public String setting() {
		return UrlConstant.Page.Member.SETTING;
	}
	/**
	 * 編集画面へ遷移 */	
	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.GET)
	public String displayUpdate(Model model) {
		model.addAttribute("articleForm", new ArticleForm());

		return UrlConstant.Page.Member.UPDATE;
	}

//	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.GET)
//	public String displayDelete() {
//		return UrlConstant.Page.Member.DELETE;
//	}
}
