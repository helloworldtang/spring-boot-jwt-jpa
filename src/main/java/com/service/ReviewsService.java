package com.service;

import com.domain.biz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by tangcheng on 2017/2/18.
 */
@Service
public class ReviewsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewsService.class);

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private AppsRepository appsRepository;

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
        if (reviewsList.isEmpty()) {
            Apps apps = new Apps();
            apps.setId(vo.getApp());
            long count = appsRepository.count(Example.of(apps));
            if (count == 0) {
                apps.setEnabled(true);
                apps.setName("");
                apps.setIphone(false);
                apps.setIpad(false);
                apps.setOsx(false);
                appsRepository.saveAndFlush(apps);
            } else {
                LOGGER.info("do nothing.appId:{} already exists.", vo.getApp());
            }
            return newArrayList();
        }
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
