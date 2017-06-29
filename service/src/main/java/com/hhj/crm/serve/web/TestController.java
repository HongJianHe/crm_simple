package com.hhj.crm.serve.web;

import com.hhj.crm.serve.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hongjian_He on 2017/6/16.
 */
@RestController
@RequestMapping({"/home"})
public class TestController {
    private static Logger log = LoggerFactory.getLogger(TestController.class);
    @Autowired
    TestService testService;
    @GetMapping("/service")
    @ResponseBody
    public String service(@RequestParam("id") long id){
        log.info("test:{}","test");
        testService.insert();
        return "何宏健service" + id;
    }

}
