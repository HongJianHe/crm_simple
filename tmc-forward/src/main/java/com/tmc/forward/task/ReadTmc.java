package com.tmc.forward.task;

import com.tmc.forward.dao.TmcRepository;
import com.tmc.forward.domain.TmcMsg;
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
        Long currentTimeMillis = System.currentTimeMillis();
        while (true){
            try {
                TmcSender tmcSender = new TmcSender();
                logger.info("*********************读取消息开始：{}",currentTimeMillis);
                List<TmcMsg> currentAll = tmcRepository.findCurrentAll(currentTimeMillis);
                //发送mq
                if (currentAll != null && currentAll.size() >= 0) {
                    for (TmcMsg tmcMsg : currentAll) {
                        try {
                            tmcSender.publishEvent(tmcMsg);
                        }catch (Exception e){
                            logger.info("*********************发布消息失败：{}*********************", tmcMsg);
                        }finally {
                            currentTimeMillis = tmcMsg.getPubTime();
                        }
                    }
                    logger.info("读取消息结束");
                }
                tmcSender.getChannel().close();
                tmcSender.getConnection().close();
                logger.info("*********************休眠5分钟*********************");
                Thread.sleep(300000);
            }catch (Exception e ){
                logger.info("*********************发布消息失败*********************");
            }finally {
            }
        }
    }


}
