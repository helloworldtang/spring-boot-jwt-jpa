package com.domain.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by tang.cheng on 2017/1/16.
 */
public class FullUserReq extends UserReq{
    @Min(1)
    @Max(2)
    @NotNull
    private Long role;

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
}
