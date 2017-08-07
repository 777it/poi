package poi.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class TokenUtility {

	private static final Logger logger = LoggerFactory.getLogger(TokenUtility.class);

	/** Token Length. */
	private static int TOKEN_LENGTH = 16; // 16*2=32バイト

	private TokenUtility() {
		// privateコンストラクタ
	}

	public static final String createToken() {

		byte token[] = new byte[TOKEN_LENGTH];
		StringBuilder result = new StringBuilder();

		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			random.nextBytes(token);

			for (int i = 0; i < token.length; i++) {
				result.append(String.format("%02x", token[i]));
			}

		} catch (NoSuchAlgorithmException e) {
			return null;
		}

		logger.debug("Token値:" + result.toString());
		return result.toString();
	}
}
