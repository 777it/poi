package poi.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.service.ArticleService;
import poi.dto.member.SessionUserDto;

@Controller
public class MemberTopController extends BaseController {
	
	@Autowired
	protected ArticleService articleService;
	@Autowired
	protected SessionUserDto sessionUserDto;
	
	/**
	 * 会員初期表示（ユーザーに紐づく記事件数とカテゴリを表示）
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.GET)
	public String index(Model model) {

		String username = sessionUserDto.getUsername();
		int articleCount = articleService.selectArticleCount(username);
		List<String> categoryList = articleService.selectCategory(username);
		
		// 記事の件数を表示
		model.addAttribute("articleCount", articleCount);
		// ユーザーに紐づくカテゴリを表示
		model.addAttribute("categoryList", categoryList);
		
		return UrlConstant.Page.Member.TOP;
	}
	
	/**
	 * 各会員ページから会員トップ画面に遷移する
	 * 
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.POST)
	public String indexFromMember() {
		
		return UrlConstant.Page.Member.TOP;
	}
}
