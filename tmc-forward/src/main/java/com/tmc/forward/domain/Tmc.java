package com.tmc.forward.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by Hongjian_He on 2017/9/8.
 */
@Document
public class Tmc implements Serializable {
        private static final long serialVersionUID = 3770198526461322514L;
        private Date mongo_back_create_time;
        private String topic;
        private String pubAppKey;
        private Long pubTime;
        private Long outgoingTime;
        private Long userId;
        private String userNick;
        private String content;
        private Map<String, Object> raw;

        public Tmc() {
        }

        public String getTopic() {
            return this.topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public String getPubAppKey() {
            return this.pubAppKey;
        }

        public void setPubAppKey(String pubAppKey) {
            this.pubAppKey = pubAppKey;
        }

        public Long getPubTime() {
            return this.pubTime;
        }

        public void setPubTime(Long pubTime) {
            this.pubTime = pubTime;
        }

        public Long getOutgoingTime() {
            return this.outgoingTime;
        }

        public void setOutgoingTime(Long outgoingTime) {
            this.outgoingTime = outgoingTime;
        }

        public Long getUserId() {
            return this.userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserNick() {
            return this.userNick;
        }

        public void setUserNick(String userNick) {
            this.userNick = userNick;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Map<String, Object> getRaw() {
            return this.raw;
        }

        protected void setRaw(Map<String, Object> raw) {
            this.raw = raw;
        }

    public Date getMongo_back_create_time() {
        return mongo_back_create_time;
    }

    public void setMongo_back_create_time(Date mongo_back_create_time) {
        this.mongo_back_create_time = mongo_back_create_time;
    }
}
