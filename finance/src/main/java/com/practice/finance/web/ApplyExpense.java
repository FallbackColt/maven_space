package com.practice.finance.web;

import com.practice.finance.dao.ExpenseDao;
import com.practice.finance.pojo.ExpenseDetail;
import com.practice.finance.pojo.ExpenseSimple;
import com.practice.finance.service.ExpenseService;
import com.practice.finance.service.impl.ExpenseServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

public class ApplyExpense extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();




        if (session.getAttribute("information").equals("7")) {

            int id = ((ExpenseSimple) session.getAttribute("expenseSimple")).getId();
            String username = ((ExpenseSimple) session.getAttribute("expenseSimple")).getUsername();
            int Status = ((ExpenseSimple) session.getAttribute("expenseSimple")).getApplyStatus();
            BigDecimal bigDecimal = ((ExpenseDetail) session.getAttribute("expenseDetail")).getExpenseMoney();

            if(request.getParameter("agreement").equals("agree")) {
                if (Status==5) {
                    expenseService.updateApplyStatusByID(id, Status+1);
                } else {
                    if ((bigDecimal.compareTo(new BigDecimal(5000)))<=0) {
                        Status = 5;
                    } else {
                        Status += 1;
                    }
                    expenseService.updateApplyStatusByID(id, Status);
                }

            } else if (request.getParameter("agreement").equals("notAgree")) {
                expenseService.updateApplyStatusByID(Integer.parseInt(request.getParameter("id")), 8);
            }
            expenseService.insertExpenseReply(id, request.getParameter("text"), username);
            response.sendRedirect("/finance/initExpenseInfo?select=7");
            return;
        }

        String expenseMoney = request.getParameter("expenseMoney");
        System.out.println("expenseMoney:" + expenseMoney);
        BigDecimal bigDecimal;
        // 判断金钱是否为空
        if ("".equals(expenseMoney)) {
            bigDecimal = new BigDecimal("-1");
        } else {
            bigDecimal = new BigDecimal(expenseMoney);
        }

        // 获取对应的参数值
        int applyType = Integer.parseInt(request.getParameter("applyType"));
        int applyReason = Integer.parseInt(request.getParameter("applyReason"));
        int department = Integer.parseInt(request.getParameter("department"));
        String approveName = request.getParameter("approveName");
        String sendDuplicate = request.getParameter("sendDuplicate");

        String describe = request.getParameter("describe");
        String expenseVoucher = request.getParameter("expenseVoucher");

        expenseService.applyExpense(
                (String) session.getAttribute("username"),
                approveName,
                sendDuplicate,
                applyType,
                applyReason,
                department,
                bigDecimal,
                describe,
                expenseVoucher,
                //保存草稿则为设为1，否则设为2
                "保存草稿".equals(request.getParameter("save")) ? 1:2
        );

        response.sendRedirect("/finance/initExpenseInfo?select=0");

    }
}
