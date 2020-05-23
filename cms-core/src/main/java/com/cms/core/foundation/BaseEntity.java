package com.cms.core.foundation;

import java.io.Serializable;
import java.time.LocalDate;

public class BaseEntity<Pk extends Serializable> implements Serializable {

    private Pk id;
    private LocalDate createTime;
    private LocalDate updateTime;


    public Pk getId() {
        return id;
    }

    public void setId(Pk id) {
        this.id = id;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }
}
