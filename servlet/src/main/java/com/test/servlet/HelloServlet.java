package com.test.servlet;

//import java.io.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//
//@WebServlet(name = "helloServlet", value = "/hello-servlet")
//public class HelloServlet extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
//}

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class HelloServlet implements Servlet {

    public HelloServlet() { // 第一次访问的时候创建Servlet程序时调用
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException { // 第一次访问的时候创建Servlet程序时调用
        System.out.println("初始化方法");
        System.out.println("HelloServlet程序的别名是：" + servletConfig.getServletName());
        // 获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是：" + servletConfig.getInitParameter("url"));
        // 获取ServiceContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 专门用来处理请求和响应的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override // 每次访问的时候都会调用
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet 被访问了");
        // 类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 换取请求的方法
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        if ("GET".equals(method)) {
            doGet();
        } else if ("POST".equals(method)) {
            doPost();
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() { // web工程停止时调用

        System.out.println("销毁方法");

    }



    /**
     * get请求的操作
     */
    public void doGet() {
        System.out.println("get");
    }

    /**
     * post请求的操作
     */
    public void doPost() {
        System.out.println("post");
    }

}