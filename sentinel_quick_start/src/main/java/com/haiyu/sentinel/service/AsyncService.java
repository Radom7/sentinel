package com.haiyu.sentinel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 12:43
 * @Version 1.0
 */
@Service
@Slf4j
public class AsyncService {

    //Async表示方法为异步调用
    @Async
    public void hello(){
        log.info("异步调用开始======");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("异步调用结束=====");
    }
}
