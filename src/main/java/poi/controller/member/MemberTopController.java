package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;

@Controller
public class MemberTopController {
	@RequestMapping(value = UrlConstant.Controller.Member.TOP, method = RequestMethod.POST)
	public String login() {
		return UrlConstant.Page.Member.TOP;
	}
}
