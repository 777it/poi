package poi.util;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class BooleanUtility {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(BooleanUtility.class);

	private BooleanUtility() {
		// privateコンストラクタ
	}

	public static final Boolean toBoolean(final String str) {
		if(StringUtils.isEmpty(str)) {
			return false;
		}
		if(NumberUtils.isNumber(str)) {
			return BooleanUtils.toBoolean(Integer.parseInt(str));
		} else {
			return BooleanUtils.toBoolean(str);
		}
	}

}
