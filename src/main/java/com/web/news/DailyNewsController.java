package com.web.news;

import com.domain.ListData;
import com.domain.biz.DailyNewsReq;
import com.domain.biz.DailyNewsUpdateReq;
import com.domain.request.PageReq;
import com.domain.response.DailyNewsRes;
import com.service.DailyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1")
public class DailyNewsController {

    @Autowired
    private DailyNewsService dailyNewsService;

    @RequestMapping(value = "/daily/news", method = RequestMethod.GET)
    public ResponseEntity<ListData<DailyNewsRes>> getDailyNews(PageReq pageReq) {
        ListData<DailyNewsRes> dailyNews = dailyNewsService.getDailyNews(pageReq);
        return ResponseEntity.ok(dailyNews);
    }

    @RequestMapping(value = "/daily/news", method = RequestMethod.POST)
    public ResponseEntity<Long> addDailyNews(@Valid @ModelAttribute DailyNewsReq newsReq) {
        Long id = dailyNewsService.addDailyNews(newsReq);
        return ResponseEntity.ok(id);
    }

    @Transactional
    @RequestMapping(value = "/daily/news/{dailyNewsId}", method = RequestMethod.PUT)
    public ResponseEntity<Integer> updateDailyNewsStatus(@Valid @ModelAttribute DailyNewsUpdateReq updateReq) {
        int count = dailyNewsService.updateDailyNewsStatus(updateReq);
        return ResponseEntity.ok(count);
    }

}
