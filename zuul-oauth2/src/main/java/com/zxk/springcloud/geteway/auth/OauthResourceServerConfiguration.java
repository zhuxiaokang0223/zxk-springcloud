package com.zxk.springcloud.geteway.auth;

import com.zxk.springcloud.geteway.auth.customer.CustomerAccessDecisionVoter;
import com.zxk.springcloud.geteway.auth.customer.CustomerFilterInvocationSecurityMetadataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: OAuth2 资源服务
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/18 9:59
 * @Version: 1.0
 */
@Configuration
@EnableResourceServer
public class OauthResourceServerConfiguration extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.resourceId("order").stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers().anyRequest()
                .and()
                .anonymous()
                .and()
                .authorizeRequests()
                .antMatchers("/orderbbb/**").hasAnyAuthority("role2", "role4", "role5")
//                .authenticated();
                .and()
                .authorizeRequests() // 自定义FilterInvocationSecurityMetadataSource
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(
                            O fsi) {
                        fsi.setSecurityMetadataSource(mySecurityMetadataSource());
                        fsi.setAccessDecisionManager(accessDecisionManager());
                        return fsi;
                    }
                });
    }


    /**
     * 资源数据来源
     * @return
     */
    public CustomerFilterInvocationSecurityMetadataSource mySecurityMetadataSource() {
        CustomerFilterInvocationSecurityMetadataSource securityMetadataSource = new CustomerFilterInvocationSecurityMetadataSource();
        return securityMetadataSource;
    }

    /**
     * 定义鉴权实现类
     * @return
     */
    public AccessDecisionManager accessDecisionManager() {
        List<AccessDecisionVoter<? extends Object>> decisionVoters
                = Arrays.asList(
                new CustomerAccessDecisionVoter()
        );
        return new AffirmativeBased(decisionVoters);
    }
}
