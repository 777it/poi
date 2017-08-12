package poi.controller.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.service.DaoService;
import poi.dto.member.SessionUserDto;

@Controller
public class SearchController extends BaseController {
	

	@Autowired
	protected DaoService daoService;
	@Autowired
	protected SessionUserDto sessionUserDto;
	/**
	 * カテゴリに紐づく記事を検索
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = UrlConstant.Controller.Member.SEARCH, method = RequestMethod.GET)
	public String displayArticleselectedByCategory(RedirectAttributes attributes, @RequestParam("category") String category, @RequestParam("level") String level) {
		String username = sessionUserDto.getUsername();
    	Map<String, String> articleMap = daoService.selectArticle(username, category, level);

    	ModelMap modelMap = new ModelMap();
        modelMap.addAttribute("articleMap", articleMap);
        attributes.addFlashAttribute("model", modelMap);
        
		return UrlConstant.Controller.Member.REDIRECT_TOP;
	}
	
	/**
	 * 記事作成画面へ遷移 */	
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.GET)
	public String displayCreate() {
		return UrlConstant.Page.Member.CREATE;
	}
	
	/**
	 * ユーザー設定画面へ遷移 */
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.GET)
	public String setting() {
		return UrlConstant.Page.Member.SETTING;
	}
//	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.GET)
//	public String displayUpdate() {
//		return UrlConstant.Page.Member.UPDATE;
//	}
//
//	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.GET)
//	public String displayDelete() {
//		return UrlConstant.Page.Member.DELETE;
//	}

	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.POST)
	public String create(Model model) {
		model.addAttribute("hello", "新規メモ完成！");
		return UrlConstant.Page.Member.COMPLETE;
	}
	@RequestMapping(value = UrlConstant.Controller.Member.SETTING, method = RequestMethod.POST)
	public String setting(Model model) {
		model.addAttribute("hello", "ユーザー設定を変更しました!");
		return UrlConstant.Page.Member.COMPLETE;
	}
//	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.POST)
//	public String update(Model model) {
//		model.addAttribute("hello", "メモを更新！");
//		return UrlConstant.Page.Member.COMPLETE;
//	}
//
//	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.POST)
//	public String delete(Model model) {
//		model.addAttribute("hello", "メモを削除!");
//		return UrlConstant.Page.Member.COMPLETE;
//	}

}
