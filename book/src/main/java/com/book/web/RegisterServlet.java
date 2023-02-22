package com.book.web;

import com.book.pojo.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author: 18040
 * @date: 2023/2/21 13:57
 */
public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//        获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
//        System.out.println(code);
//        检验验证码是否正确(暂时写死验证码)
        if ("abcdef".equalsIgnoreCase(code)) { // 忽略大小写

//            检查用户名是否可用
            if (userService.existsUsername(username)) {
                // 不可用
                System.out.println("用户名 " + username + " 不可用");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
//                保存注册信息
                userService.registerUser(new User(null, username, password, email));
//                跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }

        } else { // 不正确
            System.out.println("验证码 " + code + " 错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
}
