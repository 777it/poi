package poi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "poi")
public class PoiProperites {

	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Value("${server.contextPath}")
	private String contextPath;

	@Value("${server.session.timeout}")
	private int sessionTimeout;

	public String getContextPath() {
		return contextPath;
	}

	public boolean isProduct() {
		if(activeProfile.toLowerCase().equals("product")) {
			return true;
		}
		return false;
	}

	public int getSessionTimeout() {
		return sessionTimeout;
	}
}
