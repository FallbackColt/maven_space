package com.test.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        String username = req.getParameter("username");
        System.out.println("Servlet1中查看username：" + username);

//        设置属性，做标记？？？
        req.setAttribute("key1", "Servlet1");

//        请求转发到其他的路径
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
//        将参数传到对应的路径
        requestDispatcher.forward(req, resp);


    }
}
