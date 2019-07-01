package com.zxk.springcloud.geteway.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * @Description: Security配置
 * @Author: zhuxiaokang
 * @CreateDate: 2019/7/1 11:11
 * @Version: 1.0
 */
@Configuration
public class CustomizeWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    /**
     * 需要配置这个支持password模式 support password grant type
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
