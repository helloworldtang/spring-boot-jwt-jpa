package com.domain.biz;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by tang.cheng on 2017/2/10.
 */
public class DailyNewsReq {
    @NotEmpty
    @NotNull
    private String title;
    @NotEmpty
    @NotNull
    private String mediaUrl;
    @NotEmpty
    @NotNull
    private String source;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
