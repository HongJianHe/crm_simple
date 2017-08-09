package com.shuyun.datadredge.service;

import com.alibaba.fastjson.JSON;
import com.shuyun.datadredge.domain.NodeOrderQuery;
import com.shuyun.datadredge.domain.NodeResponseOrderQuery;
import com.shuyun.datadredge.domain.SelectItemVo;
import com.shuyun.datadredge.mapper.NodeOrderQueryMapper;
import com.shuyun.datadredge.mapper.NodeResponseOrderQueryMapper;
import org.springframework.beans. BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Hongjian_He on 2017/8/9.
 */
@Service
public class NodeOrderQueryService {

    @Autowired
    NodeOrderQueryMapper nodeOrderQueryMapper;
    @Autowired
    NodeResponseOrderQueryMapper nodeResponseOrderQueryMapper;

    /**
     * 更新订单查询节点历史数据
     */
    public void updateRelation() {

            List<NodeOrderQuery> list = nodeOrderQueryMapper.findOrderQuery();
            updateSelectItems(list);

            List<NodeResponseOrderQuery> nodeResponseOrderQueries = nodeResponseOrderQueryMapper.findResponseOrderQuery();
            updateSelect(nodeResponseOrderQueries);
    }
    public void updateSelect(List<NodeResponseOrderQuery> list) {
        for (NodeResponseOrderQuery nodeOrderQuery: list) {
            List<NodeOrderQuery.QueryUnit> queryUnits = JSON.parseArray(nodeOrderQuery.getSelectItems()
                    , NodeOrderQuery.QueryUnit.class);
            System.out.println("订单响应节点："+JSON.toJSONString(queryUnits));
            List<NodeOrderQuery.QueryUnit> newQueryUnits = new ArrayList<NodeOrderQuery.QueryUnit>();
            newQueryUnit(queryUnits,newQueryUnits);
            //更新数据库
            nodeOrderQuery.setSelectItems(JSON.toJSONString(newQueryUnits));
            nodeResponseOrderQueryMapper.updateResponseNodeOrderQuery(nodeOrderQuery.getSelectItems(),nodeOrderQuery.getId());
            System.out.println("订单响应节点："+JSON.toJSONString(newQueryUnits));
        }
    }
    public void updateSelectItems(List<NodeOrderQuery> list) {
        for (NodeOrderQuery nodeOrderQuery: list) {
            List<NodeOrderQuery.QueryUnit> queryUnits = JSON.parseArray(nodeOrderQuery.getSelectItems()
                    , NodeOrderQuery.QueryUnit.class);
            System.out.println(JSON.toJSONString(queryUnits));
            List<NodeOrderQuery.QueryUnit> newQueryUnits = new ArrayList<NodeOrderQuery.QueryUnit>();
            newQueryUnit(queryUnits,newQueryUnits);
            //更新数据库
            nodeOrderQuery.setSelectItems(JSON.toJSONString(newQueryUnits));
            nodeOrderQueryMapper.updateNodeOrderQuery(nodeOrderQuery.getSelectItems(),nodeOrderQuery.getId());
            System.out.println(JSON.toJSONString(newQueryUnits));
        }
    }

    private void newQueryUnit(List<NodeOrderQuery.QueryUnit> queryUnits, List<NodeOrderQuery.QueryUnit> newQueryUnits) {
        for (NodeOrderQuery.QueryUnit  queryUnit: queryUnits){
            List<SelectItemVo> selectItemVos = queryUnit.getData();
            NodeOrderQuery.QueryUnit newQueryU= new NodeOrderQuery.QueryUnit();
            newQueryU.setName(queryUnit.getName());
            newQueryU.setIndex(queryUnit.getIndex());
            List<SelectItemVo> selectItems = new ArrayList<SelectItemVo>();
            for (SelectItemVo selectItem : selectItemVos) {
                String key = selectItem.getKey();
                SelectItemVo selectItemVo =new SelectItemVo();
                BeanUtils.copyProperties(selectItem, selectItemVo);
                if("order_date".equals(key)){
                    selectItemVo.setKey("order_time");
                    SelectItemVo.OperatorVo operatorVo = new SelectItemVo.OperatorVo();
                    operatorVo.setKey(selectItem.getOperator().getKey());
                    Map<String,Object> map = new HashMap();
                    if(selectItem.getOperator().getParams().get("startDate")!=null && selectItem.getOperator().getParams().get("endDate")!= null){
                        map.put("startTime",  selectItem.getOperator().getParams().get("startDate")+" 00:00:00");
                        map.put("endTime", selectItem.getOperator().getParams().get("endDate")+" 00:00:00");
                    }else{
                        map.put("relativeDays",  selectItem.getOperator().getParams().get("relativeDays"));
                    }
                    operatorVo.setParams(map);
                    selectItemVo.setOperator(operatorVo);
                }else if("pay_date".equals(key)){
                    selectItemVo.setKey("pay_time");
                    SelectItemVo.OperatorVo operatorVo = new SelectItemVo.OperatorVo();
                    operatorVo.setKey(selectItem.getOperator().getKey());
                    Map<String,Object> map = new HashMap();
                    if(selectItem.getOperator().getParams().get("startDate")!=null && selectItem.getOperator().getParams().get("endDate")!= null){
                        map.put("startTime", (String) selectItem.getOperator().getParams().get("startDate")+" 00:00:00");
                        map.put("endTime", (String) selectItem.getOperator().getParams().get("endDate")+" 00:00:00");
                    }else{
                        map.put("relativeDays", selectItem.getOperator().getParams().get("relativeDays"));
                    }
                    operatorVo.setParams(map);
                    selectItemVo.setOperator(operatorVo);
                }else if("order_amount".equals(key)){
                    selectItemVo.setKey("order_amount_double");
                    SelectItemVo.OperatorVo operatorVo = new SelectItemVo.OperatorVo();
                    operatorVo.setKey(selectItem.getOperator().getKey());
                    Map<String,Object> map = new HashMap();
                    map.put("low",  selectItem.getOperator().getParams().get("low")+".00");
                    map.put("high", selectItem.getOperator().getParams().get("high")+".00");
                    operatorVo.setParams(map);
                    selectItemVo.setOperator(operatorVo);
                }

                selectItems.add(selectItemVo);
            }
            newQueryU.setData(selectItems);
            newQueryUnits.add(newQueryU);
        }
    }
}
