package com.yuncheng.china.Fanju.context;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.baidu.android.pushservice.PushConstants;
import com.baidu.android.pushservice.PushManager;
import com.baidu.frontia.FrontiaApplication;
import com.lidroid.xutils.util.LogUtils;
import com.yuncheng.china.Fanju.common.config.Baidu;

/**
 * Created by agonyice on 14-9-10.
 */
public class AppContext extends FrontiaApplication {
	private static final boolean DEBUG = true;
	private static AppContext appContext;

	public static AppContext getAppContext() {
		return appContext;
	}

	public static Context getContext() {
		return appContext.getApplicationContext();
	}

	public static boolean isDebug() {
		return DEBUG;
	}

	public static PackageInfo getPackageInfo() {
		try {
			return getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
		} catch (PackageManager.NameNotFoundException e) {
			LogUtils.w("can not found package info", e);
		}
		return null;

	}

	public static int versionCode() {
		return getPackageInfo().versionCode;
	}

	public static String versionName() {
		return getPackageInfo().versionName;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		appContext = this;
		//	MessageManager.startWork(getApplicationContext());
		PushManager.startWork(getApplicationContext(), PushConstants.LOGIN_TYPE_API_KEY, Baidu.APP_ID);
		//	LocHelper.loc();
	}
}
