package com.tmc.forward.dao;

import com.alibaba.fastjson.JSONArray;
import com.tmc.forward.domain.Tmc;
import com.tmc.forward.task.ReadTmc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Hongjian_He on 2017/9/9.
 */
@Component
public class   TmcRepository  {
    private static Logger logger = LoggerFactory.getLogger(ReadTmc.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Tmc> findCurrentAll(){
        List<Tmc> list = null;

        try {

            Query query=new Query(Criteria.where("pubTime").gte(System.currentTimeMillis()));
            logger.info("当前时间：{}", JSONArray.toJSONString(query));
            list=mongoTemplate.find(query, Tmc.class);
            logger.info("读取消息：{}", JSONArray.toJSONString(list));
        } catch (Exception e) {
            // TODO: handle exception
            logger.info("读取消息：{}", JSONArray.toJSONString(e));
        }
        return list;

    }
    public void save(){
        Tmc Tmc = new Tmc();
        Tmc.setTopic("hongjian");
        mongoTemplate.insert(Tmc);
    }
}
