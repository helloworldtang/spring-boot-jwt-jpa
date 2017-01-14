package com.repository;

import com.domain.biz.DailyNews;
import com.response.DailyNewsRes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public interface DailyNewsRepository extends PagingAndSortingRepository<DailyNews,Long> {
    Page<DailyNewsRes> findByStatus(Byte status,Pageable pageable);

}
