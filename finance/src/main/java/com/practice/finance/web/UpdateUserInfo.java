package com.practice.finance.web;

import com.practice.finance.pojo.User;
import com.practice.finance.service.UserService;
import com.practice.finance.service.impl.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class UpdateUserInfo extends HttpServlet {

    private UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        int department = Integer.parseInt(request.getParameter("department"));
        String superior = request.getParameter("superior");
        String account = request.getParameter("account");

        // 0-添加
        if (request.getParameter("option").equals("0")) {
            if (userService.existsUsername(username)) {
//                request.getRequestDispatcher("/pages/user/notstaff/userInfo.jsp").forward(request,response);
                response.sendRedirect("/finance/pages/user/notstaff/userInfo.jsp");
                return;
            }
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "text/html; charset=UTF-8");
            userService.registerUser(
                    new User(username, "88888888", name, department, superior, account)
            );
            session.setAttribute("users", userService.queryAllUser().toArray(new User[0]));
        } else if (request.getParameter("option").equals("1")) { // 1-修改
            userService.updateUserInfo(id, username, name, department, superior, account);
            session.setAttribute("users", userService.queryAllUser().toArray(new User[0]));
        } else if (request.getParameter("option").equals("2")) { // 2-查询
            session.setAttribute("users", userService.queryUsersByUsername(username).toArray(new User[0]));
        } else if (request.getParameter("option").equals("3")) { // 3-取消查询
            session.setAttribute("users", userService.queryAllUser().toArray(new User[0]));
        } else if (request.getParameter("option").equals("4")) { // 4-删除
            userService.deleteUser(id, username);
            session.setAttribute("users", userService.queryAllUser().toArray(new User[0]));
        }
        request.getRequestDispatcher("/pages/user/notstaff/userInfo.jsp").forward(request,response);
    }
}
