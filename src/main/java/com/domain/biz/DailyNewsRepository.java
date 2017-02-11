package com.domain.biz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by tang.cheng on 2017/1/14.
 */
public interface DailyNewsRepository extends JpaRepository<DailyNews,Long> {
    Page<DailyNews> findByStatus(Byte status,Pageable pageable);
    @Modifying
    @Query("update DailyNews u set u.status = ?2 where u.id = ?1")
    int updateStatus(Long id, Byte status);
}
