package com.hhj.crm.serve.service.impl;

import com.hhj.crm.serve.domain.Test;
import com.hhj.crm.serve.mapper.TestMapper;
import com.hhj.crm.serve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Hongjian_He on 2017/6/16.
 */
@Component
public class TestServiceImpl implements TestService {
    @Autowired
    TestMapper testMapper;
    @Override
    public void insert() {
        int insert = testMapper.insert(new Test("hehongjian",Integer.decode("1")));
    }
}
