package com.domain.biz;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tangcheng on 2017/2/13.
 */
public class DailyCategoryReq {
    @NotBlank
    private String title;
    @NotBlank
    private String mediaUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
