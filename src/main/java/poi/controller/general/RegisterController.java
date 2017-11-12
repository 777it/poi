package poi.controller.general;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import poi.validator.seq.All;

@Transactional
@Controller
public class RegisterController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UserDto userDto;
	
	@RequestMapping(value = UrlConstant.Controller.General.REGISTER, method = RequestMethod.POST)
	public String register(Model model) {
		// セッション再作成
		HttpSession session = request.getSession(true);
		logger.debug("Session:" + session);

		request.getSession().invalidate();
		logger.debug("Session:" + request.getSession());	
		
		model.addAttribute("userForm", new UserForm());	
		return UrlConstant.Page.General.REGISTER;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CONFIRM, method = RequestMethod.POST)
	public String confirm(@Validated(All.class) @ModelAttribute UserForm userForm, BindingResult result, Model model) {
		// エラーがある場合
		if (result.hasErrors()) {
			model.addAttribute("username", userForm.getUsername());
			model.addAttribute("mail", userForm.getMail());
			return UrlConstant.Page.General.REGISTER;
		}		
		//BeanUtils.copyProperties(userForm, userDto);
		String date = userForm.getYear() + userForm.getMonth() + userForm.getDay();
		userDto.setUsername(userForm.getUsername());
		userDto.setMail(userForm.getMail());
		userDto.setPassword(userForm.getPassword());
		userDto.setBirthday(date);
		
		model.addAttribute("username", userForm.getUsername());
		model.addAttribute("mail", userForm.getMail());
		//月の数字を英語変換
		String month = getMonthEn(userForm.getMonth());
		model.addAttribute("month", month);
		model.addAttribute("day", userForm.getDay());
		model.addAttribute("year", userForm.getYear());
		
		return UrlConstant.Page.General.CONFIRM;
	}

	@RequestMapping(value = UrlConstant.Controller.General.CREATE_ACCOUNT, method = RequestMethod.POST)
	public String create(LoginForm loginForm, Model model) {
		
		userService.registerUser(userDto);
		loginForm.setLoginId(userDto.getUsername());
		loginForm.setPassword(userDto.getPassword());
		model.addAttribute("loginForm", loginForm);
		
		// ログイン後トップ画面へ
		return UrlConstant.Controller.Member.FORWARD_LOGIN;
	}
	private String getMonthEn(String month) {
		String monthEn;
		switch (month) {
		case "01":
			monthEn = "January";
			break;
		case "02":
			monthEn = "February";
			break;
		case "03":
			monthEn = "March";
			break;
		case "04":
			monthEn = "April";
			break;
		case "05":
			monthEn = "May";
			break;
		case "06":
			monthEn = "June";
			break;
		case "07":
			monthEn = "July";
			break;
		case "08":
			monthEn = "August";
			break;
		case "09":
			monthEn = "September";
			break;
		case "10":
			monthEn = "October";
			break;
		case "11":
			monthEn = "November";
			break;
		case "12":
			monthEn = "December";
			break;
		default:
			monthEn = "";
			break;
		}
		return monthEn;
	}
}
