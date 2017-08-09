package com.shuyun.datadredge.task;

import com.shuyun.datadredge.service.NodeOrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Hongjian_He on 2017/8/8.
 */
public class UpdateOrderNodeInfoTask {

    @Autowired
    private NodeOrderQueryService nodeOrderQueryService;
    public void doIt(){
        nodeOrderQueryService.updateRelation();
    }
}
