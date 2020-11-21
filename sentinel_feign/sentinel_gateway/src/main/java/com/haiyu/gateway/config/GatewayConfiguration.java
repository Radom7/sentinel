package com.haiyu.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.BlockRequestHandler;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

/**
 * @Desc: 配置流控降级回调操作
 * @Author: liuxing
 * @Date: 2020/11/21 21:11
 * @Version 1.0
 */
@Configuration
public class GatewayConfiguration {

    //初始化限流降级的回调函数
    @PostConstruct
    public void doInit(){
        //设置限流或降级的回调函数
        GatewayCallbackManager.setBlockHandler(new BlockRequestHandler() {
            //被限流或降级处理的方法
            @Override
            public Mono<ServerResponse> handleRequest(ServerWebExchange serverWebExchange, java.lang.Throwable throwable) {
                return ServerResponse.status(200).syncBody("系统繁忙请稍后");
            }
        });
    }

}
