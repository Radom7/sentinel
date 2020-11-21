package com.haiyu.consumer.feign;

import com.haiyu.consumer.feign.fallback.FeignAgentFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Desc: 流控规则的资源格式：http请求方式:协议://服务名/请求路径和参数
 *                GET:http://sentinel-fegin-provider/hello
 * @Author: liuxing
 * @Date: 2020/11/21 20:01
 * @Version 1.0
 */
@FeignClient(value = "sentinel-feign-provider",fallback = FeignAgentFallBack.class)
public interface FeignAgent {
    @GetMapping("/hello")
    String hello();
}
