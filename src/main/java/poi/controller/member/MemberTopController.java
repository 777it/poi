package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;

@Controller
public class MemberTopController extends BaseController {
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.GET)
	public String index() {
		return UrlConstant.Page.Member.TOP;
	}
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.POST)
	public String indexFromMember() {
		return UrlConstant.Page.Member.TOP;
	}
}
