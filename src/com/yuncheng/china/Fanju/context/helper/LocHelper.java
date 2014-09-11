package com.yuncheng.china.Fanju.context.helper;

import android.content.Context;

import com.amap.api.location.AMapLocation;
import com.yuncheng.china.Fanju.common.config.Shared;
import com.yuncheng.china.Fanju.context.AppContext;
import com.yuncheng.china.Fanju.entity.Loc;
import com.yuncheng.china.Fanju.map.IMapLocationCallback;
import com.yuncheng.china.Fanju.map.MapLocation;


/**
 * Created by agonyice on 14-9-10.
 */
public class LocHelper {
	private static final LocHelper INSTANCE = new LocHelper();
	private static final String DISSTANCE_FORMAT = "0.00";
	private static final double DISTANCE_M_KM = 1000;
	private static final double DEFAULT_LOC = 0.0;
	private static Context context;
	private static boolean isLoading;
	private static IMapLocationCallback mapLocationCallback = new MapLocationCallback();

	public LocHelper() {
		context = AppContext.getContext();
	}

	public static Loc getLoc() {
		double longitude = SharedHelper.getDouble(Shared.LOCATION.NAME, Shared.LOCATION.LONGITUDE, DEFAULT_LOC);
		double latitude = SharedHelper.getDouble(Shared.LOCATION.NAME, Shared.LOCATION.LATITUDE, DEFAULT_LOC);
		return new Loc(longitude, latitude);
	}

	public static synchronized void loc() {
		if (isLoading) {
			return;
		}
		isLoading = true;
		new MapLocation(context).location(mapLocationCallback);
	}

	public static class MapLocationCallback implements IMapLocationCallback {


		@Override
		public void onSuccess(AMapLocation location) {
			saveLocation(location);
			isLoading = false;
		}

		@Override
		public void onFailure(Exception e) {
			LocHelper.postEvent();
			isLoading=false;
		}
	}
	private static void saveLocation(AMapLocation location){
		SharedHelper.putString(Shared.LOCATION.NAME,Shared.LOCATION.PROVINCE_NAME,location.getProvince());
		SharedHelper.putString(Shared.LOCATION.NAME,Shared.LOCATION.ADDRESS_CODE,location.getAdCode());
	}
}
