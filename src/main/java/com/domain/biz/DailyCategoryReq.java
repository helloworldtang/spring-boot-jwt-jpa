package com.domain.biz;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by tangcheng on 2017/2/13.
 */
@ApiModel("Category信息")
public class DailyCategoryReq {
    @ApiModelProperty(required = true, value = "标题")
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
