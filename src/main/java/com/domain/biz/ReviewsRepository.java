package com.domain.biz;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tangcheng on 2017/2/18.
 */
public interface ReviewsRepository extends JpaRepository<Reviews, Long> {
    List<Reviews> findByApp(Long app);

    List<Reviews> findByAppOrderByRetrievedDateDesc(Long app);
}
