package com.yuncheng.china.Fanju.db.domain.city;

import com.lidroid.xutils.db.annotation.Table;
import com.yuncheng.china.Fanju.db.DBConst;
import com.yuncheng.china.Fanju.db.common.Entity;

/**
 * Created by agonyice on 14-9-9.
 */
@Table(name = DBConst.TABLE_CITY)
public class City extends Entity {
    private int id;
    private double lat;//经度
    private  double lng;//纬度
    private String provinceName;
    private String cityType;
    private String pinyin;
    private String firstPinyin;

    public String getFirstPinyin() {
        return firstPinyin;
    }

    public void setFirstPinyin(String firstPinyin) {
        this.firstPinyin = firstPinyin;
    }

    public String getPinyin() {

        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getCityType() {

        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getProvinceName() {

        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public double getLng() {

        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {

        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }



    public void setId(int id) {
        this.id = id;
    }
}
