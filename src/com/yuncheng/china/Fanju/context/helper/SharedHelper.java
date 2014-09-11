package com.yuncheng.china.Fanju.context.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.yuncheng.china.Fanju.context.AppContext;
import com.yuncheng.china.Fanju.util.MathUtil;
import com.yuncheng.china.Fanju.util.StringUtil;

/**
 * Created by agonyice on 14-9-10.
 */
public class SharedHelper {
	public static SharedPreferences getSharePreferences(String name) {
		return AppContext.getContext().getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	public static SharedPreferences.Editor getEditor(String name) {
		return AppContext.getContext().getSharedPreferences(name, Context.MODE_PRIVATE).edit();
	}

	public static boolean getBoolean(String name, String key, boolean defaultValue) {
		return getSharePreferences(name).getBoolean(key, defaultValue);
	}

	public static void putBoolean(String name, String key, boolean value) {
		getEditor(name).putBoolean(key, value).commit();
	}

	public static float getFloat(String name, String key, float defaultValue) {
		return getSharePreferences(name).getFloat(key, defaultValue);
	}

	public static void putFloat(String name, String key, int value) {
		getEditor(name).putFloat(key, value).commit();
	}

	public static void putFloat(String name, String key, Float value) {
		getEditor(name).putFloat(key, value).commit();
	}

	public static int getInt(String name, String key, int defaultValue) {
		return getSharePreferences(name).getInt(key, defaultValue);
	}

	public static void putInt(String name, String key, int value) {
		getEditor(name).putInt(key, value).commit();
	}

	public static long getLong(String name, String key, long defaultValue) {
		return getSharePreferences(name).getLong(key, defaultValue);
	}

	public static void putLong(String name, String key, long value) {
		getEditor(name).putLong(key, value).commit();
	}

	public static double getDouble(String name, String key, double defaultValue) {
		return MathUtil.doubleValue(getString(name, key, null), defaultValue);
	}

	public static void putDouble(String name, String key, double value) {
		getEditor(name).putString(key, StringUtil.toString(value)).commit();
	}

	public static void putDouble(String name, String key, Double value) {
		getEditor(name).putString(key, StringUtil.toString(value)).commit();
	}

	/*public static void getString(String name, String key) {
		return getString(name, key,null);
	}*/
	public static String getString(String name,String key,String defaultValue){
		return getSharePreferences(name).getString(key,defaultValue);
	}
	public static void putString(String name,String key,String value){
		getEditor(name).putString(key,value).commit();
	}
	public static void remove(String name,String key){
		getEditor(name).remove(key).commit();
	}
	public static void clear(String name){
		getEditor(name).clear().commit();
	}
}
