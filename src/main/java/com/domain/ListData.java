package com.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class ListData<T> implements Serializable {

    private boolean hasNext;

    @JsonProperty("items")
    private List<T> infoList;

    @JsonProperty("current_page_id")
    private int currentPageId;

    public ListData() {
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

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getCurrentPageId() {
        return currentPageId;
    }

    public void setCurrentPageId(int currentPageId) {
        this.currentPageId = currentPageId;
    }
}