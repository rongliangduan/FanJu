package com.yuncheng.china.Fanju.map;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.location.LocationManagerProxy;
import com.amap.api.location.LocationProviderProxy;
import com.yuncheng.china.Fanju.exception.SystemException;


/**
 * Created by agonyice on 14-9-11.
 */
public class MapLocation implements AMapLocationListener, Runnable {
	private final Context context;
	private LocationManagerProxy mapLocationManger;
	private Handler handler = new Handler();
	private IMapLocationCallback callback;
	private AMapLocation mapLocation;
	private boolean isCallback;

	public MapLocation(Context context) {
		this.context = context;
	}

	private synchronized LocationManagerProxy getMapLocationManger() {
		if (mapLocationManger == null) {
			mapLocationManger = LocationManagerProxy.getInstance(context);
			mapLocationManger.setGpsEnable(true);
		}
		return mapLocationManger;
	}

	public void location(IMapLocationCallback callback) {
		if (callback == null) {
			return;
		}
		this.mapLocation = null;
		this.callback = callback;
		try {
			getMapLocationManger().requestLocationUpdates(LocationProviderProxy.AMapNetwork, MapConst.INTERVAL_TIME, MapConst.INTERVAL_DISTANCE, this);
			handler.postDelayed(this, MapConst.TIME_OUT);
		} catch (Exception e) {
			onFailure(e);
		}
	}

	public void stopLocation() {
		if (mapLocationManger != null) {
			mapLocationManger.removeUpdates(this);
			mapLocationManger.destroy();
		}
		mapLocationManger = null;
	}

	private void onSuccess() {
		stopLocation();
		if (isCallback) {
			return;
		}
		isCallback = true;
		callback.onSuccess(mapLocation);
	}

	private void onFailure(Exception e) {
		stopLocation();
		if (isCallback) {
			return;
		}
		isCallback = true;
		callback.onFailure(e);
	}

	public void onLocationChanged(AMapLocation mapLocation) {
		this.mapLocation = mapLocation;
		if (mapLocation == null) {
			return;
		}
		onSuccess();
	}

	@Override
	public void onLocationChanged(Location location) {

	}

	@Override
	public void onStatusChanged(String provder, int status, Bundle extras) {

	}

	@Override
	public void onProviderEnabled(String provder) {

	}

	@Override
	public void onProviderDisabled(String provder) {

	}

	@Override
	public void run() {
		stopLocation();
		if(mapLocation!=null){
			onSuccess();
			return;
		}
		onFailure(new SystemException("超时"));
	}
}
