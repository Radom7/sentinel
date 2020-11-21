package com.haiyu.consumer.feign.fallback;

import com.haiyu.consumer.feign.FeignAgent;
import org.springframework.stereotype.Component;

/**
 * @Desc: 降级处理类
 * @Author: liuxing
 * @Date: 2020/11/21 20:26
 * @Version 1.0
 */
@Component
public class FeignAgentFallBack implements FeignAgent {
    //限流降级处理
    public String hello() {
        return "系统繁忙！";
    }
}
