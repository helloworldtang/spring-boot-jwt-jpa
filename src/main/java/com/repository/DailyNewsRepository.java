package com.repository;

import com.domain.biz.DailyNews;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public interface DailyNewsRepository extends PagingAndSortingRepository<DailyNews,Long> {
    Page<DailyNews> findByStatus(Byte status,Pageable pageable);

}
