package com.zxk.springcloud.security.oauth2.db.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/18 9:18
 * @Version: 1.0
 */
@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
//
//    @Bean
//    public ClientDetailsService clientDetails() {
//        return new JdbcClientDetailsService(dataSource);
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(clientDetails());
        clients.jdbc(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())

                .authenticationManager(authenticationManager);
    }


    /************************************** 以下代码基于内存实现授权服务器 ****************************************************/
//    private TokenStore tokenStore = new InMemoryTokenStore();
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//   /* *
//     * 用来配置令牌端点(Token Endpoint)的安全约束.
//     */
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.allowFormAuthenticationForClients();
//    }
//
//    /**
//     * 用来配置客户端详情服务。
//     * 客户端详情信息在这里进行初始化，可以把客户端详情信息写死在这里或  者是通过数据库来存储调取详情信息。
//     */
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        //client认证
//        clients.inMemory()
//                .withClient("client_1")
////                .resourceIds("order")
//                .authorizedGrantTypes("client_credentials", "refresh_token")
////                .scopes("select")
//                // 给client_1赋予权限
//                .authorities("role1", "role2", "role3")
//                .secret("{noop}123456");
//
//    }
//
//   /* *
//     * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
//     */
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints
//                .tokenStore(tokenStore)
//                .authenticationManager(authenticationManager);
//    }
}
