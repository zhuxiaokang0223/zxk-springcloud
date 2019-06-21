package com.zxk.springcloud.security.oauth2.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/17 18:35
 * @Version: 1.0
 */
@SpringBootApplication
public class OAuth2Application {

    public static void main(String[] args) {

        SpringApplication.run(OAuth2Application.class, args);
    }

}
