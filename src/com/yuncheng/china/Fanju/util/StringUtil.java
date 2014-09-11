package com.yuncheng.china.Fanju.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by agonyice on 14-9-10.
 */
public class StringUtil {
	private static final String DEFAULT_DELIMIIER = ";";

	private static boolean isEmpty(String value) {
		return value == null || "".equals(value);
	}

	public static boolean isTrimEmpty(String value) {
		return isEmpty(trim(value));
	}

	public static String trim(String value) {
		return trim(value, "");
	}

	public static String trim(String value, String defaultValue) {
		if (value == null) {
			return defaultValue;
		}
		return value.trim();
	}

	public static String toString(double value) {
		return toString(new Double(value));
	}

	public static String toString(Double value) {
		if (value == null || value.isInfinite() || value.isNaN()) {
			return "";
		}
		BigDecimal bigDecimal = new BigDecimal(value);
		return bigDecimal.toPlainString();
	}

	public static <E> String merge(Collection<E> collection) {
		return merge(collection, DEFAULT_DELIMIIER);
	}

	public static <E> String merge(E[] array, String delimiter) {
		return merge(cover(array), DEFAULT_DELIMIIER);
	}

	private static <E> List<E> cover(E[] array) {
		List<E> list = new ArrayList<E>();
		for (E e : array) {
			list.add(e);
		}
		return list;
	}

	public static <E> String merge(Collection<E> collection, String delimiter) {
		if (CollectionUtil.isEmpty(collection)) {
			return "";
		}
		if (delimiter == null) {
			delimiter = DEFAULT_DELIMIIER;
		}
		StringBuilder sb = new StringBuilder();
		for (E e : collection) {
			sb.append(ObjectUtil.toString(e)).append(delimiter);
		}
		if (delimiter.length() > 0) {
			return sb.substring(0, sb.length() - delimiter.length());
		}
		return sb.toString();
	}
}
