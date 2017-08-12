package poi.controller.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.service.DaoService;
import poi.dto.member.SessionUserDto;


/**
 * @author kaihatsu
 *
 */
@Controller
public class MemberTopController extends BaseController {
	
	@Autowired
	protected DaoService daoService;
	@Autowired
	protected SessionUserDto sessionUserDto;
	
	/**
	 * 会員初期表示（ユーザーに紐づく記事件数とカテゴリを表示）
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.GET)
	public String index(@ModelAttribute("model")ModelMap modelMap, Model model) {

		String username = sessionUserDto.getUsername();
		int articleCount = daoService.selectArticleCount(username);
		List<String> categoryList = daoService.selectCategory(username);
		
		// 記事の件数を表示
		model.addAttribute("articleCount", articleCount);
		model.addAttribute("categoryList", categoryList);
		
		Map<String, String> map = (Map<String, String>)modelMap.get("articleMap");
		model.addAttribute("resultArticleMap", map);
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
