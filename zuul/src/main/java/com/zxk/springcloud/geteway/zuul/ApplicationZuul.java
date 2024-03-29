package com.zxk.springcloud.geteway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description: Zuul网关
 *     注册到Eureka
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/13 16:11
 * @Version: 1.0
 */
@SpringBootApplication
@EnableZuulProxy
// 也可以使用@EnableZuulServer注解，区别在于@EnableZuulServer的过滤器更多
//@EnableZuulServer
public class ApplicationZuul {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuul.class, args);
    }

}
