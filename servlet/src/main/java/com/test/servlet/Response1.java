package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: 18040
 * @date: 2023/2/19 22:19
 */
public class Response1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("Response1 重定向...");

/*
//        设置响应状态码302，表示重定向
        resp.setStatus(302);
//        设置响应头，说明新的地址
        resp.setHeader("Location", "http://localhost:8000/servlet/response2");
*/

        resp.sendRedirect("http://localhost:8000/servlet/response2");


    }
}
