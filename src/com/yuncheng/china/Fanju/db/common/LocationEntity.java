package com.yuncheng.china.Fanju.db.common;

import com.lidroid.xutils.db.annotation.Transient;

/**
 * Created by agonyice on 14-9-9.
 */
public class LocationEntity extends Entity {
    private double longitude;
    private double latitude;

    @Transient
    private Location location;

    public void beforeSave() {
        if (location == null) {
            return;
        }
        longitude = location.getLongitude();
        latitude = location.getLatitude();
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Location getLocation() {
        if (location == null && longitude != 0 && latitude != 0) {
            location = new Location(longitude, latitude);
        }
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
