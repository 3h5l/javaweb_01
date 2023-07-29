package com.hl.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
@Slf4j
public class XbcFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化成功");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        StringBuffer requestURL = request.getRequestURL();


        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        System.out.println("Abc 拦截到了请求...放行前逻辑");
//        //放行
//        chain.doFilter(request,response);
//
//        System.out.println("Abc 拦截到了请求...放行后逻辑");
//    }
}
