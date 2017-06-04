package poi.controller.general;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;

@Controller
public class RegisterController {
	@RequestMapping(value = UrlConstant.Controller.General.REGISTER, method = RequestMethod.POST)
	public String register() {
		return UrlConstant.Page.General.REGISTER;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CONFIRM, method = RequestMethod.POST)
	public String confirm() {
		return UrlConstant.Page.General.CONFIRM;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CREATE_ACCOUNT, method = RequestMethod.POST)
	public String create() {
		return UrlConstant.Page.Member.TOP;
	}
}
