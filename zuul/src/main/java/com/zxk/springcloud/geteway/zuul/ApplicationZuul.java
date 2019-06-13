package com.zxk.springcloud.geteway.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/13 16:11
 * @Version: 1.0
 */
@SpringBootApplication
@EnableZuulProxy
public class ApplicationZuul {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationZuul.class, args);
    }

}
