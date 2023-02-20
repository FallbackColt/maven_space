package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;


/**
 * @author: 18040
 * @date: 2023/2/19 16:31
 */
public class ParameterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("---------------Get-----------------");
//        获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名：" + username + "\n密码：" + password + "\n兴趣爱好：" + Arrays.asList(hobby));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
          /*
            设置请求体的字符集为UTF-8，用来解决post请求中的中文乱码问题
            在获取请求参数之前调用才有效
           */
        req.setCharacterEncoding("UTF-8");
        System.out.println("---------------Post-----------------");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名：" + username + "\n密码：" + password + "\n兴趣爱好：" + Arrays.asList(hobby));


    }
}
