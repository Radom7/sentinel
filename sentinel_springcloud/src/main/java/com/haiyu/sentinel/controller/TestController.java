package com.haiyu.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 11:35
 * @Version 1.0
 */
@RestController
public class TestController {

    // value代表资源名称  blockHandler：设置限流或降级处理的类
    @SentinelResource(value = "Sentinel_springcloud",blockHandler = "exceptionHandler")
    @GetMapping("/hello")
    public String hello(){
        //使用限流规则
        return "Hello Sentinel";
    }

    public String exceptionHandler(BlockException e){
        e.printStackTrace();
        return "系统繁忙请稍后再试";
    }

}
