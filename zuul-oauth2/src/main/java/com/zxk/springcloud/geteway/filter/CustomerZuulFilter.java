package com.zxk.springcloud.geteway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.Enumeration;

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
        // 登录校验逻辑。
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getParameter("access_token");
        Enumeration p = req.getParameterNames();
        while(p.hasMoreElements()){
            String pname = (String)p.nextElement();
            System.err.println("param: "+ pname + " = " + req.getParameter(pname));
        }

        Enumeration e = req.getAttributeNames();
        while (e.hasMoreElements()){
            String aname = (String)e.nextElement();
            System.err.println("attribute: "+ aname + " = " + req.getAttribute(aname));
        }

        // 4) 判断
        if(token == null || "".equals(token.trim())){
            // 没有token，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return null;
    }
}
