package com.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tang.cheng on 2017/1/22.
 */
@Controller
public class DefaultController {
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


//    @RequestMapping(value = "/")
//    public String index() {
//        System.out.println("swagger-ui.html");
//        return "redirect:swagger-ui.html";
//    }


}
