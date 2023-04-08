package com.practice.finance.web;

import com.practice.finance.pojo.User;
import com.practice.finance.service.UserService;
import com.practice.finance.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;


public class Login extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        ServletContext context = getServletConfig().getServletContext();


        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);
        HttpSession session = request.getSession();

        if (user==null) {
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
            response.sendRedirect("/finance");
        } else {
            session.setAttribute("username", user.getUsername());
            session.setAttribute("name", user.getName());
            session.setAttribute("department", user.getDepartment());
            session.setAttribute("superior", user.getSuperior());
            session.setAttribute("account", user.getAccount());

            response.sendRedirect("/finance/pages/user/staff.jsp");

        }

    }



}
