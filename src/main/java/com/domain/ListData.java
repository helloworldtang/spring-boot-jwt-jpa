package com.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListData<T> implements Serializable {
    @JsonProperty("has_ext")
    private Boolean hasNext;

    @JsonProperty("items")
    protected List<T> infoList;

    @JsonProperty("next_page_id")
    protected int nextPageId;

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

    public int getNextPageId() {
        return nextPageId;
    }

    public void setNextPageId(int nextPageId) {
        this.nextPageId = nextPageId;
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