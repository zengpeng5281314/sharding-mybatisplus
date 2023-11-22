package com.zengpeng.shardingmybatisplus;

import com.zengpeng.shardingmybatisplus.entity.OrderInfoEntity;
import com.zengpeng.shardingmybatisplus.entity.TestInfoEntity;
import com.zengpeng.shardingmybatisplus.mapper.OrderInfoMapper;
import com.zengpeng.shardingmybatisplus.mapper.TestInfoMapper;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ShardingMybatisplusApplicationTests {

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    TestInfoMapper testInfoMapper;

    @Test
    void contextLoads() {
        Map<String, Object> map = new HashMap<>();
        map.put("org_id", 1L);
        map.put("user_id", 10L);
        map.put("id", 933385439094505472L);
        List<OrderInfoEntity> list = orderInfoMapper.selectByMap(map);
        System.out.println("----" + list.toString());


    }

    @Test
    void testInfoMapper() {
        Map<String, Object> map = new HashMap<>();
        map.put("org_id", 1);
        map.put("user_id", 1);
//        map.put("id",1L);
        List<TestInfoEntity> list = testInfoMapper.selectByMap(map);
        System.out.println("----" + list.toString());


    }

}
