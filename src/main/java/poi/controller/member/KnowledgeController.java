package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;

@Controller
public class KnowledgeController {
	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.GET)
	public String displayCreate() {
		return UrlConstant.Page.Member.CREATE;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.GET)
	public String displayUpdate() {
		return UrlConstant.Page.Member.UPDATE;
	}

	@RequestMapping(value = UrlConstant.Page.Member.DELETE, method = RequestMethod.GET)
	public String displayDelete() {
		return UrlConstant.Page.Member.DELETE;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.SEARCH, method = RequestMethod.POST)
	public String search(Model model) {
		model.addAttribute("hello", "検索結果を表示！");
		return UrlConstant.Controller.Member.TOP;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.CREATE, method = RequestMethod.POST)
	public String create(Model model) {
		model.addAttribute("hello", "新規メモ完成！");
		return UrlConstant.Page.Member.COMPLETE;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.UPDATE, method = RequestMethod.POST)
	public String update(Model model) {
		model.addAttribute("hello", "メモを更新！");
		return UrlConstant.Page.Member.COMPLETE;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.DELETE, method = RequestMethod.POST)
	public String delete(Model model) {
		model.addAttribute("hello", "メモを削除!");
		return UrlConstant.Page.Member.COMPLETE;
	}
}
