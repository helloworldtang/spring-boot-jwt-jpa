package com.domain.biz;

import com.domain.request.PageReq;

import javax.validation.constraints.NotNull;

/**
 * Created by tangcheng on 2017/2/18.
 */
public class ReviewsReq extends PageReq {
    @NotNull
    private Long app;

    public Long getApp() {
        return app;
    }

    public void setApp(Long app) {
        this.app = app;
    }
}
