package com.zxk.springcloud.security.oauth2.db.api;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/17 17:13
 * @Version: 1.0
 */
@Component
public class CustomizeUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("role0"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return new User(username, "{noop}123456", grantedAuthorityList);
    }

//    /**
//     * 根据用户名获取用户信息
//     * @param userName
//     * @return
//     * @throws UsernameNotFoundException
//     */
//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//
//        if (userName == null) {
//            throw new UsernameNotFoundException("非法账户");
//        }
//        // 权限集合。 GrantedAuthority是security提供的权限类
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if (userName.equals("zhangsan")) {
//            authorities.add(new SimpleGrantedAuthority("ROLE_admin"));
//        } else {
//            authorities.add(new SimpleGrantedAuthority("ROLE_user"));
//        }
//        return new User(userName, "123456", authorities);
//    }

}
