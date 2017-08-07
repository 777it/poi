package poi.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class CookieUtility {
	private static final Logger logger = LoggerFactory.getLogger(CookieUtility.class);
	
	/** ルートパス"/". */
	private static final String ROOT_PATH = "/poi/";
	
	/** JSESSIONID. */
	private static final String JSESSINID = "JSESSIONID";

	private CookieUtility() {
		// privateコンストラクタ
	}

	public static final void create(final String name, final String value, final int maxAge, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath(ROOT_PATH);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public static final void delete(Cookie cookie, HttpServletResponse response) {
		cookie.setMaxAge(-1);
		cookie.setPath(ROOT_PATH);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}
	
	public static final void deleteJsessionid(Cookie[] cookies, HttpServletResponse response) {
		for(Cookie cookie : cookies) {
			logger.info("cookie:" + cookie.getName());
			if(JSESSINID.equals(cookie.getName())) {
				CookieUtility.delete(cookie, response);
			}
		}
	}
}
