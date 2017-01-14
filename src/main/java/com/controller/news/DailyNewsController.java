package com.controller.news;

import com.domain.ListData;
import com.request.PageReq;
import com.response.DailyNewsRes;
import com.service.DailyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyNewsController {

    @Autowired
    private DailyNewsService dailyNewsService;

    @RequestMapping(value = "/daily/news", method = RequestMethod.GET)
    public ResponseEntity<?> getDailyNews(PageReq pageReq) {
        ListData<DailyNewsRes> dailyNews = dailyNewsService.getDailyNews(pageReq);
        return ResponseEntity.ok(dailyNews);
    }

}
