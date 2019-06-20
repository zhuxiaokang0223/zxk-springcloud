package com.zxk.springcloud.security.oauth2.db.auth.customer;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import java.util.Collection;

/**
 * @Description: 自定义鉴权类
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/19 10:40
 * @Version: 1.0
 */
public class CustomerAccessDecisionVoter implements AccessDecisionVoter<Object> {

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute instanceof SecurityConfig;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }

    /**
     * 鉴权
     * @param authentication 当前访问者的权限
     * @param object 请求信息
     * @param attributes 目标资源的权限
     * @return
     */
    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
        // 当前访问者无权限，直接拒绝
        if(authentication == null) {
            return ACCESS_DENIED;
        }
        // ACCESS_ABSTAIN 表示弃权
        int result = ACCESS_ABSTAIN;

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (ConfigAttribute attribute : attributes) {
            if(StringUtils.isEmpty(attribute.getAttribute())){
                continue;
            }
            if (!supports(attribute)) {
                continue;
            }
            // 尝试匹配权限
            result = ACCESS_DENIED;
            for (GrantedAuthority authority : authorities) {
                if (attribute.getAttribute().equals(authority.getAuthority())) {
                    return ACCESS_GRANTED;
                }
            }
        }
        return result;
    }
}
