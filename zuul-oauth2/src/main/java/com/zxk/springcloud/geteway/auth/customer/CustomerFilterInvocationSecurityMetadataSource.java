package com.zxk.springcloud.geteway.auth.customer;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 自定义鉴权资源Filter
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/18 18:10
 * @Version: 1.0
 */
public class CustomerFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    private static final AntPathMatcher antPathMatcher = new AntPathMatcher();

    /** 资源权限分隔符 */
    private static final String URL_ROLE_SPLIT = ",";

    public CustomerFilterInvocationSecurityMetadataSource(){
        // TODO 从数据库加载权限配置
    }

    // 这里的需要从DB加载
    private static final Map<String,String> urlRoleMap = new HashMap<String,String>(){{
        put("/product","role0,role6");
        put("/oms-api/order/**","role2");
    }};


    /**
     * 获取可访问目标资源的权限
     * @param object 访问请求信息
     * @return 权限集合
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 获取资源路径
        String url = getRequestPath(((FilterInvocation)object).getRequest());
        // 获取权限
        for(Map.Entry<String, String> entry : urlRoleMap.entrySet()){
            if(antPathMatcher.match(entry.getKey(), url)){
                return SecurityConfig.createList(entry.getValue().split(URL_ROLE_SPLIT));
            }
        }
        // 没找到当前资源的权限，则视为开放资源
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

    /**
     * 得到请求资源地址
     *    如：http://localhost:8080/order?id=1， 返回 /order
     * @param request  请求信息
     * @return
     */
    private String getRequestPath(HttpServletRequest request) {
        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            url = StringUtils.hasLength(url) ? url + pathInfo : pathInfo;
        }
        return url;
    }

}
