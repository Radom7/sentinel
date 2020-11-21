package com.haiyu.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 20:09
 * @Version 1.0
 */
@RestController
public class ProviderController {
    @GetMapping("hello")
    public String hello(){
        return "Hello Sentinel!";
    }
}
