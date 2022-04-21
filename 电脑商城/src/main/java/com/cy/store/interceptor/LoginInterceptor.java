package com.cy.store.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    //检测全局session中是否有uid数据，如果有则放行，否则重定向到登录界面
    //返回true放行，false拦截
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("uid");
        if(obj == null){
            response.sendRedirect("/web/login.html");
            return false;
        }

        return true;
    }
}
