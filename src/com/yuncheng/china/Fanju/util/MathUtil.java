package com.yuncheng.china.Fanju.util;

import java.math.BigDecimal;

/**
 * Created by agonyice on 14-9-10.
 */
public class MathUtil {
	public static boolean isInt(String value) {
		try {
			BigDecimal bigDecimal = new BigDecimal(value);
			return bigDecimal.longValue() == bigDecimal.intValue();
		} catch (Exception e) {
			return false;
		}
	}

	public static int intValue(String value) {
		return intValue(value, 0);
	}

	public static int intValue(String value, int defaultValue) {
		try {
			return Integer.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static boolean isLong(String value) {
		try {
			BigDecimal bigDecimal = new BigDecimal(value);
			return bigDecimal.doubleValue() == bigDecimal.longValue();
		} catch (Exception e) {
			return false;
		}
	}

	public static long longValue(String value) {
		return longValue(value, 0);
	}

	public static long longValue(String value, long defaultValue) {
		try {
			return Long.valueOf(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static boolean isFloat(String value) {
		try {
			BigDecimal bigDecimal = new BigDecimal(value);
			return new BigDecimal(bigDecimal.floatValue()).toPlainString().equals(bigDecimal.toPlainString());
		} catch (Exception e) {
			return false;
		}
	}

	public static float floatValue(String value) {
		return floatValue(value, 0);
	}

	public static float floatValue(String value, float defaultValue) {
		try {
			Float result = Float.valueOf(value);
			return result.isNaN() || result.isInfinite() ? defaultValue : result;
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static boolean idDouble(String value) {
		try {
			BigDecimal bigDecimal = new BigDecimal(value);
			return new BigDecimal(bigDecimal.doubleValue()).toPlainString().equals(bigDecimal.toPlainString());
		} catch (Exception e) {
			return false;
		}
	}

	public static double doubleValue(String value) {
		return doubleValue(value, 0);
	}

	public static double doubleValue(String value, double defaultValue) {
		try {
			Double result = Double.valueOf(value);
			return result.isNaN() || result.isInfinite() ? defaultValue : result;
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static boolean isDouble(Double value) {
		return value != null && !value.isNaN() && !value.isInfinite();
	}

	public static boolean isByte(String value) {
		try {
			return Byte.decode(value).toString().equals(value);
		} catch (Exception e) {
			return false;
		}
	}
	public static byte byteValue(String value){
		return byteValue(value,(byte)0);
	}
	public static byte byteValue(String value,byte defaultValue){
		try{
			return Byte.decode(value);
		}catch (Exception e){
			return defaultValue;
		}
	}
	public static boolean isShort(String value){
		try{
			return Short.decode(value).toString().equals(value);
		}catch (Exception e){
			return false;
		}
	}
	public static short shortValue(String value){
		return shortValue(value,(short)0);
	}
	public static short shortValue(String value,short defaultValue){
		try{
			return Short.valueOf(value);
		}catch (Exception e){
			return  defaultValue;
		}
	}
}
