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
import poi.domain.entity.CategoryT;
import poi.domain.service.ArticleService;
import poi.dto.member.SessionUserDto;

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
    		attribute.addFlashAttribute("resultNoArticle", "No articles found.");
    	}
    	attribute.addFlashAttribute("resultArticleList", resultArticleList);
    	
    	// 見出しに表示する検索条件
    	String headerStr = null;
		if (category == "" && level == "") {	
			headerStr = "Search all";
		//カテゴリに紐づく記事を取得(レベル未選択)
	    } else if (level == "") {
	    	headerStr = category;		//レベルに紐づく記事を取得(カテゴリ未選択)
	    } else if (category == "") {
	    	headerStr = "Level" + level;	    //カテゴリとレベル紐づく記事を取得
		} else {
			headerStr = category + "&Level: " + level;
		}
		attribute.addFlashAttribute("headerStr", headerStr);
    	attribute.addFlashAttribute("categoryStatus", category);
    	attribute.addFlashAttribute("levelStatus", level);
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	
	/**
	 *  選択された記事を表示する画面へ遷移
	 * 
	 * @param model
	 * @param articleId
	 * @param category
	 * @param level
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.SELECT, method = RequestMethod.POST)
	public String selectedArticle(Model model, @RequestParam("articleId") String articleId, @RequestParam("categoryStatus") String category, @RequestParam("levelStatus") String level) {
		String username = sessionUserDto.getUsername();
		int articleCount = articleService.selectArticleCount(username);
		List<CategoryT> categoryList = articleService.selectCategory(username);
		
		// 記事の件数を表示
		model.addAttribute("articleCount", articleCount);
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("categoryList", categoryList);
		
		// 選択された記事、リスト表示へ戻るための検索条件をモデルにセット
		ArticleT article = articleService.selectArticleByArticleId(articleId);
		model.addAttribute("article", article);
		model.addAttribute("category", category);
		model.addAttribute("level", level);
		
		return UrlConstant.Page.Member.SELECT;
	}
}
