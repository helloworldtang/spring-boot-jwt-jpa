package com.service;

import com.domain.ItemStatus;
import com.domain.ListData;
import com.domain.biz.DailyCategory;
import com.domain.biz.DailyCategoryRepository;
import com.domain.biz.DailyCategoryReq;
import com.domain.request.PageReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *
 * @author tangcheng
 * @date 2017/2/13
 */
@Service
public class DailyCategoryService {

    @Autowired
    private DailyCategoryRepository dailyCategoryRepository;

    public Long add(DailyCategoryReq req) {
        DailyCategory dailyCategory = new DailyCategory();
        BeanUtils.copyProperties(req, dailyCategory);
        dailyCategory.setStatus(ItemStatus.NORMAL.getStatus());
        Date now = new Date();
        dailyCategory.setCreatedTime(now);
        dailyCategory.setUpdatedTime(now);

        DailyCategory save = dailyCategoryRepository.save(dailyCategory);
        return save.getId();
    }

    public ListData<DailyCategory> findAll(PageReq pageReq) {
        Pageable pageable = new PageRequest(pageReq.getPageId(), pageReq.getPageSize());
        Page<DailyCategory> result = dailyCategoryRepository.findByStatusOrderByCreatedTimeDesc(ItemStatus.NORMAL.getStatus(), pageable);
        ListData<DailyCategory> listData = new ListData<>();
        listData.setInfoList(result.getContent());
        listData.setHasNext(result.hasNext());
        listData.setCurrentPageId(result.getNumber());
        return listData;
    }
}
