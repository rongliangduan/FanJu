package com.yuncheng.china.Fanju.db.common;

import com.lidroid.xutils.db.annotation.Id;
import com.yuncheng.china.Fanju.util.ObjectUtil;

/**
 * Created by agonyice on 14-9-9.
 */
public class Entity {
    @Id
    private String id;
    private long createTime;
    private long lastTime;
    private String status;

    public void beforesave() {

    }

    @Override
    public int hashCode() {
        return ObjectUtil.hashCode(id, super.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entity)) {
            return false;
        }
        return ObjectUtil.equals(id, ((Entity) obj).id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLastTime() {

        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public long getCreateTime() {

        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}