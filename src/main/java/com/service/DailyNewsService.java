package com.service;

import com.domain.ItemStatus;
import com.domain.ListData;
import com.domain.biz.DailyNews;
import com.domain.biz.DailyNewsRepository;
import com.domain.request.PageReq;
import com.domain.response.DailyNewsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Service
public class DailyNewsService {

    @Autowired
    private DailyNewsRepository dailyNewsRepository;

    public ListData<DailyNewsRes> getDailyNews(PageReq pageReq) {

        Sort sort=new Sort(Sort.Direction.DESC,"createdTime");//properties是table orm后的对象字段名
        PageRequest pageable = new PageRequest(pageReq.getPage(), pageReq.getSize(), sort);
        Page<DailyNews> result = dailyNewsRepository.findByStatus(ItemStatus.NORMAL.getStatus(), pageable);
        ListData<DailyNewsRes> listData=new ListData<>();
        List<DailyNews> content = result.getContent();
        List<DailyNewsRes> resList = new ArrayList<>();
        for (DailyNews dailyNews : content) {
            DailyNewsRes res=new DailyNewsRes();
            res.setTitle(dailyNews.getTitle());
            res.setMediaUrl(dailyNews.getMediaUrl());
            res.setSource(dailyNews.getSource());
            resList.add(res);
        }
        listData.setInfoList(resList);
        listData.setHasNext(result.hasNext());
        return listData;
    }

}
