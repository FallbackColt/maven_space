package com.test.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class HelloServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Servlet3, get");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Hello Servlet3, post");

    }
}
