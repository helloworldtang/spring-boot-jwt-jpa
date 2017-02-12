package com.service;

import com.domain.ItemStatus;
import com.domain.ListData;
import com.domain.biz.DailyNews;
import com.domain.biz.DailyNewsRepository;
import com.domain.biz.DailyNewsReq;
import com.domain.biz.DailyNewsUpdateReq;
import com.domain.request.PageReq;
import com.domain.response.DailyNewsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Service
public class DailyNewsService {

    @Autowired
    private DailyNewsRepository dailyNewsRepository;

    public ListData<DailyNewsRes> getDailyNews(PageReq pageReq) {
        Sort sort = new Sort(Sort.Direction.DESC, "createdTime");//properties是table orm后的对象字段名
        PageRequest pageable = new PageRequest(pageReq.getPageId(), pageReq.getPageSize(), sort);
        Page<DailyNews> result = dailyNewsRepository.findByStatus(ItemStatus.NORMAL.getStatus(), pageable);
        ListData<DailyNewsRes> listData = new ListData<>();
        List<DailyNews> content = result.getContent();
        List<DailyNewsRes> resList = new ArrayList<>();
        for (DailyNews dailyNews : content) {
            DailyNewsRes res = new DailyNewsRes();
            res.setId(dailyNews.getId());
            res.setTitle(dailyNews.getTitle());
            res.setMediaUrl(dailyNews.getMediaUrl());
            res.setSource(dailyNews.getSource());
            res.setCreatedTime(dailyNews.getCreatedTime().getTime());
            resList.add(res);
        }
        listData.setInfoList(resList);
        listData.setHasNext(result.hasNext());
        listData.setCurrentPageId(result.getNumber());
        return listData;
    }

    public Long addDailyNews(DailyNewsReq newsReq) {
        DailyNews dailyNews = new DailyNews();
        dailyNews.setTitle(newsReq.getTitle());
        dailyNews.setMediaUrl(newsReq.getMediaUrl());
        dailyNews.setSource(newsReq.getSource());
        dailyNews.setCreatedTime(new Date());
        dailyNews.setUpdatedTime(new Date());
        dailyNews.setStatus(ItemStatus.NORMAL.getStatus());
        DailyNews save = dailyNewsRepository.save(dailyNews);
        return save.getId();
    }

    public int updateDailyNewsStatus(DailyNewsUpdateReq updateReq) {
        return dailyNewsRepository.updateStatus(updateReq.getDailyNewsId(), updateReq.getStatus());
    }
}
