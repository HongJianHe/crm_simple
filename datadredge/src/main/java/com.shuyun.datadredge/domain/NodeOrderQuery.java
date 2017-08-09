package com.shuyun.datadredge.domain;


import java.util.Date;
import java.util.List;

/**
 * Created by maoren on 17-2-22.
 */

public class NodeOrderQuery {
    private Long Id;
    private String name;
    private String remark;
    private String relation;//条件关系 and/or
    private Date updateTime;//条件更新时间
    private String selectItems;//配置的选项

    public static class QueryUnit{
        private Integer index;//索引页面排序
        private String name;//名字
        private List<SelectItemVo> data;//前端配置的选项

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<SelectItemVo> getData() {
            return data;
        }

        public void setData(List<SelectItemVo> data) {
            this.data = data;
        }
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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
