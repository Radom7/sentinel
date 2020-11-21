package com.haiyu.sentinel.controller;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.haiyu.sentinel.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 12:45
 * @Version 1.0
 */
@RestController
public class TestAsyncController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/async")
    public void async(){
        //1.进行限流控制
        AsyncEntry asyncEntry = null;
        try {
            asyncEntry = SphU.asyncEntry("Sentinel_Async"); //限流入口
            asyncService.hello(); //异步调用方法
            System.out.println("异步测试");
        } catch (BlockException e) {
            e.printStackTrace();
            System.out.println("系统繁忙请稍后再试");
        } finally {
            if (asyncEntry != null){
                asyncEntry.exit(); //限流出口
            }
        }
    }

}
