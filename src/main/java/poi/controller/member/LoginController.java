package poi.controller.member;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import poi.form.member.LoginForm;

@Controller
public class LoginController extends BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	protected UserService userService;
	@Autowired
	protected UserDto sessionRegisterDto;
	
	/**
	 * ログイン画面初期表示 */
	@RequestMapping(value = UrlConstant.Controller.Member.INDEX, method = RequestMethod.GET)
	public String displayLogin(Model model) {
		// セッション再作成
		HttpSession session = request.getSession(true);
		logger.debug("Session:" + session);

		request.getSession().invalidate();
		logger.debug("Session:" + request.getSession());

		model.addAttribute("loginForm", new LoginForm());
		return UrlConstant.Page.Member.LOGIN;
	}
	
	/**
	 * ログイン認証
	 * 1. ログインボタンから
	 * 2. 新規登録画面から */
	@RequestMapping(value = UrlConstant.Controller.Member.LOGIN, method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute LoginForm loginForm, BindingResult result, Model model) {
		
		String loginId;
		String password;

		// 1. ログインボタンから
		if (StringUtils.isEmpty(sessionRegisterDto.getUsername())) {

			// エラーがある場合
			if (result.hasErrors()) {
				return UrlConstant.Page.Member.LOGIN;
			}
			loginId = loginForm.getLoginId();
			password = loginForm.getPassword();

		// 2. 新規登録画面から
		} else {
			loginId = sessionRegisterDto.getUsername();
			password = sessionRegisterDto.getPassword();
		}

		logger.debug("Username:" + loginId);
		logger.debug("Password:" + (StringUtils.isNotEmpty(password)
				? password.substring(0, 1) + "*******(" + password.length() + "桁)" : password));

		// パスワードを表示させないように空を設定
		loginForm.setPassword("");
		model.addAttribute("loginForm", loginForm);

		// 認証
		boolean auth = userService.authentication(loginId, password);

		if (!auth) {
			result.rejectValue("auth", "error.Auth");
			return UrlConstant.Page.Member.LOGIN;

		} else {
			// セッション再作成
			HttpSession session = request.getSession(true);
			logger.debug("Session:" + session);
			session.invalidate();

			HttpSession newSession = request.getSession(true);
			logger.debug("NewSession:" + newSession);

			//セッションが破棄されたことを確認
			System.out.println(loginId);
			System.out.println(sessionRegisterDto.getUsername());
			
			// ユーザー情報セッション詰め替え
			userService.selectUserAndSetSession(loginId);
			
			// リダイレクト
			return UrlConstant.Controller.Member.REDIRECT_TOP;
		}
	}	
	
	/**
	 * ログアウト処理 */
	@RequestMapping(value = UrlConstant.Controller.Member.LOGOUT, method = RequestMethod.GET)
	public String logout(Model model) {
		// セッション再作成
		HttpSession session = request.getSession(true);
		logger.debug("Session:" + session);

		request.getSession().invalidate();
		logger.debug("Session:" + request.getSession());

		model.addAttribute("loginForm", new LoginForm());
		
		return UrlConstant.Page.Member.LOGIN;
	}
}
