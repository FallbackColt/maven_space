package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String username = req.getParameter("username");
        System.out.println("Servlet2中查看username：" + username);

//        查看Servlet1的标记
        Object key = req.getAttribute("key1");
        System.out.println("key的值：" + key);

        System.out.println("Servlet2处理业务...");


    }

}
