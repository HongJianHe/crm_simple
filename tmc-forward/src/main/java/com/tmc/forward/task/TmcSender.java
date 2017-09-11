package com.tmc.forward.task;

import com.alibaba.fastjson.JSONArray;
import com.tmc.forward.domain.TmcMsg;
import com.tmc.forward.rabbitMq.BaseMQConn;
import org.springframework.stereotype.Component;

import java.io.IOException;

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
    public void publishEvent(TmcMsg tmcMsg) throws IOException {
        this.getChannel().basicPublish(EXCHANGE, tmcMsg.getTopic(),
                null, JSONArray.toJSONString(tmcMsg.getContent()).getBytes());
    }
}
