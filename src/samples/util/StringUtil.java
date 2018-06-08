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
	 * ���ڿ��� ���ڿ����� �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�̰ų� ���̰� 0�� ���ڿ� �Ǵ� ���鹮�ڷθ� ä����
	 * �ִ� ��� ���ڿ��� �Ǵ��Ѵ�.
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
	 * ���ڿ��� ���ڿ����� �Ǵ��Ѵ�.
	 * ���޵� ���ڿ��� <code>null</code>�̰ų� ���̰� 0�� ���ڿ� �Ǵ� ���鹮�ڷθ� ä���� �ִ� ��� ���ڿ��� �Ǵ��Ѵ�.
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isEmpty(String str) {
		String value = (str != null) ? str.trim() : str;
		return isEmpty((CharSequence) value);
	}

	/**
	 * Object�� null���� �Ǵ��Ѵ�.
	 *
	 * @param obj
	 * @return boolean
	 */
	public boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * ���ڿ��� ���̰� �ִ��� �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�� �ƴϰ� ���̰� 0���� ū ��� ���̰� �ִ�
	 * ������ �Ǵ��Ѵ�.
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean hasLength(CharSequence str) {
		return (str != null && str.length() > 0);
	}

	/**
	 * ���ڿ��� ���̰� �ִ��� �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�� �ƴϰ� ���̰� 0���� ū ��� ���̰� �ִ�
	 * ������ �Ǵ��Ѵ�.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasLength(CharSequence)
	 */
	public static boolean hasLength(String str) {
		return hasLength((CharSequence) str);
	}

	/**
	 * ���ڿ��� ������ �ִ��� �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�� �ƴϰ� ���̰� �־���ϸ� ���鹮�ڷθ� ä����
	 * ���� �ʾƾ� ���ڿ��� ������ �ִ� ������ �Ǵ��Ѵ�.
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
	 * ���ڿ��� ������ �ִ��� �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�� �ƴϰ� ���̰� �־���ϸ� ���鹮�ڷθ� ä����
	 * ���� �ʾƾ� ���ڿ��� ������ �ִ� ������ �Ǵ��Ѵ�.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasText(CharSequence)
	 */
	public static boolean hasText(String str) {
		return hasText((CharSequence) str);
	}

	/**
	 * ���ڿ��� ���鹮�ڰ� �ִ��� �Ǵ��Ѵ�. <code>null</code>�� �ƴ� ���̰� �ִ� ���ڿ��� ���鹮�ڰ� �־�� ���鹮�ڸ�
	 * �����ϴ� ������ �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�̰ų� ���̰� ���� ��쵵 ���鹮�ڸ� �������� ���� ������
	 * �Ǵ��Ѵ�.
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
	 * ���ڿ��� ���鹮�ڰ� �ִ��� �Ǵ��Ѵ�. <code>null</code>�� �ƴ� ���̰� �ִ� ���ڿ��� ���鹮�ڰ� �־�� ���鹮�ڸ�
	 * �����ϴ� ������ �Ǵ��Ѵ�. ���޵� ���ڿ��� <code>null</code>�̰ų� ���̰� ���� ��쵵 ���鹮�ڸ� �������� ���� ������
	 * �Ǵ��Ѵ�.
	 *
	 * @param str
	 * @return boolean
	 * @see #hasWhiteSpace(CharSequence)
	 */
	public static boolean hasWhiteSpace(String str) {
		return hasWhiteSpace((CharSequence) str);
	}

	/**
	 * ���ڿ��� �պκа� �޺κп� �ִ� ���鹮�ڸ� ��� �����Ѵ�. ���ڿ� �߰��� �ִ� ���鹮�ڴ� ���ŵ��� �ʴ´�.
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
	 * ���ڿ��� ���Ե� ��� ���鹮�ڸ� �����Ѵ�.
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
	 * ���޵� ���ڿ��� �պκп� ���Ե� ���鹮�ڸ� �����Ѵ�. ���ڿ� �߰��� �ִ� ���鹮�ڴ� ���ŵ��� �ʴ´�.
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
	 * ���޵� ���ڿ��� �޺κп� ���Ե� ���鹮�ڸ� �����Ѵ�. ���ڿ� �߰��� �ִ� ���鹮�ڴ� ���ŵ��� �ʴ´�.
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
	 * ���޵� ���ڿ��� �պκп� Ư�� ���� <code>leadingChar</code>�� �߰ߵǸ� �ݺ������� �̸� �����Ѵ�. ���ڿ� �߰���
	 * �߰ߵ� <quote>Ư������</quote>�� ���ŵ��� �ʴ´�.
	 *
	 * ��) <blockquote> String string=
	 * StringUtil.trimLeadingCharacter("FFFCFW001", 'F'); ��� ���ڿ� : "CFW001"
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
	 * ���޵� ���ڿ��� �޺κп� Ư�� ���� <code>leadingChar</code>�� �߰ߵǸ� �ݺ������� �̸� �����Ѵ�. ���ڿ� �߰���
	 * �߰ߵ� <quote>Ư������</quote>�� ���ŵ��� �ʴ´�.
	 *
	 * ��) <blockquote> String string=
	 * StringUtil.trimLeadingCharacter("CFW001FCFFF", 'F'); ��� ���ڿ� : "CFW001FC"
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
	 * ���޵� ���ڿ��� Ư�����ڿ� <code>prefix</code>�� �����ϴ����� �Ǵ��Ѵ�. ���� Ư�����ڿ��� ��� ���ڴ� ��ҹ��ڸ�
	 * �������� �ʴ´�.
	 *
	 * ��) <blockquote> boolean isStartsWithFWC=
	 * StringUtil.startsWithIgnoreCase("FWC001SVC", "FWC"); boolean
	 * isStartsWithfwC= StringUtil.startsWithIgnoreCase("FWC001SVC:, :"fwC"); //
	 * isStartsWithFWC�� isStartsWithfwc ��� true �̴�. </blockquote>
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
	 * ���޵� ���ڿ��� Ư�����ڿ� <code>suffix</code>�� ���������� �Ǵ��Ѵ�. ���� Ư�����ڿ��� ��� ���ڴ� ��ҹ��ڸ�
	 * �������� �ʴ´�.
	 *
	 * ��) <blockquote> boolean isEndsWithSVC =
	 * StringUtil.endsWithIgnoreCase("FWC001SVC", "SVC"); boolean isEndsWithsvC
	 * = StringUtil.endsWithIgnoreCase("FWC001SVC", "svC"); // isEndsWithSVC��
	 * isEndsWithsvC ��� true �̴�. </blockquote>
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
	 * ���޵� ���ڿ� <code>str</code>�� Ư�� �ε��� <code>index</code>���� ���� ���ڿ�
	 * <code>substring</code> ��ü�� �����ϴ��� �Ǵ��Ѵ�.
	 *
	 * ��) <blockquote> boolean matched= StringUtil.substringMatch("FWC001SVC01",
	 * 3, "001SVC"); // matched �� true �̴�. </blockquote>
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
	 * ���޵� ���ڿ� <code>str</code>�� Ư�� ���ڿ� <code>sub</code>�� �� �� �ݺ������� ��Ÿ�������� �˻��Ѵ�.
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
	 * ���޵� ���� ���ڿ� <code>inString</code>���� ������ ���ڿ� <code>oldSubstring</code>�� ã��
	 * ������ ���ڿ� <code>newSubstring</code>�� ��� �����Ѵ�.
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
	 * ���޵� ���� ���ڿ� <code>inString</code>���� Ư�� ���ڿ� <code>toDeleteSubstring</code>��
	 * ��� �����Ѵ�.
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
	 * ���޵� ���ڿ��� ���� ����ǥ(')�� ���� ���·� �����Ѵ�.
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
	 * ��θ� ��� ������ �̸�(qualified name) <code>qualifiedName</code>���� ��α��� ���ڷ�
	 * ����(.)�� ����Ͽ� ��κκ��� �����Ѵ�. ��Ű������ �����ϴ� Ŭ������(fully qualified class name)����
	 * Ŭ�������� �����ϴ� �뵵�� ���� �� �ִ�.
	 *
	 * ��) <blockquote> String className= StringUtil.unqualify(
	 * "java.lang.String"); // ��� ���ڿ� : "String" </blockquote>
	 *
	 * @param qualifiedName
	 *            the qualified name
	 * @return the resulting String
	 */
	public static String unqualify(String qualifiedName) {
		return unqualify(qualifiedName, '.');
	}

	/**
	 * ��θ� ��� ������ �̸�(qualified name) <code>qualifiedName</code>���� ��α��� ����
	 * <code>separator</code>�� �������� ��κκ��� �����Ѵ�.
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
	 * ���޵� ���� ��� <code>path</code>���� �����̸��� �����Ѵ�.
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
	 * ���޵� ���� ���ڿ� �迭 <code>array</code>�� �ϳ��� ���ڿ��� ��ģ��.
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
	 * ���޵� ���� ���ڿ� �迭 <code>array</code>�� �߰����ڿ� <code>str</code>�� �߰��Ѵ�.
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
	 * ���޵� ���� ���ڿ� �迭 <code>array1</code>�� �߰� ���ڿ� �迭 <code>array2</code>�� �߰��Ѵ�.
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
	 * ���޵� ���� ���ڿ� �迭 <code>array1</code>�� ������ ���ڿ� �迭 <code>array2</code>�� �����Ѵ�.
	 * ������ ���� ���ڿ��� �ߺ����� �ʴ´�. ���յ� ���ڿ� �迭�� ������ ���޵� ���·� �����ȴ�.
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
	 * ���޵� ���ڿ� �迭 <code>array</code>�� �����Ѵ�.
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
	 * ���޵� Collection <code>collection</code>�� ���ڿ� �迭�� ��ȯ�Ѵ�.
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
	 * ���޵� ���� ���ڿ� <code>toSplit</code>�� ���� ���ڿ� <code>delimiter</code>�� �������� ��,
	 * �ڷ� �����Ͽ� ���̰� 2�� ���ڿ� �迭�� ��ȯ�Ѵ�.
	 *
	 * ��) <blockquote> String[] splitted= StringUtil.split("FWC001SVCIn",
	 * "SVC"); // ��� splitted[0] : "FWC001" // ��� splitted[1] : "In"
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
	 * ���޵� ���ڿ� <code>str</code>�� <code>java.util.StringTokenizer</code>�� �̿��Ͽ�
	 * ����(tokenize)�Ѵ�. ���� ���� ���� <code>delimiter</code>�� ���ѵ� ��� ���ڴ� ���� �ϳ� �ϳ���
	 * token�� ������ �������� ���ȴ�. <code>delimiter</code> ���ڿ� ��ü�� �̿��Ͽ� ���ڿ��� �����ϱ� ���ؼ���
	 * <code>delimitedListToStringArray</code>�� ����Ѵ�. ���ҵ� ���ڿ����� ������ ���ŵȴ�. ���̰� 0��
	 * ���ڿ��� ��� �迭�� ���Ե��� �ʴ´�.
	 *
	 * ��) <blockquote> String[] splitted=
	 * StringUtil.tokenizeToStringArray("FWC001SVCIn", "SVC"); // ��� ���ڿ� �迭 : {
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
	 * ���޵� ���ڿ� <code>str</code>�� <code>java.util.StringTokenizer</code>�� �̿��Ͽ�
	 * ����(tokenize)�Ѵ�. ���� ���� ���� <code>delimiter</code>�� ���ѵ� ��� ���ڴ� ���� �ϳ��ϳ���
	 * token�� ������ �������� ���ȴ�. <code>delimiter</code> ���ڿ� ��ü�� �̿��Ͽ� ���ڿ��� �����ϱ� ���ؼ���
	 * <code>delimitedListToStringArray</code>�� ����Ѵ�. ���ҵ� ���ڿ����� ������ ���ŵȴ�.
	 * <code>ignoreEmptyTokens</code>�� true�� ��� ���̰� 0�� ���ڿ��� ��� �迭�� ���Եȴ�.
	 *
	 * <blockquote> ��) String[] splitted=
	 * StringUtil.tokenizeToStringArray("FWC001SVCIn", "SVC"); // ��� ���ڿ� �迭 : {
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
	 * ���޵� ���ڿ� <code>inString</code>�� ����, ��ȣ ���� �ƴ� ���ڷθ� �����Ǿ� �ִ��� Ȯ���Ѵ�.
	 *
	 * ��) <blockquote> boolean isLetter= StringUtil.isLetter("FWC"); // ��� :
	 * true boolean isLetter= StringUtil.isLetter("FWC001"); // ��� : false
	 * boolean isLetter= StringUtil.isLetter("FWC-SVC"); // ��� : false
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
	 * ���޵� ���ڿ� <code>inString</code>�� ����, ��ȣ ���� �ƴ� ���ڷθ� �����Ǿ� �ִ��� Ȯ���Ѵ�.
	 *
	 * ��) <blockquote> boolean isDigit= StringUtil.isDigit("001"); // ��� : true
	 * boolean isDigit= StringUtil.isDigit("FW001"); // ��� : false boolean
	 * isDigit= StringUtil.isDigit("02-001"); // ��� : false </blockquote>
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
	 * ���޵� ���ڿ� <code>inString</code>�� ��ȣ ���� �ƴ� ���� �Ǵ� ���ڷθ� �����Ǿ� �ִ��� Ȯ���Ѵ�.
	 *
	 * ��) <blockquote> boolean isLetterOrDigit=
	 * StringUtil.isLetterOrDigit("FWC001SVCIn"); // ��� : true boolean
	 * isLetterOrDigit= StringUtil.isLetterOrDigit("FWC-001SVCIn"); // ��� :
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
	 * ���޵� ���ڿ� <code>string</code>�� ���� ���ڿ� ����, �� ���θ� �����Ǿ� �ִ��� Ȯ���Ѵ�. trim�� �����
	 * ���̰� 0�� ��� �������θ� �����Ǿ� �ִ� ������ �����Ѵ�.
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
	 * String �迭���� ù��° ���ڿ� ������ String�� ������ ����
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
	 * Object �迭�� size
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
	 * ���ʿ� '0' padding
	 *
	 * @param target
	 * @param length
	 * @return
	 */
	public static String leftPadZero(String target, int length) {
		return leftPad(target, length, '0');
	}

	/**
	 * ���ʿ� �־��� ���� padding
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
	 * Object�� ���� ���翡 ���� append ó�� ��
	 *
	 * @param StringBuilder
	 *            buffer
	 * @param Object
	 *            obj
	 *
	 * @return the StringBuilder : Object�� ���� ���翡 ���� append ó�� ��
	 */
	public static StringBuilder append(StringBuilder buf, Object obj) {
		if (obj != null) {
			buf.append(obj);
		}

		return buf;
	}
}
