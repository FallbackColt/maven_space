package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: 18040
 * @date: 2023/2/18 15:49
 */
public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        getRequestURI()  获取资源的请求路径
        System.out.println("URI: " + req.getRequestURI());
//        getRequestURL()  获取请求的统一资源定位符(绝对路径)
        System.out.println("URL: " + req.getRequestURL());
//        getRemoteHost()  获取客户端的IP地址
        System.out.println("IP: " + req.getRemoteHost());
//        getHeader("str")      获取请求头str
        System.out.println("请求头User-Agent: " + req.getHeader("User-Agent"));
//        getMethod()      获取请求方式
        System.out.println("请求方式: " + req.getMethod());

    }
}
