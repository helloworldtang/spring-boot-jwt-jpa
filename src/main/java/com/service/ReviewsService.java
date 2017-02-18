package com.service;

import com.domain.biz.Reviews;
import com.domain.biz.ReviewsRepository;
import com.domain.biz.ReviewsReq;
import com.domain.biz.ReviewsRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangcheng on 2017/2/18.
 */
@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    public List<String> getVersions(ReviewsReq vo) {
        List<Reviews> reviewsList = reviewsRepository.findByApp(vo.getApp());
        List<String> list = new ArrayList<>(reviewsList.size());
        for (Reviews reviews : reviewsList) {
            if (list.contains(reviews.getVersion())) {
                continue;
            }
            list.add(reviews.getVersion());
        }
        return list;
    }

    public List<ReviewsRes> getReviews(ReviewsReq vo) {
        List<Reviews> reviewsList = reviewsRepository.findByAppOrderByRetrievedDateDesc(vo.getApp());
        List<ReviewsRes> resList = new ArrayList<>(reviewsList.size());
        for (Reviews reviews : reviewsList) {
            ReviewsRes res = new ReviewsRes();
            BeanUtils.copyProperties(reviews, res);
            res.setRetrievedDate(reviews.getRetrievedDate().getTime());
            resList.add(res);
        }
        return resList;
    }
}
