package com.practice.finance.web;

import com.practice.finance.pojo.*;
import com.practice.finance.service.IdToNameService;
import com.practice.finance.service.UserService;
import com.practice.finance.service.impl.IdToNameServiceImpl;
import com.practice.finance.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/12 13:34
 */
public class SetSessionInformation extends HttpServlet {

    private IdToNameService idToNameService = new IdToNameServiceImpl();
    private UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        session.setAttribute("select", req.getParameter("select"));


        if (req.getParameter("select").equals("0")) {
            // 已发起
            session.setAttribute("information", "0");
            req.getRequestDispatcher("/initExpenseInfo").forward(req, resp);
            return;
        } else if (req.getParameter("select").equals("1")) {
            // 报销确认
            session.setAttribute("information", "1");
            req.getRequestDispatcher("/initExpenseInfo").forward(req, resp);
            return;
        } else if (req.getParameter("select").equals("2")) {
            // 人员管理
            session.setAttribute("information", "2");
            session.setAttribute("users", userService.queryAllUser().toArray(new User[0]));
            resp.sendRedirect("/finance/pages/user/notstaff/userInfo.jsp");
            return;
        } else if (req.getParameter("select").equals("7")) {
            // 审批管理
            session.setAttribute("information", "7");
            req.getRequestDispatcher("/initExpenseInfo").forward(req, resp);
            return;
        } else if (req.getParameter("select").equals("3")) {
            // 部门管理
            session.setAttribute("information", "3");
            session.setAttribute("updateName", "部门");
            session.setAttribute("departments", idToNameService.queryAllDepartment("id").toArray(new IdToDepartment[0]));
        } else if (req.getParameter("select").equals("4")) {
            // 申请类型管理
            session.setAttribute("information", "4");
            session.setAttribute("updateName", "申请类型");
            session.setAttribute("applyTypes", idToNameService.queryAllType("id").toArray(new IdToApplyType[0]));
        } else if (req.getParameter("select").equals("5")) {
            // 申请事由管理
            session.setAttribute("information", "5");
            session.setAttribute("updateName", "申请事由");
            session.setAttribute("applyReasons", idToNameService.queryAllReason("id").toArray(new IdToApplyReason[0]));
        } else if (req.getParameter("select").equals("6")) {
            // 申请内容管理
            session.setAttribute("information", "6");
            session.setAttribute("updateName", "申请状态");
            session.setAttribute("applyStatuses", idToNameService.queryAllStatus("id").toArray(new IdToApplyStatus[0]));
        }
        resp.sendRedirect("/finance/pages/user/notstaff/updateInfo.jsp");
//        req.getRequestDispatcher("/pages/user/notstaff/updateInfo.jsp").forward(req, resp);

    }

    
}
