package com.domain;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public enum ItemStatus {
    NORMAL(Byte.valueOf("0")),
    DELETED(Byte.valueOf("1"));


    private Byte status;

    ItemStatus(Byte status) {
        this.status = status;
    }

    public Byte getStatus() {
        return status;
    }
}
