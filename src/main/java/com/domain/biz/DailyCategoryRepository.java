package com.domain.biz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tangcheng on 2017/2/13.
 */
public interface DailyCategoryRepository extends JpaRepository<DailyCategory,Long> {
    Page<DailyCategory> findByStatusOrderByCreatedTimeDesc(Byte status, Pageable pageable);
}
