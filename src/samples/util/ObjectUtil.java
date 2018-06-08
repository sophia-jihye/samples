package samples.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ObjectUtil {
	/**
	 * Object empty ���θ� ���� �Ѵ�.
	 *
	 * @param the
	 *            object to check
	 * @return boolean
	 */
	public static boolean isEmpty(Object object) {
		return object == null;
	}

	/**
	 * �迭�� empty ���θ� ���� �Ѵ�.
	 *
	 * @param array
	 *            the array to check
	 * @return boolean
	 */
	public static boolean isEmpty(Object[] array) {
		return array == null || array.length == 0;
	}

	/**
	 * ����Ʈ�� empty ���θ� ���� �Ѵ�.
	 *
	 * @param list
	 * @return boolean
	 */
	public static boolean isEmpty(List<?> list) {
		return list == null || list.isEmpty();
	}

	/**
	 * �迭�� Ư�� ������� <code>element</code>�� �ִ��� Ȯ���Ѵ�.
	 *
	 * @param array
	 *            �˻��� �迭 in which case the return value will always be
	 *            <code>false</code>)
	 * @param element
	 *            Ȯ���� �������
	 * @return �迭�� <code>element</code>�� �ִ��� ���� <code>array</code>��
	 *         <code>null</code>�� ��� <code>false</code> ����
	 */
	public static boolean containElement(Object[] array, Object element) {
		if (array == null) {
			return false;
		}

		for (Object arrayEle : array) {
			if (convertNullSafeToEqual(arrayEle, element)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * ���޵� �迭 <code>array</code>�� ��ü <code>obj</code>�� �߰��Ѵ�.
	 *
	 * @param array
	 *            �迭 ��ü (can be <code>null</code>)
	 * @param obj
	 *            �߰��� ��ü
	 * @return the new array
	 */
	@SuppressWarnings("rawtypes")
	public static Object[] addObjectToArray(Object[] array, Object obj) {
		Class compType = Object.class;
		if (array != null) {
			compType = array.getClass().getComponentType();
		} else if (obj != null) {
			compType = obj.getClass();
		}

		int newArrLength = (array != null) ? array.length + 1 : 1;
		Object[] newArr = (Object[]) Array.newInstance(compType, newArrLength);
		if (array != null) {
			System.arraycopy(array, 0, newArr, 0, array.length);
		}
		newArr[newArr.length - 1] = obj;

		return newArr;
	}

	/**
	 * �� ��ü�� �������� Ȯ���Ѵ�.
	 *
	 * @param o1
	 *            first Object to compare
	 * @param o2
	 *            second Object to compare
	 * @return whether the given objects are equal
	 * @see java.util.Arrays#equals
	 */
	public static boolean convertNullSafeToEqual(Object o1, Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (o1 == null || o2 == null) {
			return false;
		}
		if (o1.equals(o2)) {
			return true;
		}

		if (o1.getClass().isArray() && o2.getClass().isArray()) {
			if (o1 instanceof Object[] && o2 instanceof Object[]) {
				return Arrays.equals((Object[]) o1, (Object[]) o2);
			}
			if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
				return Arrays.equals((boolean[]) o1, (boolean[]) o2);
			}
			if (o1 instanceof byte[] && o2 instanceof byte[]) {
				return Arrays.equals((byte[]) o1, (byte[]) o2);
			}
			if (o1 instanceof char[] && o2 instanceof char[]) {
				return Arrays.equals((char[]) o1, (char[]) o2);
			}
			if (o1 instanceof double[] && o2 instanceof double[]) {
				return Arrays.equals((double[]) o1, (double[]) o2);
			}
			if (o1 instanceof float[] && o2 instanceof float[]) {
				return Arrays.equals((float[]) o1, (float[]) o2);
			}
			if (o1 instanceof int[] && o2 instanceof int[]) {
				return Arrays.equals((int[]) o1, (int[]) o2);
			}
			if (o1 instanceof long[] && o2 instanceof long[]) {
				return Arrays.equals((long[]) o1, (long[]) o2);
			}
			if (o1 instanceof short[] && o2 instanceof short[]) {
				return Arrays.equals((short[]) o1, (short[]) o2);
			}
		}

		return false;
	}

	/**
	 * ���޵� �� ��ü�� ������ Ȯ���Ѵ�.
	 *
	 * @param o1
	 *            ��� ��ü (may be <code>null</code>, in which case the return
	 *            value will always be <code>false</code>)
	 * @param o2
	 *            �� ��� ��ü
	 * @return whether the given objects are equal
	 */
	public static boolean compareEqual(final Object o1, final Object o2) {
		if (o1 == o2) {
			return true;
		}
		if (null == o1 || null == o2) {
			return false;
		}

		if (!o1.getClass().isArray() || !o2.getClass().isArray()) {
			return o1.equals(o2);
		}

		if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
			return Arrays.equals((boolean[]) o1, (boolean[]) o2);
		} else if (o1 instanceof byte[] && o2 instanceof byte[]) {
			return Arrays.equals((byte[]) o1, (byte[]) o2);
		} else if (o1 instanceof char[] && o2 instanceof char[]) {
			return Arrays.equals((char[]) o1, (char[]) o2);
		} else if (o1 instanceof double[] && o2 instanceof double[]) {
			return Arrays.equals((double[]) o1, (double[]) o2);
		} else if (o1 instanceof float[] && o2 instanceof float[]) {
			return Arrays.equals((float[]) o1, (float[]) o2);
		} else if (o1 instanceof int[] && o2 instanceof int[]) {
			return Arrays.equals((int[]) o1, (int[]) o2);
		} else if (o1 instanceof long[] && o2 instanceof long[]) {
			return Arrays.equals((long[]) o1, (long[]) o2);
		} else if (o1 instanceof short[] && o2 instanceof short[]) {
			return Arrays.equals((short[]) o1, (short[]) o2);
		} else if (o1 instanceof Object[] && o2 instanceof Object[]) {
			final Object[] ones = (Object[]) o1;
			final Object[] twos = (Object[]) o2;

			if (ones.length != twos.length) {
				return false;
			}

			for (int i = 0, n = ones.length; i < n; i++) {
				if (!compareEqual(ones[i], twos[i])) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	/**
	 * ���޵� ���� ���ڿ� ���� 0���� length���� ª��
	 *
	 * @param buffer
	 * @param length
	 * @return
	 */
	// public static Object split(Object buffer, int length) {
	// if (buffer instanceof byte[]) {
	// byte[] data = (byte[]) buffer;
	// if (length > data.length) {
	// return null;
	// }
	// byte[] temp = new byte[data.length - length];
	// System.arraycopy(buffer, length, temp, 0, (data.length - length));
	// return temp;
	// } else if (buffer instanceof String) {
	// byte[] data = ((String) buffer).getBytes(CharsetUtil.EUC_KR);
	// if (length > data.length) {
	// return null;
	// }
	// byte[] temp = new byte[data.length - length];
	// System.arraycopy(buffer, length, temp, 0, (data.length - length));
	// return new String(temp, CharsetUtil.EUC_KR);
	// } else {
	// return null;
	// }
	// }
}
