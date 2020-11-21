package com.haiyu.consumer.controller;

import com.haiyu.consumer.feign.FeignAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 20:02
 * @Version 1.0
 */
@RestController
public class TestController {

    @Autowired
    private FeignAgent feignAgent;

    @GetMapping("hello")
    public String hello(){
        return feignAgent.hello();
    }
}
