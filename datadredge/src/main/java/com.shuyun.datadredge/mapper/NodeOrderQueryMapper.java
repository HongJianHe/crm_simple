package com.shuyun.datadredge.mapper;

import com.shuyun.datadredge.domain.NodeOrderQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Hongjian_He on 2017/8/9.
 */
@Component
public interface NodeOrderQueryMapper {
    void updateNodeOrderQuery(@Param("selectItems") String selectItems , @Param("id") Long id);
    List<NodeOrderQuery> findOrderQuery();
}
