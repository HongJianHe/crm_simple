package com.tmc.forward.task;

import com.alibaba.fastjson.JSONArray;
import com.tmc.forward.domain.Tmc;
import com.tmc.forward.rabbitMq.BaseMQConn;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * Created by Hongjian_He on 2017/9/10.
 */
@Component
public class TmcSender extends BaseMQConn implements Runnable{
    public static final String EXCHANGE = "tmc-exchange";

    @Override
    public void run() {
        try {
            this.getChannel().exchangeDeclare(EXCHANGE, "topic");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void publishEvent(Tmc tmc) throws IOException {
        try {
            this.getChannel().basicPublish(EXCHANGE, tmc.getTopic(),
                    null, JSONArray.toJSONString(tmc.getContent()).getBytes());
        } catch (IOException e) {
            throw new IOException("MetaInfoMQProducer发布消息出错");
        }
    }
}
