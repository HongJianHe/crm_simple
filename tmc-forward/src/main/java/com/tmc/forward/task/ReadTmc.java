package com.tmc.forward.task;

import com.tmc.forward.dao.TmcRepository;
import com.tmc.forward.domain.Tmc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取线上mongo中的tmc
 * Created by Hongjian_He on 2017/9/10.
 */
@Component
@Order(value=1)
public class ReadTmc implements CommandLineRunner {
    private static Logger logger = LoggerFactory.getLogger(ReadTmc.class);
    @Autowired
    private TmcRepository tmcRepository;
    @Override
    public void run(String... strings) throws Exception {
        logger.info("读取消息开始");
        List<Tmc> currentAll = tmcRepository.findCurrentAll();
        //发送mq
        if(currentAll!=null && currentAll.size()>=0){
            for (Tmc tmc:currentAll) {
                TmcSender tmcSender = new TmcSender();
                tmcSender.publishEvent(tmc);
            }
        }
        Thread.sleep(1000);
        logger.info("读取消息结束");
    }


}
