package com.yuncheng.china.Fanju.map;

import com.amap.api.location.AMapLocation;

/**
 * Created by agonyice on 14-9-10.
 */
public interface IMapLocationCallback {
	void onSuccess(AMapLocation location);
	void onFailure(Exception e);
}
