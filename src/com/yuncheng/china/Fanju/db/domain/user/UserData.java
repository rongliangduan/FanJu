package com.yuncheng.china.Fanju.db.domain.user;

/**
 * Created by agonyice on 09/09/14.
 */
public class UserData extends User {
    private int userId;
    private String phone;
    private int inCome;//收入
    private String cityName;
    private int cityId;
    private int professional;//职业
    private int marriage;//感情
    private int smoking;//是否喝酒
    private int drinking;//是否吸烟
    private int remark;//个人备注

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public int getDrinking() {

        return drinking;
    }

    public void setDrinking(int drinking) {
        this.drinking = drinking;
    }

    public int getSmoking() {

        return smoking;
    }

    public void setSmoking(int smoking) {
        this.smoking = smoking;
    }

    public int getMarriage() {

        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public int getProfessional() {

        return professional;
    }

    public void setProfessional(int professional) {
        this.professional = professional;
    }

    public int getCityId() {

        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {

        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getInCome() {

        return inCome;
    }

    public void setInCome(int inCome) {
        this.inCome = inCome;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
