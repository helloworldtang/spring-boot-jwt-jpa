package com.web.review;

import com.domain.biz.ReviewsReq;
import com.domain.biz.ReviewsRes;
import com.service.ReviewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tangcheng on 2017/2/18.
 */
@Api(tags = "Review manage", description = "review manager")
@RestController
@RequestMapping("/v1")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @ApiOperation("list version")
    @RequestMapping(value = "getVersions", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getVersions(@ModelAttribute @Valid ReviewsReq vo) {
        List<String> versions = reviewsService.getVersions(vo);
        return ResponseEntity.ok(versions);
    }

    @ApiOperation("list reviews")
    @Transactional
    @RequestMapping(value = "getReviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewsRes>> getReviews(@ModelAttribute @Valid ReviewsReq vo) {
        List<ReviewsRes> resList = reviewsService.getReviews(vo);
        return ResponseEntity.ok(resList);
    }

}
