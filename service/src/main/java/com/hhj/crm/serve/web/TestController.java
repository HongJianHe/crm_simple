package com.hhj.crm.serve.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hongjian_He on 2017/6/16.
 */
@RestController
public class TestController {

    @GetMapping("/service")
    public String service(){
        return "何宏健service";
    }
}
