package com.haiyu.sentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: liuxing
 * @Date: 2020/11/21 11:35
 * @Version 1.0
 */
@RestController
@Slf4j
public class TestController {

    /**
     * 抛出异常的方式定义资源
     * 使用这种方式当资源发生限流后会抛出BlockException。这个时候可以捕获异常，进行限流之后的逻辑处理
     * @return
     */
    @GetMapping("hello")
    public String hello(){
        //使用限流规则
        try(Entry entry = SphU.entry("Hello")) {//限流入口
            return "Hello Sentinel!";//被保护的资源
        } catch (BlockException e) {
            //被限流或者降级的操作处理
            e.printStackTrace();
            return "系统繁忙，请稍后";
        }
    }

    /**
     * 返回布尔值的方式定义资源
     * 使用的API为SphO，限流后返回的值为boolean类型
     *
     * 注意：SphO.entry必须和SphO.exit成对出现 否则会报错
     */
    @GetMapping("/boolean")
    public boolean returnBoolean(){
        //使用限流规则
        if (SphO.entry("Sentinel-boolean")){
            //被保护的资源
            try {
                log.info("Hello Sentinel");
                return true;
            }finally {
                SphO.exit();//限流的出口
            }
        }else {
            //被限流或者降级的操作处理
            log.error("系统繁忙,请稍后再试");
            return false;
        }
    }


    /** 定义限流规则
     * @PostConstruct 此注解的含义是：本类构造方法执行结束后执行
     *
     * 注释掉的原因：不使用硬编码的形式定义限流规则，在sentinel控制台上定义规则进行限流
     */
//    @PostConstruct
//    public void initFloRule(){
//        //1.创建存放限流规则的集合
//        List<FlowRule> ruleList = new ArrayList<>();
//        //2.创建限流规则
//        FlowRule flowRule = new FlowRule();
//        //定义资源，表示Sentinel会对哪个资源生效
//        flowRule.setResource("Hello");
//        //定义限流的类型(此处使用QPS作为限流类型)
//        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        //定义QPS每秒通过的请求数
//        flowRule.setCount(2);
//        //3.将限流规则存放到集合中
//        ruleList.add(flowRule);
//        //4.加载限流规则
//        FlowRuleManager.loadRules(ruleList);
//    }
}
