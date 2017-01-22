package com.web.news;

import com.domain.ListData;
import com.domain.request.PageReq;
import com.domain.response.DailyNewsRes;
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
    public ResponseEntity<ListData<DailyNewsRes>> getDailyNews(PageReq pageReq) {
        ListData<DailyNewsRes> dailyNews = dailyNewsService.getDailyNews(pageReq);
        return ResponseEntity.ok(dailyNews);
    }

    /**
     * In Eclipse, saving a modified file will cause the classpath to be updated and trigger a restart.
     * In IntelliJ IDEA, building the project (Build → Make Project) will have the same effect.
     *
     * @return
     */
    @RequestMapping(value = "/testHotSwap", method = RequestMethod.GET)
    public ResponseEntity<String> testHotSwap() {
        return ResponseEntity.ok("Success2");
    }

}
