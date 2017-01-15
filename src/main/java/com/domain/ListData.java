package com.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListData<T> implements Serializable {
    private Boolean hasNext;

    @JsonProperty("items")
    protected List<T> infoList;

    public ListData() {
        this.infoList = new ArrayList<>();
        this.hasNext = false;
    }

    public List<T> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<T> infoList) {
        if (infoList == null) {
            return;
        }
        this.infoList = infoList;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void addAll(List<T> list) {
        this.infoList.addAll(list);
    }

}