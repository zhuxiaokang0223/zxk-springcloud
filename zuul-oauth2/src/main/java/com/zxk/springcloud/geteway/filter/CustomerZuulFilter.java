package com.zxk.springcloud.geteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Description: 自定义ZuulFilter
 *   ZuulFilter自带的公用变量在FilterConstants中
 * @Author: zhuxiaokang
 * @CreateDate: 2019/6/25 17:03
 * @Version: 1.0
 */
@Component
public class CustomerZuulFilter extends ZuulFilter {

    /**
     * 过滤器类型选择：
     * pre 为路由前
     * route 为路由过程中
     * post 为路由过程后
     * error 为出现错误的时候
     * 同时也支持static ，返回静态的响应，详情见StaticResponseFilter的实现
     * 以上类型在会创建或添加或运行在FilterProcessor.runFilters(type)
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 用来过滤器排序执行的
     * @return 排序的序号
     */
    @Override
    public int filterOrder() {
//        return PRE_DECORATION_FILTER_ORDER - 1;
        return 0;
    }

    /**
     * 是否通过这个过滤器，默认为true，改成false则不启用
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.err.println("先OAuth2鉴权成功之后，才会到zuulFilter中执行");
        return null;
    }
}
