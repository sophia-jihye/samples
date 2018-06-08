package samples.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	/** 날자문자열 유형을 나타내는 상수 : yyyy-MM-dd */
	public static final int DASH_DATE_TYPE = 0;
	/** 날자문자열 유형을 나타내는 상수 : yyyy/MM/dd */
	public static final int SLASH_DATE_TYPE = 1;
	/** 날자문자열 유형을 나타내는 상수 : yyyyMMdd */
	public static final int EMPTY_DATE_TYPE = 2;
	/** 날자문자열 유형을 나타내는 상수 : yyyy년 MM월 dd일 */
	public static final int KOR_DATE_TYPE = 3;
	/** 날자문자열 유형을 나타내는 상수 : yyyy.MM.dd */
	public static final int DOT_DATE_TYPE = 4;
	/** 날자문자열 유형을 나타내는 상수 : yyyy MM dd */
	public static final int BLANK_DATE_TYPE = 5;
	/** 날자문자열 유형을 나타내는 상수 : yyyyMMdd HHmmss */
	public static final int DATE_TIME_TYPE = 6;
	/** 날자문자열 유형을 나타내는 상수 : yyyyMMdd HHmmssSSS */
	public static final int MILL_DATE_TIME_TYPE = 7;
	/** 날자문자열 유형을 나타내는 상수 : yyyy/MM/dd HH:mm:ss.SSS */
	public static final int MILL_DATE_TIME_TYPE2 = 8;
	/** 날자문자열 유형을 나타내는 상수 : yyyyMMddHHmmssSSS */
	public static final int EMPTY_MILL_DATE_TIME_TYPE = 9;
	/** 날자문자열 유형을 나타내는 상수 : yyyyMMddHHmm */
	public static final int EMPTY_MILL_DATE_TIME_TYPE2 = 10;

	/** 시간문자열 유형을 나타내는 상수 : HH:mm:ss */
	public static final int FULL_TIME_TYPE = 0;
	/** 시간문자열 유형을 나타내는 상수 : HH:mm */
	public static final int MIN_TIME_TYPE = 1;
	/** 시간문자열 유형을 나타내는 상수 : HH */
	public static final int HOUR_TIME_TYPE = 2;
	/** 시간문자열 유형을 나타내는 상수 : a hh:mm:ss */
	public static final int AMPM_TIME_TYPE = 3;
	/** 시간문자열 유형을 나타내는 상수 : a hh:mm */
	public static final int AMPM_MIN_TIME_TYPE = 4;
	/** 시간문자열 유형을 나타내는 상수 : a hh */
	public static final int AMPM_HOUR_TIME_TYPE = 5;
	/** 시간문자열 유형을 나타내는 상수 : HHmmss */
	public static final int NOCOLON_TIME_TYPE = 6;
	/** 시간문자열 유형을 나타내는 상수 : HHmmssSSS */
	public static final int NOCOLON_MS_TIME_TYPE = 7;
	/** 시간문자열 유형을 나타내는 상수 : HHmm */
	public static final int NOCOLON_HHMM_TYPE = 8;

	/** 날자 변환 포맷 종류 */
	private static final String FORMAT_LIST_DATE[] = { "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMdd", "yyyy년 MM월 dd일",
			"yyyy.MM.dd", "yyyy MM dd", "yyyyMMdd HHmmss", "yyyyMMdd HHmmssSSS", "yyyy/MM/dd HH:mm:ss.SSS",
			"yyyyMMddHHmmssSSS", "yyyyMMddHHmm" };

	/** 시간 변환 포맷 종류 */
	private static final String FORMAT_LIST_TIME[] = { "HH:mm:ss", "HH:mm", "HH", "a hh:mm:ss", "a hh:mm", "a hh",
			"HHmmss", "HHmmssSSS", "HHmm" };

	/**
	 * 기본 TimeZone과 Locale을 이용하여 GregorialCalendar를 생성한다.
	 *
	 * @return GregorialCalendar를 리턴한다.
	 */
	public static GregorianCalendar getGregorianCalendar() {
		return new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
	}

	/**
	 * 일자의 유효성 검증 한다.
	 *
	 * @param inString
	 * @return true if this date is valid; otherwise false
	 */
	// public static boolean isValidDate(String inString) {
	// // Check if input is empty
	// if (StringUtil.isEmpty(inString)) {
	// return false;
	// }
	//
	// try {
	// SimpleDateFormat format = new
	// SimpleDateFormat(FORMAT_LIST_DATE[EMPTY_DATE_TYPE],
	// java.util.Locale.KOREA);
	// Date dt = format.parse(inString);
	// return format.format(dt).equals(inString);
	// } catch (ParseException ex) {
	// return false;
	// }
	// }

	/**
	 * 전달된 문자열이 유효할 날자인지 판단한다.
	 *
	 * @param inString
	 *            (required) 검사할 문자열
	 * @param format
	 *            (required) <br>
	 *            포맷
	 * @return 유효할 날자인지 여부
	 */
	public static boolean isValidDate(String inString, int format) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		if (inString.length() != simpledateformat.toPattern().length()) {
			return false;
		}

		simpledateformat.setLenient(false);
		try {
			simpledateformat.parse(inString);
		} catch (ParseException ex) {
			return false;
		}

		return true;
	}

	/**
	 * 전달된 문자열이 유효할 날자인지 판단한다.
	 *
	 * @param inString
	 *            (required) 검사할 문자열
	 * @param format
	 *            (required) <br>
	 *            포맷
	 * @return 유효할 날자인지 여부
	 */
	public static boolean isValidDate(String inString, String format) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
		if (inString.length() != simpledateformat.toPattern().length()) {
			return false;
		}

		simpledateformat.setLenient(false);
		try {
			simpledateformat.parse(inString);
		} catch (ParseException ex) {
			return false;
		}

		return true;
	}

	/**
	 * System-time(millisecond단위)를 형식화된 문자열로 변환한다.
	 *
	 * @param milliseconds
	 *            (required) 입력할 milliseconds
	 * @param pattern
	 *            (required) 사용할 포맷패턴
	 * @return 패턴에 맞추어 변환된 문자열
	 */
	public static String getString(long milliseconds, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return new SimpleDateFormat(pattern).format(calendar.getTime()).toString();
	}

	/**
	 * 전달된 연도가 윤년인지를 판단한다.
	 *
	 * @param strYear
	 *            (required) 판단할 연도, 4자리 문자열 (예: "2000")
	 * @return 윤년일 경우 <code>true</code>를 리턴
	 */
	public static boolean isLeapYear(String strYear) {
		int year = Integer.parseInt(strYear);
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
	}

	/**
	 * 입력된 연도가 윤년인지를 판단한다.
	 *
	 * @param year
	 *            (required) 판단할 연도, int 값 (예: 2000)
	 * @return 윤년일 경우 <code>true</code>를 리턴
	 */
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
	}

	/**
	 * 주어진 날짜가 무슨 요일인지 알려준다.
	 *
	 * @param year
	 *            (required) 연도, int 값 (예 : 2012)
	 * @param month
	 *            (required) 월, int 값 (예 : 12)
	 * @param day
	 *            (required) 일, int 값 (예 : 3)
	 * @return 요일을 int 값으로 돌려줌 (일요일 : 1, 월요일 : 2, ... , 토요일 : 7)
	 */
	public static int getDayOfTheWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 주어진 날짜가 무슨 요일인지 알려준다.
	 *
	 * @param date
	 *            (required) 날짜, 8자리 String (예 : "20121225")
	 * @return 요일을 int 값으로 돌려줌(일요일 : 1, 월요일 : 2, ... , 토요일 : 7)
	 */
	public static int getDayOfTheWeek(String date) {
		return getDayOfTheWeek(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)));
	}

	/**
	 * 현재날짜를 주어진 포맷으로 리턴한다.
	 *
	 * @param format
	 *            (required) <br>
	 *            포맷
	 * @return String로 변환된 값
	 */
	public static String getCurrentDate(int format) {
		if (format >= FORMAT_LIST_DATE.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		Calendar calendar = Calendar.getInstance();
		simpledateformat.setCalendar(calendar);
		return simpledateformat.format(simpledateformat.getCalendar().getTime());
	}

	/**
	 * 주어진 시간을 지정된 포맷으로 변환하여 리턴한다.
	 *
	 * @param timeStamp
	 * @param format
	 *            (required)
	 * @return String로 변환된 날짜
	 */
	public static String getDate(long timeStamp, int format) {
		if (format >= FORMAT_LIST_DATE.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		return simpledateformat.format(timeStamp);
	}

	/**
	 * 주어진 날짜를 지정된 포맷으로 변환하여 리턴한다.
	 *
	 * @param date
	 *            (required) 기준 날짜, 8자리 String (예 : "20120301")
	 * @param format
	 *            (required)
	 * @return String로 변환된 날짜
	 */
	public static String getDate(String date, int format) {
		return getDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)), format);
	}

	/**
	 * 주어진 날짜를 지정된 포맷으로 변환하여 리턴한다.
	 *
	 * @param year
	 *            (required) 연도, int 값 (예 : 2012 )
	 * @param month
	 *            (required) 월, int 값 (예 : 3 )
	 * @param day
	 *            (required) 일, int 값 (예 : 1 )
	 * @param format
	 *            (required)
	 * @return String로 변환된 날짜
	 */
	public static String getDate(int year, int month, int day, int format) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		simpledateformat.setCalendar(calendar);
		return simpledateformat.format(simpledateformat.getCalendar().getTime());
	}

	/**
	 * 현재시간을 주어진 포맷으로 리턴한다.
	 *
	 * @param format
	 *            (required)
	 * @return String로 변환된 값
	 */
	public static String getCurrentTime(int format) {
		if (format >= FORMAT_LIST_TIME.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_TIME[format]);
		Calendar calendar = Calendar.getInstance();
		simpledateformat.setCalendar(calendar);
		return simpledateformat.format(simpledateformat.getCalendar().getTime());
	}

	/**
	 * 주어진 시간을 지정된 포맷으로 변환하여 리턴한다.
	 *
	 * @param timeStamp
	 * @param format
	 *            (required)
	 * @return String로 변환된 시간
	 */
	public static String getTime(long timeStamp, int format) {
		if (format >= FORMAT_LIST_TIME.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_TIME[format]);
		return simpledateformat.format(timeStamp);
	}

	/**
	 * 현재시간을 mill seconds까지 구하여 Long값으로 반환
	 *
	 * @return
	 */
	public static long getTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * 전달된 문자열을 변환하여 mill seconds를 반환
	 *
	 * @param inString
	 *            (required) 검사할 문자열
	 * @param format
	 *            (required) <br>
	 *            포맷
	 * @return
	 */
	public static long getTimeStamp(String inString, int format) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		if (inString.length() != simpledateformat.toPattern().length()) {
			return 0;
		}

		simpledateformat.setLenient(false);
		try {
			simpledateformat.parse(inString);
			return simpledateformat.getCalendar().getTimeInMillis();
		} catch (ParseException ex) {
			return 0;
		}
	}

	/**
	 * 현재 년도를 구함
	 *
	 * @return
	 */
	public static String getYear() {
		Calendar calendar = Calendar.getInstance();
		return getYear(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 년도를 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getYear(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%04d", now.get(Calendar.YEAR));
	}

	/**
	 * 현재 월을 구함
	 *
	 * @return
	 */
	public static String getMonth() {
		Calendar calendar = Calendar.getInstance();
		return getMonth(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 월을 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getMonth(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%02d", now.get(Calendar.MONTH) + 1);
	}

	/**
	 * 현재 일자를 구함
	 *
	 * @return
	 */
	public static String getDay() {
		Calendar calendar = Calendar.getInstance();
		return getDay(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 일자를 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getDay(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%02d", now.get(Calendar.DATE));
	}

	/**
	 * 현재 요일을 구함
	 *
	 * @return
	 */
	public static String getWeek() {
		Calendar calendar = Calendar.getInstance();
		return getWeek(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 요일을 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getWeek(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%d", now.get(Calendar.DAY_OF_WEEK));
	}

	/**
	 * 현재 시간에서 시를 구함
	 *
	 * @return
	 */
	public static String getHour() {
		Calendar calendar = Calendar.getInstance();
		return getHour(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 시를 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getHour(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%02d", now.get(Calendar.HOUR_OF_DAY));
	}

	/**
	 * 현재 시간의 분을 구함
	 *
	 * @return
	 */
	public static String getMin() {
		Calendar calendar = Calendar.getInstance();
		return getMin(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 분을 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getMin(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%02d", now.get(Calendar.MINUTE));
	}

	/**
	 * 현재 시간에서 초를 구함
	 *
	 * @return
	 */
	public static String getSec() {
		Calendar calendar = Calendar.getInstance();
		return getSec(calendar.getTimeInMillis());
	}

	/**
	 * 지정된 시간에서 초를 구함
	 *
	 * @param timeStamp
	 * @return
	 */
	public static String getSec(long timeStamp) {
		Calendar now = Calendar.getInstance();
		now.setTimeInMillis(timeStamp);
		return String.format("%02d", now.get(Calendar.SECOND));
	}
}
