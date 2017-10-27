package com.web.news;

import com.domain.ListData;
import com.domain.biz.DailyCategory;
import com.domain.biz.DailyCategoryReq;
import com.domain.request.PageReq;
import com.service.DailyCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by tangcheng on 2017/2/13.
 */
@Api(value = "Category Handler", tags = "Category Manager", description = "category manager")
@RestController
@RequestMapping("/v1")
public class DailyCategoryController {

    @Autowired
    private DailyCategoryService dailyCategoryService;

    @ApiOperation("add category")
    @RequestMapping(value = "/daily/category", method = RequestMethod.POST)
    public ResponseEntity<Long> add(@Valid @RequestBody DailyCategoryReq req) {
        Long categoryId = dailyCategoryService.add(req);
        return ResponseEntity.ok(categoryId);
    }


    @ApiOperation("list category")
    @RequestMapping(value = "/daily/category", method = RequestMethod.GET)
    public ResponseEntity<ListData<DailyCategory>> getDailyCategoryList(PageReq pageReq) {
        ListData<DailyCategory> dailyCategoryList = dailyCategoryService.findAll(pageReq);
        return ResponseEntity.ok(dailyCategoryList);
    }


}
