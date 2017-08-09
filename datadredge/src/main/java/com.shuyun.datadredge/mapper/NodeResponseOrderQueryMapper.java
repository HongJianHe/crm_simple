package com.shuyun.datadredge.mapper;

import com.shuyun.datadredge.domain.NodeResponseOrderQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Hongjian_He on 2017/8/9.
 */
public interface NodeResponseOrderQueryMapper  {

    void updateResponseNodeOrderQuery(@Param("selectItems") String selectItems, @Param("id") Long id);

    List<NodeResponseOrderQuery> findResponseOrderQuery();
}
