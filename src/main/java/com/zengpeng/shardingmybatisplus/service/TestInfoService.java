package com.zengpeng.shardingmybatisplus.service;


import com.zengpeng.shardingmybatisplus.entity.TestInfoEntity;
import com.zengpeng.shardingmybatisplus.mapper.TestInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestInfoService {

    @Autowired
    TestInfoMapper testInfoMapper;

    public TestInfoEntity selectById(Long id) {
        return testInfoMapper.selectById(id);
    }

    public TestInfoEntity save(TestInfoEntity testInfoEntity){
        testInfoMapper.insert(testInfoEntity);
        return testInfoEntity;
    }


}
