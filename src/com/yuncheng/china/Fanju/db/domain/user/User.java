package com.yuncheng.china.Fanju.db.domain.user;

import com.lidroid.xutils.db.annotation.Table;
import com.yuncheng.china.Fanju.db.DBConst;
import com.yuncheng.china.Fanju.db.common.LocationEntity;

/**
 * Created by agonyice on 14-9-9.
 */
@Table(name = DBConst.TABLE_USER)

public class User extends LocationEntity {
    private int id;
    private String userName;
    private String phone;
    private String password;
    private int sex;
    private int devices;
    private int age;
    private int state;
    private long Birthday;
    private int height;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getHeight() {

        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public long getBirthday() {

        return Birthday;
    }

    public void setBirthday(long birthday) {
        Birthday = birthday;
    }

    public int getState() {

        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDevices() {

        return devices;
    }

    public void setDevices(int devices) {
        this.devices = devices;
    }

    public int getSex() {

        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {

        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
