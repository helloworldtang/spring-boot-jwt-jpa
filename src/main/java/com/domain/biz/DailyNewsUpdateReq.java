package com.domain.biz;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by tangcheng on 2017/2/11.
 */
public class DailyNewsUpdateReq {

    @NotNull
    private Long dailyNewsId;

    @Min(0)
    @Max(1)
    @NotNull
    private Byte status;

    public Long getDailyNewsId() {
        return dailyNewsId;
    }

    public void setDailyNewsId(Long dailyNewsId) {
        this.dailyNewsId = dailyNewsId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
