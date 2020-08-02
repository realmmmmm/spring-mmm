package com.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *  Zuul 的过滤器
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * filterType 过滤器类型:
     * pre：在请求路由之前执行
     * route：在请求路由时调用
     * post：请求路由之后调用， 也就是在route和errror过滤器之后调用
     * error：处理请求发生错误时调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //int值来定义过滤器的执行顺序，数值越小优先级越高
    @Override
    public int filterOrder() {
        return 1;
    }

    //该过滤器是否执行，true执行，false不执行
    @Override
    public boolean shouldFilter() {
        return true;
    }


    //定义 过滤功能 判断是否登录
    @Override
    public Object run() throws ZuulException {

        //1.获取请求上下文
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //如果说请求带了token值，则表示已经登录过
        if(token == null) {

            //没有登录 过，则不进行路由转发
            context.setSendZuulResponse(false);//拒绝访问
            context.setResponseStatusCode(200); //响应状态码
            try {
                context.getResponse().getWriter().write("token is empty...");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        //通过，会进行路由转发
        return null;
    }

}
