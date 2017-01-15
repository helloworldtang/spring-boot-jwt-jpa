package com.domain.response;

import java.io.Serializable;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public class DailyNewsRes implements Serializable{
    private String title;
    private String mediaUrl;
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
