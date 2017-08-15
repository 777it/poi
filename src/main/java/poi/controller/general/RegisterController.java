package poi.controller.general;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import poi.constant.UrlConstant;
import poi.controller.BaseController;
import poi.domain.service.UserService;
import poi.dto.general.UserDto;
import poi.form.general.UserForm;
import poi.form.member.LoginForm;

@Transactional
@Controller
public class RegisterController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UserDto userDto;
	
	@RequestMapping(value = UrlConstant.Controller.General.REGISTER, method = RequestMethod.POST)
	public String register() {
		// セッション再作成
		HttpSession session = request.getSession(true);
		logger.debug("Session:" + session);

		request.getSession().invalidate();
		logger.debug("Session:" + request.getSession());	
		return UrlConstant.Page.General.REGISTER;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CONFIRM, method = RequestMethod.POST)
	public String confirm(@Validated @ModelAttribute UserForm userForm, BindingResult result, Model model) {
		// エラーがある場合
		if (result.hasErrors()) {
			return UrlConstant.Page.Member.CREATE;
		}		
		model.addAttribute("accountCreateForm", userForm);
		BeanUtils.copyProperties(userForm, userDto);
		
		return UrlConstant.Page.General.CONFIRM;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CREATE_ACCOUNT, method = RequestMethod.POST)
	public String create(LoginForm loginForm, Model model) {
		
		userService.registerUser(userDto);
		loginForm.setLoginId(userDto.username);
		loginForm.setPassword(userDto.password);
		model.addAttribute("loginForm", loginForm);
		
		// ログイン後トップ画面へ
		return UrlConstant.Controller.Member.FORWARD_LOGIN;
	}
}
