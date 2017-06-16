package com.hhj.crm.serve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by Hongjian_He on 2017/6/15
 */

@SpringBootApplication
@EnableDiscoveryClient    //单个为服务注销服务发现客户端
public class ServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
