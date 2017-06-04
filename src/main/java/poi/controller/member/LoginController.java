package poi.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;

@Controller
public class LoginController {
	@RequestMapping(value = UrlConstant.Controller.Member.LOGIN, method = RequestMethod.POST)
	public String displayLogin() {
		return UrlConstant.Page.Member.LOGIN;
	}

	@RequestMapping(value = UrlConstant.Controller.Member.LOGOUT, method = RequestMethod.POST)
	public String logout() {
		return UrlConstant.Page.General.INDEX;
	}
}
