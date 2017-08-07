package poi;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import poi.constant.UrlConstant;
import poi.controller.member.LoginController;
import poi.dto.member.SessionUserDto;

public class SessionInterceptor implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	protected SessionUserDto sessionUserDto;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// コンテキストパスを取得
		String contextPath = request.getContextPath();

		// ログイン画面は認証スキップ
		if (request.getRequestURI().equals(contextPath + UrlConstant.Controller.Member.INDEX)) {
			return true;

		} else if (request.getRequestURI().equals(contextPath + UrlConstant.Controller.Member.LOGIN)) {
			return true;

		} else {

			// セッションある場合そのオブジェクトを返し、ない場合はnullを返す
			HttpSession session = request.getSession(false);
			logger.debug("Session:" + session);

			// SessionUserDtoのidが保持されているか確認
			logger.debug("id:" + sessionUserDto.getId());

			if (session == null || sessionUserDto.getId() == null) {
				logger.debug("セッションが切れました。再度ログインして下さい。");

				RequestDispatcher dispatch = request.getRequestDispatcher(UrlConstant.Controller.General.ROOT);
				dispatch.forward(request, response);

				return true;
			}

			return true;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView view) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
	}

}
