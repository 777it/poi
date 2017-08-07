package poi.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.FieldError;

import poi.util.CookieUtility;


public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@Autowired
	protected HttpServletRequest request;
	
	@Autowired
	protected HttpServletResponse response;

	@Autowired
	protected MessageSource messageSource;

	protected void deleteSession() {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if(request.getCookies() != null) {
				// JSESSIONID削除
				CookieUtility.deleteJsessionid(request.getCookies(), response);
			}
			// セッション削除
			session.invalidate();
			logger.debug("session_id:" + session.getId());
		}
	}

	protected String getMessage(final String code) {
		return messageSource.getMessage(code, null, Locale.JAPANESE);
	}

	protected String getMessage(final FieldError fieldError) {
		return messageSource.getMessage(fieldError, Locale.JAPANESE);
	}
}
