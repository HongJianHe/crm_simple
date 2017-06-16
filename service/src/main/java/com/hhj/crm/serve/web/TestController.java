package com.hhj.crm.serve.web;

import com.hhj.crm.serve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Hongjian_He on 2017/6/16.
 */
@RestController
public class TestController {

    @Autowired
    TestService testService;
    @GetMapping("/service")
    public String service(@RequestParam("id") long id){
        testService.insert();
        return "何宏健service" + id;
    }
}
