package com.shuyun.datadredge.domain;

import java.util.Map;

/**
 * Created by maoren on 17-2-21.
 * 用户选择配置
 */
public class SelectItemVo {
    private String key;//选项,QueryType.key
    private OperatorVo operator;//用户选择的操作

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public OperatorVo getOperator() {
        return operator;
    }

    public void setOperator(OperatorVo operator) {
        this.operator = operator;
    }

    public static class OperatorVo{
        private String key;//Operator.key,用户选择的操作
        private Map params;//用户配置的参数

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public Map getParams() {
            return params;
        }

        public void setParams(Map params) {
            this.params = params;
        }

        public OperatorVo() {
        }

        public OperatorVo(String key, Map params) {
            this.key = key;
            this.params = params;
        }
    }
}
