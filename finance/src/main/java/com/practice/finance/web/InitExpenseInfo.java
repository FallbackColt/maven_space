package com.practice.finance.web;

import com.practice.finance.pojo.ExpenseSimple;
import com.practice.finance.service.ExpenseService;
import com.practice.finance.service.impl.ExpenseServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InitExpenseInfo extends HttpServlet {

    private ExpenseService expenseService = new ExpenseServiceImpl();


    /**
     * 查找报销申请表
     * @param req
     */
    public void queryExpenseSimple(HttpServletRequest req){

        HttpSession session = req.getSession();
        List<ExpenseSimple> expenseSimpleSelected = new ArrayList<>();


        if (req.getParameter("select").equals("0")) {
            expenseSimpleSelected = expenseService.queryAllExpenseSimpleNotPaid((String) session.getAttribute("username"));
        } else if (req.getParameter("select").equals("1")) {
            expenseSimpleSelected = expenseService.queryAllExpenseSimplePaid((String) session.getAttribute("username"));
        } else if (req.getParameter("select").equals("7")) {
            expenseSimpleSelected = expenseService.queryNeedApproveExpenseSimples(
                    (int) session.getAttribute("department"),
                    (String) session.getAttribute("username")
            );
        }

        ExpenseSimple[] expenseSimpleSelectedArray = expenseSimpleSelected.toArray(new ExpenseSimple[0]);
        session.setAttribute("expenseSimpleSelectedArray", expenseSimpleSelectedArray);

    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        queryExpenseSimple(req);
        resp.sendRedirect("/finance/pages/user/staff/staffShowSimple.jsp");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


}
