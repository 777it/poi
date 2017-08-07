package poi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.MappedInterceptor;

import poi.SessionInterceptor;

@Configuration
public class WebApplicationConfiguration {
	@Bean
	public SessionInterceptor sessionInterceptor() {
		return new SessionInterceptor();
	}

	@Bean
	public MappedInterceptor interceptor() {
		return new MappedInterceptor(new String[] { "/member/**" }, sessionInterceptor());
	}

	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(sessionInterceptor()).addPathPatterns("/member/**");
			}
		};
	}
}