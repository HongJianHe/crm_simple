package com.tmc.forward.dao;

import com.alibaba.fastjson.JSONArray;
import com.tmc.forward.domain.TmcMsg;
import com.tmc.forward.task.ReadTmc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hongjian_He on 2017/9/9.
 */
@Component
public class   TmcRepository  {
    private static Logger logger = LoggerFactory.getLogger(ReadTmc.class);
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<TmcMsg> findCurrentAll(Long currentTimeMillis) throws Exception {
        List<TmcMsg> list = null;
        try {
            Query query=new Query(Criteria.where("pubTime").gte(currentTimeMillis));
            logger.info("*********************当前时间：{}", JSONArray.toJSONString(query));
            list=mongoTemplate.find(query, TmcMsg.class,"tmc-msg");
            logger.info("*********************读取消息：{}", JSONArray.toJSONString(list));
        } catch (Exception e) {
            logger.info("*********************读取消息：{}", JSONArray.toJSONString(e));
            throw new Exception("数据查询失败");
        }
        return list;

    }
    public void save(){
        TmcMsg TmcMsg = new TmcMsg();
        TmcMsg.setTopic("hongjian");
        mongoTemplate.insert(TmcMsg);
    }
}
