package com.yuncheng.china.Fanju.common.config;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.yuncheng.china.Fanju.context.AppContext;

/**
 * Created by agonyice on 14-9-10.
 */
public class NetStateHelper {
	private static ConnectivityManager getconnectivityManager() {
		return (ConnectivityManager) AppContext.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
	}
	public static boolean isMobile(){
		return checkState(getState(ConnectivityManager.TYPE_MOBILE));
	}
	public static boolean isWifi(){
		return  checkState(getState(ConnectivityManager.TYPE_WIFI));
	}
	public static boolean isNetwork(){
		return  isMobile()||isWifi();
	}
	public  static NetworkInfo.State getState(int type){
		return getconnectivityManager().getNetworkInfo(type).getState();
	}
	public static boolean checkState(NetworkInfo.State state){
		return state==NetworkInfo.State.CONNECTED||state==NetworkInfo.State.CONNECTING;
	}
}
