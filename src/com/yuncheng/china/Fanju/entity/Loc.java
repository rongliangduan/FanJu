package com.yuncheng.china.Fanju.entity;

/**
 * Created by agonyice on 14-9-10.
 */
public class Loc {
	private double longitude;
	private double latitude;

	public Loc() {
	}

	public Loc(double longitude,double latitude){
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public double getLongitude(){
		return longitude;
	}
	public void setLongitude(double longitude){
		this.longitude=longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
