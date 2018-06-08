package samples.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
	/** folder separator */
	private static final String FOLDER_SEPARATOR = "/";

	/**
	 * 문자열이 빈문자열인지 판단한다. 전달된 문자열이 <code>null</code>이거나 길이가 0인 문자열 또는 공백문자로만 채워쳐
	 * 있는 경우 빈문자열로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(final CharSequence str) {
		if (null == str) {
			return true;
		}

		for (int i = 0, n = str.length(); i < n; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 문자열이 빈문자열인지 판단한다.
	 * 전달된 문자열이 <code>null</code>이거나 길이가 0인 문자열 또는 공백문자로만 채워쳐 있는 경우 빈문자열로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		String value = (str != null) ? str.trim() : str;
		return isEmpty((CharSequence) value);
	}

	/**
	 * Object가 null인지 판단한다.
	 *
	 * @param obj
	 * @return boolean
	 */
	public boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * 문자열의 길이가 있는지 판단한다. 전달된 문자열이 <code>null</code>이 아니고 길이가 0보다 큰 경우 길이가 있는
	 * 것으로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * 문자열의 길이가 있는지 판단한다. 전달된 문자열이 <code>null</code>이 아니고 길이가 0보다 큰 경우 길이가 있는
	 * 것으로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasLength(CharSequence)
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	/**
	 * 문자열의 내용이 있는지 판단한다. 전달된 문자열이 <code>null</code>이 아니고 길이가 있어야하며 공백문자로만 채워져
	 * 있지 않아야 문자열에 내용이 있는 것으로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 * @see java.lang.Character#isWhitespace
	 */
	public static boolean hasText(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}

		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 문자열의 내용이 있는지 판단한다. 전달된 문자열이 <code>null</code>이 아니고 길이가 있어야하며 공백문자로만 채워져
	 * 있지 않아야 문자열에 내용이 있는 것으로 판단한다.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasText(CharSequence)
	 */
	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	/**
	 * 문자열에 공백문자가 있는지 판단한다. <code>null</code>이 아닌 길이가 있는 문자열에 공백문자가 있어야 공백문자를
	 * 포함하는 것으로 판단한다. 전달된 문자열이 <code>null</code>이거나 길이가 없는 경우도 공백문자를 포함하지 않은 것으로
	 * 판단한다.
	 *
	 * @param str
	 * @return boolean
	 * @see java.lang.Character#isWhitespace
	 */
	public static boolean hasWhiteSpace(CharSequence str) {
		if (!hasLength(str)) {
			return false;
		}

		int strLen = str.length();
		for (int i = 0; i < strLen; i++) {
			if (Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 문자열에 공백문자가 있는지 판단한다. <code>null</code>이 아닌 길이가 있는 문자열에 공백문자가 있어야 공백문자를
	 * 포함하는 것으로 판단한다. 전달된 문자열이 <code>null</code>이거나 길이가 없는 경우도 공백문자를 포함하지 않은 것으로
	 * 판단한다.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasWhiteSpace(CharSequence)
	 */
	public static boolean hasWhiteSpace(String str) {
		return hasWhiteSpace((CharSequence) str);
	}

	/**
	 * 문자열의 앞부분과 뒷부분에 있는 공백문자를 모두 제거한다. 문자열 중간에 있는 공백문자는 제거되지 않는다.
	 *
	 * @param str
	 * @return the trimmed String
	 */
	public static String trimWhiteSpace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}

		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	/**
	 * 문자열에 포함된 모든 공백문자를 제거한다.
	 *
	 * @param str
	 * @return the trimmed String
	 */
	public static String trimAllWhiteSpace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		int index = 0;
		while (sb.length() > index) {
			if (Character.isWhitespace(sb.charAt(index))) {
				sb.deleteCharAt(index);
			} else {
				index++;
			}
		}

		return sb.toString();
	}

	/**
	 * 전달된 문자열의 앞부분에 포함된 공백문자를 제거한다. 문자열 중간에 있는 공백문자는 제거되지 않는다.
	 *
	 * @param str
	 * @return the trimmed String
	 */
	public static String trimLeadingWhiteSpace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(0))) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 전달된 문자열의 뒷부분에 포함된 공백문자를 제거한다. 문자열 중간에 있는 공백문자는 제거되지 않는다.
	 *
	 * @param str
	 * @return the trimmed String
	 */
	public static String trimTrailingWhiteSpace(String str) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && Character.isWhitespace(sb.charAt(sb.length() - 1))) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	/**
	 * 전달된 문자열의 앞부분에 특정 문자 <code>leadingChar</code>가 발견되면 반복적으로 이를 제거한다. 문자열 중간에
	 * 발견된 <quote>특정문자</quote>는 제거되지 않는다.
	 *
	 * 예) <blockquote> String string=
	 * StringUtil.trimLeadingCharacter("FFFCFW001", 'F'); 결과 문자열 : "CFW001"
	 * </blockquote>
	 *
	 * @param str
	 *            the String to check
	 * @param leadingCharacter
	 *            the leading character to be trimmed
	 * @return the trimmed String
	 */
	public static String trimLeadingCharacter(String str, char leadingChar) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(0) == leadingChar) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 전달된 문자열의 뒷부분에 특정 문자 <code>leadingChar</code>가 발견되면 반복적으로 이를 제거한다. 문자열 중간에
	 * 발견된 <quote>특정문자</quote>는 제거되지 않는다.
	 *
	 * 예) <blockquote> String string=
	 * StringUtil.trimLeadingCharacter("CFW001FCFFF", 'F'); 결과 문자열 : "CFW001FC"
	 * </blockquote>
	 *
	 * @param str
	 *            the String to check
	 * @param trailingCharacter
	 *            the trailing character to be trimmed
	 * @return the trimmed String
	 */
	public static String trimTrailingCharacter(String str, char trailingChar) {
		if (!hasLength(str)) {
			return str;
		}

		StringBuilder sb = new StringBuilder(str);
		while (sb.length() > 0 && sb.charAt(sb.length() - 1) == trailingChar) {
			sb.deleteCharAt(sb.length() - 1);
		}

		return sb.toString();
	}

	/**
	 * 전달된 문자열이 특정문자열 <code>prefix</code>로 시작하는지를 판단한다. 비교할 특정문자열의 모든 문자는 대소문자를
	 * 구분하지 않는다.
	 *
	 * 예) <blockquote> boolean isStartsWithFWC=
	 * StringUtil.startsWithIgnoreCase("FWC001SVC", "FWC"); boolean
	 * isStartsWithfwC= StringUtil.startsWithIgnoreCase("FWC001SVC:, :"fwC"); //
	 * isStartsWithFWC와 isStartsWithfwc 모두 true 이다. </blockquote>
	 *
	 * @param str
	 *            the String to check
	 * @param prefix
	 *            the prefix to look for
	 * @return boolean
	 */
	public static boolean startWithIgnoreCase(String str, String prefix) {
		if (str == null || prefix == null) {
			return false;
		}
		if (str.startsWith(prefix)) {
			return true;
		}
		if (str.length() < prefix.length()) {
			return false;
		}

		String lcStr = str.substring(0, prefix.length()).toLowerCase();
		String lcPrefix = prefix.toLowerCase();
		return lcStr.equals(lcPrefix);
	}

	/**
	 * 전달된 문자열이 특정문자열 <code>suffix</code>로 끝나는지를 판단한다. 비교할 특정문자열의 모든 문자는 대소문자를
	 * 구분하지 않는다.
	 *
	 * 예) <blockquote> boolean isEndsWithSVC =
	 * StringUtil.endsWithIgnoreCase("FWC001SVC", "SVC"); boolean isEndsWithsvC
	 * = StringUtil.endsWithIgnoreCase("FWC001SVC", "svC"); // isEndsWithSVC와
	 * isEndsWithsvC 모두 true 이다. </blockquote>
	 *
	 * @param str
	 *            the String to check
	 * @param suffix
	 *            the suffix to look for
	 * @return boolean
	 */
	public static boolean endWithIgnoreCase(String str, String suffix) {
		if (str == null || suffix == null) {
			return false;
		}
		if (str.endsWith(suffix)) {
			return true;
		}
		if (str.length() < suffix.length()) {
			return false;
		}

		String lcStr = str.substring(str.length() - suffix.length()).toLowerCase();
		String lcSuffix = suffix.toLowerCase();
		return lcStr.equals(lcSuffix);
	}

	/**
	 * 전달된 문자열 <code>str</code>이 특정 인덱스 <code>index</code>부터 비교할 문자열
	 * <code>substring</code> 전체를 포함하는지 판단한다.
	 *
	 * 예) <blockquote> boolean matched= StringUtil.substringMatch("FWC001SVC01",
	 * 3, "001SVC"); // matched 는 true 이다. </blockquote>
	 *
	 * @param str
	 *            the original string (or StringBuilder)
	 * @param index
	 *            the index in the original string to start matching against
	 * @param substring
	 *            the substring to match at the given index
	 * @return boolean
	 */
	public static boolean compareEqualSubString(CharSequence str, int index, CharSequence substring) {
		for (int j = 0; j < substring.length(); j++) {
			int i = index + j;
			if (i >= str.length() || str.charAt(i) != substring.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 전달된 문자열 <code>str</code>에 특정 문자열 <code>sub</code>이 몇 번 반복적으로 나타나는지를 검사한다.
	 *
	 * @param str
	 *            string to search in
	 * @param sub
	 *            string to search for
	 * @return int
	 */
	public static int countOccurrenceOf(String str, String sub) {
		if (str == null || sub == null || str.length() == 0 || sub.length() == 0) {
			return 0;
		}

		int count = 0;
		int pos = 0;
		int idx;
		while ((idx = str.indexOf(sub, pos)) != -1) {
			++count;
			pos = idx + sub.length();
		}

		return count;
	}

	/**
	 * 전달된 원본 문자열 <code>inString</code>에서 변경대상 문자열 <code>oldSubstring</code>을 찾아
	 * 변경할 문자열 <code>newSubstring</code>로 모두 변경한다.
	 *
	 * @param inString
	 *            String to examine
	 * @param oldPattern
	 *            String to replace
	 * @param newPattern
	 *            String to insert
	 * @return a String with the replacements
	 */
	public static String replace(String inString, String oldSubstring, String newSubstring) {
		if (!hasLength(inString) || !hasLength(oldSubstring) || newSubstring == null) {
			return inString;
		}

		StringBuilder sb = new StringBuilder();
		int pos = 0;
		int index = inString.indexOf(oldSubstring);
		int patLen = oldSubstring.length();
		while (index >= 0) {
			sb.append(inString.substring(pos, index));
			sb.append(newSubstring);
			pos = index + patLen;
			index = inString.indexOf(oldSubstring, pos);
		}
		sb.append(inString.substring(pos));

		return sb.toString();
	}

	/**
	 * 전달된 원본 문자열 <code>inString</code>에서 특정 문자열 <code>toDeleteSubstring</code>을
	 * 모두 제거한다.
	 *
	 * @param inString
	 *            the original String
	 * @param pattern
	 *            the pattern to delete all occurrences of
	 * @return the resulting String
	 */
	public static String delete(String inString, String toDeleteSubstring) {
		return replace(inString, toDeleteSubstring, "");
	}

	/**
	 * 전달된 문자열을 작은 따옴표(')로 감싼 형태로 변경한다.
	 *
	 * @param str
	 *            the input String (e.g. "myString")
	 * @return the quoted String (e.g. "'myString'"), or <code>null</code> if
	 *         the input was <code>null</code>
	 */
	public static String quote(String str) {
		return str != null ? "'" + str + "'" : null;
	}

	/**
	 * 경로를 모두 포함한 이름(qualified name) <code>qualifiedName</code>에서 경로구분 문자로
	 * 온점(.)을 사용하여 경로부분을 제거한다. 패키지명을 포함하는 클래스명(fully qualified class name)에서
	 * 클래스명을 추출하는 용도로 사용될 수 있다.
	 *
	 * 예) <blockquote> String className= StringUtil.unqualify(
	 * "java.lang.String"); // 결과 문자열 : "String" </blockquote>
	 *
	 * @param qualifiedName
	 *            the qualified name
	 * @return the resulting String
	 */
	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	/**
	 * 경로를 모두 포함한 이름(qualified name) <code>qualifiedName</code>에서 경로구분 문자
	 * <code>separator</code>를 기준으로 경로부분을 제거한다.
	 *
	 * @param qualifiedName
	 *            the qualified name
	 * @param separator
	 *            the separator
	 * @return the resulting String
	 */
	public static String unqualify(String qualifiedName, char separator) {
		return qualifiedName.substring(qualifiedName.lastIndexOf(separator) + 1);
	}

	/**
	 * 전달된 파일 경로 <code>path</code>에서 파일이름을 추출한다.
	 *
	 * @param path
	 *            the file path (may be <code>null</code>)
	 * @return the extracted filename, or <code>null</code> if none
	 */
	public static String getFileName(String path) {
		if (path == null) {
			return null;
		}
		int separatorindex = path.lastIndexOf(FOLDER_SEPARATOR);
		return (separatorindex != -1) ? path.substring(separatorindex + 1) : path;
	}

	/**
	 * 전달된 원본 문자열 배열 <code>array</code>를 하나의 문자열로 합친다.
	 *
	 * @param array
	 *            the array to append to (can be <code>null</code>)
	 * @return the string (never <code>null</code>)
	 */
	public static String addString(String[] array) {
		if (ObjectUtil.isEmpty(array)) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		for (String str : array) {
			sb.append(str);
		}

		return sb.toString();
	}

	/**
	 * 전달된 원본 문자열 배열 <code>array</code>에 추가문자열 <code>str</code>을 추가한다.
	 *
	 * @param array
	 *            the array to append to (can be <code>null</code>)
	 * @param str
	 *            the String to append
	 * @return the new array (never <code>null</code>)
	 */
	public static String[] addStringToArray(String[] array, String str) {
		if (ObjectUtil.isEmpty(array)) {
			return new String[] { str };
		}

		String[] newArr = new String[array.length + 1];
		System.arraycopy(array, 0, newArr, 0, array.length);
		newArr[array.length] = str;
		return newArr;
	}

	/**
	 * 전달된 원본 문자열 배열 <code>array1</code>에 추가 문자열 배열 <code>array2</code>을 추가한다.
	 *
	 * @param array1
	 *            the first array (can be <code>null</code>)
	 * @param array2
	 *            the second array (can be <code>null</code>)
	 * @return the new array (<code>null</code> if both given arrays were
	 *         <code>null</code>)
	 */
	public static String[] concatenateStringArray(String[] array1, String[] array2) {
		if (ObjectUtil.isEmpty(array1)) {
			return array2;
		}
		if (ObjectUtil.isEmpty(array2)) {
			return array1;
		}

		String[] newArr = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, newArr, 0, array1.length);
		System.arraycopy(array2, 0, newArr, array1.length, array2.length);
		return newArr;
	}

	/**
	 * 전달된 원분 문자열 배열 <code>array1</code>에 병합할 문자열 배열 <code>array2</code>를 병합한다.
	 * 내용이 같은 문자열은 중복되지 않는다. 병합된 문자열 배열의 순서는 전달된 상태로 유지된다.
	 *
	 * @param array1
	 *            the first array (can be <code>null</code>)
	 * @param array2
	 *            the second array (can be <code>null</code>)
	 * @return the new array (<code>null</code> if both given arrays were
	 *         <code>null</code>)
	 */
	public static String[] mergeStringArray(String[] array1, String[] array2) {
		if (ObjectUtil.isEmpty(array1)) {
			return array2;
		}
		if (ObjectUtil.isEmpty(array2)) {
			return array1;
		}

		List<String> result = new ArrayList<String>();
		result.addAll(Arrays.asList(array1));
		for (String str : array2) {
			if (!result.contains(str)) {
				result.add(str);
			}
		}

		return getStringArray(result);
	}

	/**
	 * 전달된 문자열 배열 <code>array</code>을 정렬한다.
	 *
	 * @param array
	 * @return the sorted array (never <code>null</code>)
	 */
	public static String[] sortStringArray(String[] array) {
		if (ObjectUtil.isEmpty(array)) {
			return new String[0];
		}

		Arrays.sort(array);
		return array;
	}

	/**
	 * 전달된 Collection <code>collection</code>을 문자열 배열로 변환한다.
	 *
	 * @param collection
	 *            the Collection to copy
	 * @return the String array (<code>null</code> if the passed-in Collection
	 *         was <code>null</code> )
	 */
	public static String[] getStringArray(Collection<String> collection) {
		if (collection == null) {
			return new String[] {};
		}

		return collection.toArray(new String[collection.size()]);
	}

	/**
	 * 전달된 원본 문자열 <code>toSplit</code>를 기준 문자열 <code>delimiter</code>를 기준으로 앞,
	 * 뒤로 분할하여 길이가 2인 문자열 배열로 변환한다.
	 *
	 * 예) <blockquote> String[] splitted= StringUtil.split("FWC001SVCIn",
	 * "SVC"); // 결과 splitted[0] : "FWC001" // 결과 splitted[1] : "In"
	 * </blockquote>
	 *
	 * @param toSplit
	 *            the string to split
	 * @param delimiter
	 *            to split the string up with
	 * @return a two element array with index 0 being before the delimiter, and
	 *         index 1 being after the delimiter (neither element includes the
	 *         delimiter); or <code>null</code> if the delimiter wasn't found in
	 *         the given input String
	 */
	public static String[] split(String toSplit, String delimiter) {
		if (!hasLength(toSplit) || !hasLength(delimiter)) {
			return new String[] {};
		}

		int offset = toSplit.indexOf(delimiter);
		if (offset < 0) {
			return new String[] {};
		}

		String beforeDelimiter = toSplit.substring(0, offset);
		String afterDelimiter = toSplit.substring(offset + delimiter.length());
		return new String[] { beforeDelimiter, afterDelimiter };
	}

	/**
	 * 전달된 문자열 <code>str</code>을 <code>java.util.StringTokenizer</code>를 이용하여
	 * 분할(tokenize)한다. 기준 문자 집합 <code>delimiter</code>에 포한된 모든 문자는 문자 하나 하나가
	 * token을 나누는 기준으로 사용된다. <code>delimiter</code> 문자열 전체를 이용하여 문자열의 분할하기 위해서는
	 * <code>delimitedListToStringArray</code>를 사용한다. 분할된 문자열들은 공백이 제거된다. 길이가 0인
	 * 문자열은 결과 배열에 포함되지 않는다.
	 *
	 * 예) <blockquote> String[] splitted=
	 * StringUtil.tokenizeToStringArray("FWC001SVCIn", "SVC"); // 결과 문자열 배열 : {
	 * "FW", "001", "In"} </blockquote>
	 *
	 * @param str
	 *            the String to tokenize
	 * @param delimiters
	 *            the delimiter characters, assembled as String (each of those
	 *            characters is individually considered as delimiter).
	 * @return an array of the tokens
	 * @see java.util.StringTokenizer
	 * @see java.lang.String#trim()
	 * @see #delimitedListToStringArray
	 */
	public static String[] tokenizeToStringArray(String str, String delimiter) {
		return tokenizeToStringArray(str, delimiter, true, true);
	}

	/**
	 * 전달된 문자열 <code>str</code>을 <code>java.util.StringTokenizer</code>를 이용하여
	 * 분할(tokenize)한다. 기준 문자 집합 <code>delimiter</code>에 포한된 모든 문자는 문자 하나하나가
	 * token을 나누는 기준으로 사용된다. <code>delimiter</code> 문자열 전체를 이용하여 문자열의 분할하기 위해서는
	 * <code>delimitedListToStringArray</code>를 사용한다. 분할된 문자열들은 공백이 제거된다.
	 * <code>ignoreEmptyTokens</code>가 true인 경우 길이가 0인 문자열도 결과 배열에 포함된다.
	 *
	 * <blockquote> 예) String[] splitted=
	 * StringUtil.tokenizeToStringArray("FWC001SVCIn", "SVC"); // 결과 문자열 배열 : {
	 * "FW", "001", "In"} </blockquote>
	 *
	 * @param str
	 *            the String to tokenize
	 * @param delimiters
	 *            the delimiter characters, assembled as String (each of those
	 *            characters is individually considered as delimiter)
	 * @param trimTokens
	 *            trim the tokens via String's <code>trim</code>
	 * @param ignoreEmptyTokens
	 *            omit empty tokens from the result array (only applies to
	 *            tokens that are empty after trimming; StringTokenizer will not
	 *            consider subsequent delimiters as token in the first place).
	 * @return an array of the tokens (<code>null</code> if the input String was
	 *         <code>null</code>)
	 * @see java.util.StringTokenizer
	 * @see java.lang.String#trim()
	 * @see #delimitedListToStringArray
	 */
	public static String[] tokenizeToStringArray(String str, String delimiter, boolean trimTokens,
			boolean ignoreEmptyTokens) {

		if (str == null) {
			return new String[] {};
		}

		StringTokenizer st = new StringTokenizer(str, delimiter);
		List<String> tokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (trimTokens) {
				token = token.trim();
			}
			if (!ignoreEmptyTokens || token.length() > 0) {
				tokens.add(token);
			}
		}

		return getStringArray(tokens);
	}

	/**
	 * 전달된 문자열 <code>inString</code>이 숫자, 부호 등이 아닌 문자로만 구성되어 있는지 확인한다.
	 *
	 * 예) <blockquote> boolean isLetter= StringUtil.isLetter("FWC"); // 결과 :
	 * true boolean isLetter= StringUtil.isLetter("FWC001"); // 결과 : false
	 * boolean isLetter= StringUtil.isLetter("FWC-SVC"); // 결과 : false
	 * </blockquote>
	 *
	 * @param inString
	 *            the string to checked
	 * @return <code>true</code> if the inString is letter
	 */
	public static boolean isLetter(String inString) {
		if (inString == null) {
			return false;
		}

		char[] chars = inString.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetter(chars[i])) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 전달된 문자열 <code>inString</code>이 문자, 부호 등이 아닌 숫자로만 구성되어 있는지 확인한다.
	 *
	 * 예) <blockquote> boolean isDigit= StringUtil.isDigit("001"); // 결과 : true
	 * boolean isDigit= StringUtil.isDigit("FW001"); // 결과 : false boolean
	 * isDigit= StringUtil.isDigit("02-001"); // 결과 : false </blockquote>
	 *
	 * @param inString
	 *            the string to checked
	 * @return <code>true</code> if the inString is digit
	 */
	public static boolean isDigit(String inString) {
		if (inString == null) {
			return false;
		}

		char[] chars = inString.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isDigit(chars[i])) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 전달된 문자열 <code>inString</code>이 부호 등이 아닌 문자 또는 숫자로만 구성되어 있는지 확인한다.
	 *
	 * 예) <blockquote> boolean isLetterOrDigit=
	 * StringUtil.isLetterOrDigit("FWC001SVCIn"); // 결과 : true boolean
	 * isLetterOrDigit= StringUtil.isLetterOrDigit("FWC-001SVCIn"); // 결과 :
	 * false </blockquote>
	 *
	 * @param inString
	 *            the string to checked
	 * @return <code>true</code> if the inString is letter or digit
	 */
	public static boolean isLetterOrDigit(String inString) {
		if (inString == null) {
			return false;
		}

		char[] chars = inString.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (!Character.isLetterOrDigit(chars[i])) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 전달된 문자열 <code>string</code>이 공백 문자와 개행, 탭 으로만 구성되어 있는지 확인한다. trim의 결과로
	 * 길이가 0인 경우 공백으로만 구성되어 있는 것으로 간주한다.
	 *
	 * @param string
	 *            string to check
	 * @return <code>true</code> if the string is space
	 */
	public static boolean isSpace(String string) {
		if (string == null) {
			return false;
		}

		return string.trim().length() <= 0;
	}

	/**
	 * String 배열에서 첫번째 인자와 나머지 String이 같은지 검증
	 *
	 * @param strs
	 * @return
	 */
	public static boolean equals(final String... strs) {
		if (0 == size(strs)) {
			return true;
		}

		String iter = strs[0];
		for (String str : strs) {
			if (iter == str) {
				continue;
			}
			if (isEmpty(iter) && isEmpty(str)) {
				continue;
			}
			if (null == iter) {
				return false;
			} else if (!iter.equals(str)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Object 배열의 size
	 *
	 * @param objs
	 * @return
	 */
	public static int size(final Object[] objs) {
		if (null == objs) {
			return 0;
		}

		return objs.length;
	}

	/**
	 * 왼쪽에 '0' padding
	 *
	 * @param target
	 * @param length
	 * @return
	 */
	public static String leftPadZero(String target, int length) {
		return leftPad(target, length, '0');
	}

	/**
	 * 왼쪽에 주어진 문자 padding
	 *
	 * @param target
	 * @param length
	 * @param pad
	 * @return
	 */
	public static String leftPad(String target, int length, char pad) {
		if (target.length() < length) {
			StringBuilder ss = new StringBuilder();
			for (int i = 0; i < length - target.length(); i++) {
				ss.append(pad);
			}
			ss.append(target);
			ss.setLength(length);
			return ss.toString();
		} else {
			return target;
		}
	}

	/**
	 * Object의 값의 존재에 따라 append 처리 함
	 *
	 * @param StringBuilder
	 *            buffer
	 * @param Object
	 *            obj
	 *
	 * @return the StringBuilder : Object의 값의 존재에 따라 append 처리 함
	 */
	public static StringBuilder append(StringBuilder buf, Object obj) {
		if (obj != null) {
			buf.append(obj);
		}

		return buf;
	}
}
