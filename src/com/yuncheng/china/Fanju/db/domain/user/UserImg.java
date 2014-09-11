package com.yuncheng.china.Fanju.db.domain.user;

import com.lidroid.xutils.db.annotation.Table;
import com.yuncheng.china.Fanju.db.DBConst;

/**
 * Created by agonyice on 14-9-9.
 */
@Table(name = DBConst.TABLE_USER_IMG)

public class UserImg extends User {
    private int userId;
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getUserId() {

        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
