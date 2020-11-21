package com.haiyu.sentinel.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 13:17
 * @Version 1.0
 */
@Configuration
public class SentinelAspectConfiguration {
    @Bean
    public SentinelResourceAspect getSentinelResourceAspect(){
        return new SentinelResourceAspect();
    }
}
