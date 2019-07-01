package com.zxk.springcloud.geteway.auth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: Security 用户信息
 * @Author: zhuxiaokang
 * @CreateDate: 2019/7/1 11:13
 * @Version: 1.0
 */
@Component
public class CustomizeUserDetailsService implements UserDetailsService {

    /**
     * 根据用户名名获取用户信息。 用于权限校验
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username, "{noop}123456", grantedAuthorityList);
    }
}
