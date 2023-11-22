package com.zengpeng.shardingmybatisplus.service;


import com.zengpeng.shardingmybatisplus.entity.OrderInfoEntity;
import com.zengpeng.shardingmybatisplus.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {

    @Autowired
    OrderInfoMapper orderInfoMapper;

    public OrderInfoEntity getUserById(Long id) {
        return orderInfoMapper.selectById(id);
    }

    public OrderInfoEntity save(){
        OrderInfoEntity orderInfoEntity= new OrderInfoEntity();
        orderInfoEntity.setOrgId(1L);
        orderInfoEntity.setStatus(1);
        orderInfoEntity.setUserId(1L);
        orderInfoMapper.insert(orderInfoEntity);
        return orderInfoEntity;
    }
}
