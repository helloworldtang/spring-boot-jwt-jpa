package com.domain.request;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public class PageReq {
    private int pageId = 0;
    private int pageSize = 10;

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
