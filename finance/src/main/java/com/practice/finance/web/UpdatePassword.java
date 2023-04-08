package com.practice.finance.web;

import com.practice.finance.service.UserService;
import com.practice.finance.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class UpdatePassword extends HttpServlet {


    private UserService userService= new UserServiceImpl();

    @Override
    public void init() throws ServletException {
//        super.init();
        // TODO

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");

        if (userService.login(username, password)!=null) {
            userService.updateUser(username, password, newPassword);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
