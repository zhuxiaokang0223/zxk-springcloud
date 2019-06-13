package com.zxk.springcloud.eureka.client.oms.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: Ribbon 负载均衡器配置
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/13 11:25
 * @Version: 1.0
 */
@Configuration
public class RibbonConfig {

    /**
     * RestTemplate启用负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 设置负载均衡算法（默认轮询，可以不配置）
     * @return
     */
    @Bean
    public IRule iRule() {
        return new RoundRobinRule();
    }


}
