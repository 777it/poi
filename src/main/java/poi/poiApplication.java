package poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;

import poi.constant.UrlConstant;

@ImportResource("classpath:transaction-context.xml")
@SpringBootApplication
//下記3つのアノテーションをまとめたもの
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class poiApplication extends SpringBootServletInitializer {
  public static void main(String[] args) throws Exception {
    SpringApplication.run(poiApplication.class, args);
  }
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(poiApplication.class);
	}
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new ServletContainerCustomizer();
	}
	private static class ServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, UrlConstant.Controller.Error.NOT_FOUND));
			container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, UrlConstant.Controller.Error.NOT_FOUND));
			container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, UrlConstant.Controller.Error.NOT_FOUND));
			container.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, UrlConstant.Controller.Error.NOT_FOUND));
			container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, UrlConstant.Controller.Error.SYSTEM_ERROR));
			container.addErrorPages(new ErrorPage(Throwable.class, UrlConstant.Controller.Error.SYSTEM_ERROR));
		}

	}

}
