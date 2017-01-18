package com.domain.biz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public interface DailyNewsRepository extends JpaRepository<DailyNews,Long> {
    Page<DailyNews> findByStatus(Byte status,Pageable pageable);

}
