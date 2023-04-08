package com.practice.finance.web;

import com.practice.finance.pojo.*;
import com.practice.finance.service.ExpenseService;
import com.practice.finance.service.impl.ExpenseServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

public class GetExpenseInfo extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        ServletContext context = getServletContext();
        HttpSession session = request.getSession();

        int expenseStatus = Integer.parseInt(request.getParameter("expenseStatus"));
        int id = Integer.parseInt(request.getParameter("id"));
        switch (expenseStatus) {
            case 0:
                // 删除id对应的报销申请表
                expenseService.deleteByID(id);
                new InitExpenseInfo().queryExpenseSimple(request);
                response.sendRedirect("/finance/pages/user/staff/staffShowSimple.jsp");
                break;
            case 1:
            case 2:
            case 4: // 1、2、4 根据id查询报销详情表
                session.setAttribute("checkExpenseStatus", expenseStatus);
                session.setAttribute("id", id);
                // 根据id查询详情表
                session.setAttribute("expenseDetail", expenseService.queryExpenseDetailById(id));

                // 根据id查询简略表
                session.setAttribute("expenseSimple", expenseService.queryExpenseSimpleById(id));
                response.sendRedirect("/finance/pages/user/staff/staffShowDetail.jsp");
                break;
            case 3:
                // 将已打款状态更改为确认收款
                expenseService.updateApplyStatusByID(id, 7);
                new InitExpenseInfo().queryExpenseSimple(request);
                response.sendRedirect("/finance/pages/user/staff/staffShowSimple.jsp");
                break;
        }



    }


}
