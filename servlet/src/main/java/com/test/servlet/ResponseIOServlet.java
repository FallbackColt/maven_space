package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: 18040
 * @date: 2023/2/19 21:57
 */
public class ResponseIOServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

/*
//        设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");
//        通过响应头，设置浏览器字符集也使用UTF-8
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
*/
//        同时将服务器和客户端设置为UTF-8字符集
//        必须在获取流之前调用
        resp.setContentType("text/html; charset=UTF-8");


        /*
         * 以下两个响应流不能同时使用
         * getOutputStream()一般用于下载(传递二进制数据)
         * getWriter()一般用于回传字符串(常用)
         */
//        resp.getOutputStream();
        PrintWriter writer = resp.getWriter();
        writer.write("response's content!!!");
        writer.write("痕心雨迹！！！");
    }
}
