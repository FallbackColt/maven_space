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
public class Response2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        resp.getWriter().write("定位到Response2");


    }
}
