package com.shuyun.datadredge.domain;


import java.util.Date;

/**
 * Created by maoren on 17-2-22.
 */

public class NodeResponseOrderQuery {
    private Long id;
    private String name;
    private String remark;
    private String relation;//条件关系 and/or
    private Date updateTime;//条件更新时间
    private String selectItems;//配置的选项

    public NodeResponseOrderQuery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getSelectItems() {
        return selectItems;
    }

    public void setSelectItems(String selectItems) {
        this.selectItems = selectItems;
    }
}
