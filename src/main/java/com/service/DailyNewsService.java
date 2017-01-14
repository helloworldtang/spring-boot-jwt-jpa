package com.service;

import com.domain.ItemStatus;
import com.domain.ListData;
import com.repository.DailyNewsRepository;
import com.request.PageReq;
import com.response.DailyNewsRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by tang.cheng on 2017/1/14.
 */
@Service
public class DailyNewsService {

    @Autowired
    private DailyNewsRepository dailyNewsRepository;

    public ListData<DailyNewsRes> getDailyNews(PageReq pageReq) {

        Sort sort=new Sort(Sort.Direction.DESC,"create_time");
        PageRequest pageable = new PageRequest(pageReq.getPage(), pageReq.getSize(), sort);
        Page<DailyNewsRes> result = dailyNewsRepository.findByStatus(ItemStatus.NORMAL.getStatus(), pageable);
        ListData<DailyNewsRes> listData=new ListData<>();
        listData.setInfoList(result.getContent());
        listData.setHasNext(result.hasNext());
        listData.setNextPageId(result.getNumber());
        return listData;
    }

}
