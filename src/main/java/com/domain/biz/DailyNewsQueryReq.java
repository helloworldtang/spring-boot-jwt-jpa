package com.domain.biz;

import com.domain.request.PageReq;

import javax.validation.constraints.NotNull;

/**
 * Created by tangcheng on 2017/2/13.
 */
public class DailyNewsQueryReq extends PageReq{
    @NotNull
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
