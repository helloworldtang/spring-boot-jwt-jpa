package com.web.news;

import com.domain.ListData;
import com.domain.biz.DailyNewsQueryReq;
import com.domain.biz.DailyNewsReq;
import com.domain.biz.DailyNewsUpdateReq;
import com.domain.request.PageReq;
import com.domain.response.DailyNewsRes;
import com.service.DailyNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "Daily News Manager", description = "daily news manager")
@RestController
@RequestMapping(value = "/v1")
public class DailyNewsController {

    @Autowired
    private DailyNewsService dailyNewsService;

    @ApiOperation("list daily news")
    @GetMapping(value = "/daily/news")
    public ResponseEntity<ListData<DailyNewsRes>> getDailyNews(PageReq pageReq) {
        ListData<DailyNewsRes> dailyNews = dailyNewsService.getDailyNews(pageReq);
        return ResponseEntity.ok(dailyNews);
    }

    @ApiOperation("list by special categoryId ")
    @GetMapping(value = "/daily/news/{categoryId}")
    public ResponseEntity<ListData<DailyNewsRes>> getDailyNews(DailyNewsQueryReq queryReq) {
        ListData<DailyNewsRes> dailyNews = dailyNewsService.getDailyNews(queryReq);
        return ResponseEntity.ok(dailyNews);
    }

    @ApiOperation("add")
    @RequestMapping(value = "/daily/news", method = RequestMethod.POST)
    public ResponseEntity<Long> addDailyNews(@Valid @ModelAttribute DailyNewsReq newsReq) {
        Long id = dailyNewsService.addDailyNews(newsReq);
        return ResponseEntity.ok(id);
    }

    @ApiOperation("modify")
    @Transactional
    @RequestMapping(value = "/daily/news/{dailyNewsId}", method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateDailyNewsStatus(@Valid @ModelAttribute DailyNewsUpdateReq updateReq) {
        int count = dailyNewsService.updateDailyNewsStatus(updateReq);
        return ResponseEntity.ok(count);
    }

}
