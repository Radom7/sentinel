package com.haiyu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
/**
 * 启动项目，在Sentinel控制台中添加关于资源的控制规则，sentinel在适配spring cloud gateway时提供了两种配置规则
 * route维度：即在spring配置文件配置的路由条数，资源名为对应的routeId
 * 自定义API维度：用户可以利用Sentinel提供的API来自定义一些自定义分组
 */
public class SentinelGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelGatewayApplication.class, args);
    }

}
