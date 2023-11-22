package com.zengpeng.shardingmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zengpeng.shardingmybatisplus.mapper")
public class ShardingMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingMybatisplusApplication.class, args);
    }

}
