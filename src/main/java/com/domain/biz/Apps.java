package com.domain.biz;

import javax.persistence.*;

/**
 * Created by tangcheng on 2017/2/18.
 */
@Entity
@Table(name = "apps")
public class Apps {
    @Id
    private Long id;
    private String name;
    private String countries;
    private Boolean enabled;
    private Boolean iphone;
    private Boolean ipad;
    private Boolean osx;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "app_store_url")
    private String appStoreUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getIphone() {
        return iphone;
    }

    public void setIphone(Boolean iphone) {
        this.iphone = iphone;
    }

    public Boolean getIpad() {
        return ipad;
    }

    public void setIpad(Boolean ipad) {
        this.ipad = ipad;
    }

    public Boolean getOsx() {
        return osx;
    }

    public void setOsx(Boolean osx) {
        this.osx = osx;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAppStoreUrl() {
        return appStoreUrl;
    }

    public void setAppStoreUrl(String appStoreUrl) {
        this.appStoreUrl = appStoreUrl;
    }
}
