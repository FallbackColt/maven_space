package com.test.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: 18040
 * @date: 2023/2/19 17:56
 */
public class ForwardC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("调用了ForwardC");
        req.getRequestDispatcher("/a/b/c.html").forward(req, resp);

    }
}
