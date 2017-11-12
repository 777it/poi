package poi.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.InvalidCsrfTokenException;
import org.springframework.security.web.csrf.MissingCsrfTokenException;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import poi.constant.UrlConstant;
import poi.util.TokenUtility;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TokenUtility.class);

	@Autowired
	protected PoiProperites poiProperites;

	protected RequestMatcher csrfRequestMatcher = new RequestMatcher() {
		// 対象外一覧
		private AntPathRequestMatcher[] ignoreRequestMatchers = {
				// static
				new AntPathRequestMatcher(UrlConstant.CSS + UrlConstant.DIRECTORY_ALL),
				new AntPathRequestMatcher(UrlConstant.IMAGES + UrlConstant.DIRECTORY_ALL),
				new AntPathRequestMatcher(UrlConstant.JS + UrlConstant.DIRECTORY_ALL),
				new AntPathRequestMatcher(UrlConstant.FONTS + UrlConstant.DIRECTORY_ALL),
				new AntPathRequestMatcher(UrlConstant.DESIGN + UrlConstant.DIRECTORY_ALL),

				// ルート
				new AntPathRequestMatcher(UrlConstant.Controller.MEMBER + "/"),
				// ログイン画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.LOGIN),
				new AntPathRequestMatcher(UrlConstant.Controller.Member.REDIRECT_TOP),
				// 初期表示
				new AntPathRequestMatcher(UrlConstant.Controller.Member.INDEX),
				// トップ画面(検索)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.TOP),
				// 記事画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.SELECT),
				// 記事検索画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.SEARCH),
				// 記事検索画面(リダイレクト)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.REDIRECT_SEARCH),
			    // 記事作成画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.REDIRECT_CREATE),
				// 記事作成画面(リダイレクト)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.CREATE),
				// 記事編集画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.UPDATE),
				// 記事編集画面(パラメータ)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.UPDATE_ID),
				// 記事削除画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.DELETE),
				// 操作完了画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.COMPLETE),
				// 設定画面(アカウント)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.SETTING),
				// 設定画面(カテゴリ)
				new AntPathRequestMatcher(UrlConstant.Controller.Member.SETTING_CATEGORY),
				// ヘルプ画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.HELP),
				// ログアウト画面
				new AntPathRequestMatcher(UrlConstant.Controller.Member.LOGOUT),
				// ログアウト画面（リダイレクト）
				new AntPathRequestMatcher(UrlConstant.Controller.General.REDIRECT_LOGOUT),
				// ログイン画面（リダイレクト）
				new AntPathRequestMatcher(UrlConstant.Controller.Member.REDIRECT_TOP),
				// ログイン画面（フォワード）
				new AntPathRequestMatcher(UrlConstant.Controller.Member.FORWARD_LOGIN),
				
				// カテゴリ追加
				new AntPathRequestMatcher(UrlConstant.Controller.Member.ADD_CATEGORY),
				// カテゴリ追加
				new AntPathRequestMatcher(UrlConstant.Controller.Member.DELETE_CATEGORY),
				
				// ルート
				new AntPathRequestMatcher(UrlConstant.Controller.GENERAL + UrlConstant.SLASH),
				// 初期表示
				new AntPathRequestMatcher(UrlConstant.Controller.General.REDIRECT_ROOT),
				new AntPathRequestMatcher(UrlConstant.Controller.General.INDEX),
				// 新規登録画面. */
				new AntPathRequestMatcher(UrlConstant.Controller.General.REGISTER),
				// 新規登録画面（確認）. */
				new AntPathRequestMatcher(UrlConstant.Controller.General.CONFIRM),
				// 新規登録. */
				new AntPathRequestMatcher(UrlConstant.Controller.General.CREATE_ACCOUNT),
				// ログイン画面（リダイレクト）. */
				new AntPathRequestMatcher(UrlConstant.Controller.General.REDIRECT_LOGOUT),
				
				// セッションリセット
				new AntPathRequestMatcher(UrlConstant.Controller.General.RESET),
				
				// 共通画面
				new AntPathRequestMatcher(UrlConstant.Controller.Error.NOT_FOUND),
				new AntPathRequestMatcher(UrlConstant.Controller.Error.INTERNAL_SERVER_ERROR),
				new AntPathRequestMatcher(UrlConstant.Controller.Error.SESSION_TIMEOUT),
		};

		@Override
		public boolean matches(HttpServletRequest request) {

			for (AntPathRequestMatcher pathRquest : ignoreRequestMatchers) {
				if (pathRquest.matches(request)) {
					logger.debug("CSRF対象外：" + request.getRequestURI());
					return false;
				}
			}
			logger.debug("CSRF対象：" + request.getRequestURI());
			return true;
		}
	};


	@Override
	protected void configure(HttpSecurity http) throws Exception{

		logger.debug("セッションタイムアウト：" + poiProperites.getSessionTimeout());

		http
			.rememberMe().tokenValiditySeconds(poiProperites.getSessionTimeout())
			.and().csrf() // クロスサイトリクエストフォージェリー対策
				.requireCsrfProtectionMatcher(csrfRequestMatcher)
			.and().exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler());
	}

	@Bean
	AccessDeniedHandler accessDeniedHandler() {
		return new AccessDeniedHandler() {
			@Override
			public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
				if (accessDeniedException instanceof MissingCsrfTokenException
						|| accessDeniedException instanceof InvalidCsrfTokenException) {
					response.sendRedirect(poiProperites.getContextPath() + UrlConstant.Controller.Error.SESSION_TIMEOUT);

				} else {
					new AccessDeniedHandlerImpl().handle(request, response, accessDeniedException);
				}
			}
		};
	}

}
