package com.zengpeng.shardingmybatisplus.controller;



import com.zengpeng.shardingmybatisplus.service.OrderInfoService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test1")
public class TestController {

    @Resource
    private OrderInfoService orderInfoService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam(name = "type",defaultValue = "") String type,@RequestParam(name = "id",defaultValue = "0") Long id){
        if(type.equals("insert")){
            return orderInfoService.save().toString();
        }else{
            return orderInfoService.getUserById(id).toString();
//            return "";
        }



    }
}
