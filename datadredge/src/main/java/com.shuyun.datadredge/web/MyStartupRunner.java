package com.shuyun.datadredge.web;

import com.shuyun.datadredge.service.NodeOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Hongjian_He on 2017/8/9.
 */
@Component
@Order(value=1)
public class MyStartupRunner implements CommandLineRunner {
    @Autowired
    private NodeOrderQueryService nodeOrderQueryService;
    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作<<<<<<<<<<<<<");
        nodeOrderQueryService.updateRelation();
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，  End<<<<<<<<<<<<<");

    }
}
