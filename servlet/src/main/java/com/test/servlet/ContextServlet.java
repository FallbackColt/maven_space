package com.test.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class ContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 获取web.xml中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println(username);
        String password = context.getInitParameter("password");
        System.out.println(password);

        // 获取当前的工程路径
        System.out.println("当前工程路径：" + context.getContextPath());
        // 获取工程部署后在服务器硬盘上的绝对路径
        // /被服务器解析地址为：http://ip:port/工程名/
        System.out.println("工程部署的路径是：" + context.getRealPath("/"));

        context.setAttribute("key1", "value1");

        System.out.println(context.getAttribute("key1"));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
