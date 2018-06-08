package samples.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtil {
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy-MM-dd */
	public static final int DASH_DATE_TYPE = 0;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy/MM/dd */
	public static final int SLASH_DATE_TYPE = 1;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyyMMdd */
	public static final int EMPTY_DATE_TYPE = 2;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy�� MM�� dd�� */
	public static final int KOR_DATE_TYPE = 3;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy.MM.dd */
	public static final int DOT_DATE_TYPE = 4;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy MM dd */
	public static final int BLANK_DATE_TYPE = 5;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyyMMdd HHmmss */
	public static final int DATE_TIME_TYPE = 6;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyyMMdd HHmmssSSS */
	public static final int MILL_DATE_TIME_TYPE = 7;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyy/MM/dd HH:mm:ss.SSS */
	public static final int MILL_DATE_TIME_TYPE2 = 8;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyyMMddHHmmssSSS */
	public static final int EMPTY_MILL_DATE_TIME_TYPE = 9;
	/** ���ڹ��ڿ� ������ ��Ÿ���� ��� : yyyyMMddHHmm */
	public static final int EMPTY_MILL_DATE_TIME_TYPE2 = 10;

	/** �ð����ڿ� ������ ��Ÿ���� ��� : HH:mm:ss */
	public static final int FULL_TIME_TYPE = 0;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : HH:mm */
	public static final int MIN_TIME_TYPE = 1;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : HH */
	public static final int HOUR_TIME_TYPE = 2;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : a hh:mm:ss */
	public static final int AMPM_TIME_TYPE = 3;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : a hh:mm */
	public static final int AMPM_MIN_TIME_TYPE = 4;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : a hh */
	public static final int AMPM_HOUR_TIME_TYPE = 5;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : HHmmss */
	public static final int NOCOLON_TIME_TYPE = 6;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : HHmmssSSS */
	public static final int NOCOLON_MS_TIME_TYPE = 7;
	/** �ð����ڿ� ������ ��Ÿ���� ��� : HHmm */
	public static final int NOCOLON_HHMM_TYPE = 8;

	/** ���� ��ȯ ���� ���� */
	private static final String FORMAT_LIST_DATE[] = { "yyyy-MM-dd", "yyyy/MM/dd", "yyyyMMdd", "yyyy�� MM�� dd��",
			"yyyy.MM.dd", "yyyy MM dd", "yyyyMMdd HHmmss", "yyyyMMdd HHmmssSSS", "yyyy/MM/dd HH:mm:ss.SSS",
			"yyyyMMddHHmmssSSS", "yyyyMMddHHmm" };

	/** �ð� ��ȯ ���� ���� */
	private static final String FORMAT_LIST_TIME[] = { "HH:mm:ss", "HH:mm", "HH", "a hh:mm:ss", "a hh:mm", "a hh",
			"HHmmss", "HHmmssSSS", "HHmm" };

	/**
	 * �⺻ TimeZone�� Locale�� �̿��Ͽ� GregorialCalendar�� �����Ѵ�.
	 *
	 * @return GregorialCalendar�� �����Ѵ�.
	 */
	public static GregorianCalendar getGregorianCalendar() {
		return new GregorianCalendar(TimeZone.getDefault(), Locale.getDefault());
	}

	/**
	 * ������ ��ȿ�� ���� �Ѵ�.
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
	 * ���޵� ���ڿ��� ��ȿ�� �������� �Ǵ��Ѵ�.
	 *
	 * @param inString
	 *            (required) �˻��� ���ڿ�
	 * @param format
	 *            (required) <br>
	 *            ����
	 * @return ��ȿ�� �������� ����
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
	 * ���޵� ���ڿ��� ��ȿ�� �������� �Ǵ��Ѵ�.
	 *
	 * @param inString
	 *            (required) �˻��� ���ڿ�
	 * @param format
	 *            (required) <br>
	 *            ����
	 * @return ��ȿ�� �������� ����
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
	 * System-time(millisecond����)�� ����ȭ�� ���ڿ��� ��ȯ�Ѵ�.
	 *
	 * @param milliseconds
	 *            (required) �Է��� milliseconds
	 * @param pattern
	 *            (required) ����� ��������
	 * @return ���Ͽ� ���߾� ��ȯ�� ���ڿ�
	 */
	public static String getString(long milliseconds, String pattern) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(milliseconds);
		return new SimpleDateFormat(pattern).format(calendar.getTime()).toString();
	}

	/**
	 * ���޵� ������ ���������� �Ǵ��Ѵ�.
	 *
	 * @param strYear
	 *            (required) �Ǵ��� ����, 4�ڸ� ���ڿ� (��: "2000")
	 * @return ������ ��� <code>true</code>�� ����
	 */
	public static boolean isLeapYear(String strYear) {
		int year = Integer.parseInt(strYear);
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
	}

	/**
	 * �Էµ� ������ ���������� �Ǵ��Ѵ�.
	 *
	 * @param year
	 *            (required) �Ǵ��� ����, int �� (��: 2000)
	 * @return ������ ��� <code>true</code>�� ����
	 */
	public static boolean isLeapYear(int year) {
		return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) ? true : false;
	}

	/**
	 * �־��� ��¥�� ���� �������� �˷��ش�.
	 *
	 * @param year
	 *            (required) ����, int �� (�� : 2012)
	 * @param month
	 *            (required) ��, int �� (�� : 12)
	 * @param day
	 *            (required) ��, int �� (�� : 3)
	 * @return ������ int ������ ������ (�Ͽ��� : 1, ������ : 2, ... , ����� : 7)
	 */
	public static int getDayOfTheWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * �־��� ��¥�� ���� �������� �˷��ش�.
	 *
	 * @param date
	 *            (required) ��¥, 8�ڸ� String (�� : "20121225")
	 * @return ������ int ������ ������(�Ͽ��� : 1, ������ : 2, ... , ����� : 7)
	 */
	public static int getDayOfTheWeek(String date) {
		return getDayOfTheWeek(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)));
	}

	/**
	 * ���糯¥�� �־��� �������� �����Ѵ�.
	 *
	 * @param format
	 *            (required) <br>
	 *            ����
	 * @return String�� ��ȯ�� ��
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
	 * �־��� �ð��� ������ �������� ��ȯ�Ͽ� �����Ѵ�.
	 *
	 * @param timeStamp
	 * @param format
	 *            (required)
	 * @return String�� ��ȯ�� ��¥
	 */
	public static String getDate(long timeStamp, int format) {
		if (format >= FORMAT_LIST_DATE.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		return simpledateformat.format(timeStamp);
	}

	/**
	 * �־��� ��¥�� ������ �������� ��ȯ�Ͽ� �����Ѵ�.
	 *
	 * @param date
	 *            (required) ���� ��¥, 8�ڸ� String (�� : "20120301")
	 * @param format
	 *            (required)
	 * @return String�� ��ȯ�� ��¥
	 */
	public static String getDate(String date, int format) {
		return getDate(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)),
				Integer.parseInt(date.substring(6)), format);
	}

	/**
	 * �־��� ��¥�� ������ �������� ��ȯ�Ͽ� �����Ѵ�.
	 *
	 * @param year
	 *            (required) ����, int �� (�� : 2012 )
	 * @param month
	 *            (required) ��, int �� (�� : 3 )
	 * @param day
	 *            (required) ��, int �� (�� : 1 )
	 * @param format
	 *            (required)
	 * @return String�� ��ȯ�� ��¥
	 */
	public static String getDate(int year, int month, int day, int format) {
		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_DATE[format]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		simpledateformat.setCalendar(calendar);
		return simpledateformat.format(simpledateformat.getCalendar().getTime());
	}

	/**
	 * ����ð��� �־��� �������� �����Ѵ�.
	 *
	 * @param format
	 *            (required)
	 * @return String�� ��ȯ�� ��
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
	 * �־��� �ð��� ������ �������� ��ȯ�Ͽ� �����Ѵ�.
	 *
	 * @param timeStamp
	 * @param format
	 *            (required)
	 * @return String�� ��ȯ�� �ð�
	 */
	public static String getTime(long timeStamp, int format) {
		if (format >= FORMAT_LIST_TIME.length || format < 0) {
			return null;
		}

		SimpleDateFormat simpledateformat = new SimpleDateFormat(FORMAT_LIST_TIME[format]);
		return simpledateformat.format(timeStamp);
	}

	/**
	 * ����ð��� mill seconds���� ���Ͽ� Long������ ��ȯ
	 *
	 * @return
	 */
	public static long getTimeStamp() {
		return System.currentTimeMillis();
	}

	/**
	 * ���޵� ���ڿ��� ��ȯ�Ͽ� mill seconds�� ��ȯ
	 *
	 * @param inString
	 *            (required) �˻��� ���ڿ�
	 * @param format
	 *            (required) <br>
	 *            ����
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
	 * ���� �⵵�� ����
	 *
	 * @return
	 */
	public static String getYear() {
		Calendar calendar = Calendar.getInstance();
		return getYear(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� �⵵�� ����
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
	 * ���� ���� ����
	 *
	 * @return
	 */
	public static String getMonth() {
		Calendar calendar = Calendar.getInstance();
		return getMonth(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� ���� ����
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
	 * ���� ���ڸ� ����
	 *
	 * @return
	 */
	public static String getDay() {
		Calendar calendar = Calendar.getInstance();
		return getDay(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� ���ڸ� ����
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
	 * ���� ������ ����
	 *
	 * @return
	 */
	public static String getWeek() {
		Calendar calendar = Calendar.getInstance();
		return getWeek(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� ������ ����
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
	 * ���� �ð����� �ø� ����
	 *
	 * @return
	 */
	public static String getHour() {
		Calendar calendar = Calendar.getInstance();
		return getHour(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� �ø� ����
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
	 * ���� �ð��� ���� ����
	 *
	 * @return
	 */
	public static String getMin() {
		Calendar calendar = Calendar.getInstance();
		return getMin(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� ���� ����
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
	 * ���� �ð����� �ʸ� ����
	 *
	 * @return
	 */
	public static String getSec() {
		Calendar calendar = Calendar.getInstance();
		return getSec(calendar.getTimeInMillis());
	}

	/**
	 * ������ �ð����� �ʸ� ����
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
