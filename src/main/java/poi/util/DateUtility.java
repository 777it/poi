package poi.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class DateUtility {

	private static final Logger logger = LoggerFactory.getLogger(DateUtility.class);

//	public static final String yyyyMMddHHmmssSSSSSS = "yyyyMMddHHmmssSSSSSS";
//	public static final String yyyyMMddHHmmssSSSSSS_FORMAT1 = "yyyy/MM/dd HH:mm:ss.SSSSSS";
	public static final String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
	public static final String yyyyMMddHHmmssSSS_FORMAT1 = "yyyy/MM/dd HH:mm:ss.SSS";
	public static final String yyyyMMddHHmmss = "yyyyMMddHHmmss";
	public static final String yyyyMMddHHmmss_FORMAT1 = "yyyy/MM/dd HH:mm:ss";
	public static final String yyyyMMddHHmm = "yyyy/MM/dd HH:mm";
	public static final String yyyyMMdd = "uuuu/MM/dd";
	public static final String yyyyMMdd_FORMAT1 = "uuuuMMdd";
	public static final String yyyyMMdd_FORMAT2 = "M月d日";

	private DateUtility() {
		// privateコンストラクタ
	}

	/**
	 * 現在日時を取得する.
	 * 
	 * @return 現在日時
	 */
	public static final LocalDateTime now() {
		return LocalDateTime.now();
	}

	/**
	 * 指定のフォーマット形式の現在日時を取得する.
	 * 
	 * @return 現在日時
	 */
	public static final String now(final String format) {
		if(StringUtils.isEmpty(format)) {
			return null;
		}
		LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return DateUtility.now().format(formatter);
	}

	/**
	 * 日付型を文字列型に変換する.
	 * 
	 * @param localDateTime
	 * @return 文字列
	 */
	public static final String toString(final LocalDateTime localDateTime) {
//		if (localDateTime == null) {
//			return "";
//		}
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(yyyyMMddHHmmssSSSSSS);
//		return formatter.format(localDateTime);
		return format(localDateTime, yyyyMMddHHmmssSSS);
	}

	/**
	 * 日付型を文字列型に変換する.
	 * 
	 * @param localDateTime
	 * @param format
	 * @return 文字列
	 */
	public static final String format(final LocalDateTime localDateTime, final String format) {
		if (localDateTime == null || StringUtils.isEmpty(format)) {
			return "";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter.format(localDateTime);
	}

	/**
	 * 文字列を日付型に変換する.
	 * 
	 * @param text
	 *            文字列
	 * @param format
	 *            フォーマット
	 * @return 日付型
	 */
	public static final LocalDateTime toLocalDateTime(final String text) {
		if (StringUtils.isEmpty(text) || text.length() != 17) {
			return null;
		}
		final String format = yyyyMMddHHmmss;

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		int len = text.length();
		LocalDateTime result = LocalDateTime.parse(text.substring(0, len-3),  dtf);
		int millis = Integer.parseInt(text.substring(len-3, len));
		result = result.plus(millis, ChronoUnit.MILLIS);
		return result;
	}

	/**
	 * 文字列を日付型に変換する.
	 * 
	 * @param text
	 *            文字列
	 * @param format
	 *            フォーマット
	 * @return 日付型
	 */
	public static final LocalDateTime toLocalDateTime(final String text, final String format) {
		if (StringUtils.isEmpty(text)) {
			return null;
		}
		logger.debug("時間文字列:" + text);
		logger.debug("フォーマット:" + format);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withResolverStyle(ResolverStyle.STRICT);
		LocalDateTime result = LocalDateTime.parse(text, formatter);
		logger.debug("日付型:" + result);
		return result;
	}

	/**
	 * 文字列と日付型の日付を比較する.<br>
	 * <pre>
	 * date1 < date2 : -1
	 * date1 > date2 : 1
	 * date1 = date2 : 0
	 * </pre>
	 * 
	 * @param date1
	 *            日付
	 * @param textDate2
	 *            文字列
	 * @return 日付型
	 */
	public static final int compareTo(final LocalDateTime date1, final String textDate2) {
		LocalDateTime date2 = DateUtility.toLocalDateTime(textDate2);
		return date1.compareTo(date2);
	}

	/**
	 * 文字列の日付を比較する.<br>
	 * <pre>
	 * date1 < date2 : -1
	 * date1 > date2 : 1
	 * date1 = date2 : 0
	 * </pre>
	 * 
	 * @param date1
	 *            文字列
	 * @param date2
	 *            文字列
	 * @param format フォーマット
	 * @return 日付型
	 */
	public static final int compareTo(final String textDate1, final String textDate2, final String format) {
		LocalDateTime date1 = DateUtility.toLocalDateTime(textDate1, format);
		LocalDateTime date2 = DateUtility.toLocalDateTime(textDate2, format);
		return date1.compareTo(date2);
	}

	/**
	 * 指定した日数を日付に加算する。
	 * 
	 * @param date 日付
	 * @param days 日数
	 * @return 日付+日数
	 */
	public static final String addDay(final String date, final int days, final String inputFormat, final String outputFormat) {
		if(StringUtils.isEmpty(date) || date.length() != inputFormat.length()) {
			return date;
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(inputFormat).withResolverStyle(ResolverStyle.STRICT);
		LocalDate localDate = LocalDate.parse(date, formatter);
		LocalDate addLocalDate = localDate.plusDays(days);

		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(outputFormat);
		return formatter2.format(addLocalDate);
	}

	/**
	 * 指定日から7日前（1週間前）の日付を取得する.
	 * @param startDay
	 * @return 7日前（1週間前）の日付
	 */
	public static final String get7DaysAgo(final String startDay) {
		return DateUtility.addDay(startDay, -6, DateUtility.yyyyMMdd, DateUtility.yyyyMMdd);
	}

	/**
	 * 指定した日を最終日として1周間分の日付を取得する.
	 * @param startDay 日付
	 * @return 1周間分の日付（M月d日のフォーマット）
	 */
	public static final List<String> getAWeekWithLastDay(final String startDay) {
		List<String> result = new ArrayList<>();

		String days7 = DateUtility.get7DaysAgo(startDay);
		for(int i=0; i<=6; i++) {
			result.add(addDay(days7, i, yyyyMMdd, yyyyMMdd_FORMAT2));
		}
		return result;
	}

}
