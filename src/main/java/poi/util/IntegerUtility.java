package poi.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class IntegerUtility {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(IntegerUtility.class);

	private IntegerUtility() {
		// privateコンストラクタ
	}

	public static final Integer toInteger(final String str) {
		if(StringUtils.isEmpty(str)) {
			return null;
		}
		if(NumberUtils.isNumber(str)) {
			return Integer.parseInt(str);
		} else {
			return null;
		}
	}

	public static final String toString(final Integer id) {
		if(id == null) {
			return "";
		}
		return id.toString();
	}

}
