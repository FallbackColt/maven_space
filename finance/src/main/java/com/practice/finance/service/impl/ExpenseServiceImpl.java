package com.practice.finance.service.impl;

import com.practice.finance.dao.ExpenseDao;
import com.practice.finance.dao.impl.ExpenseDaoImpl;
import com.practice.finance.pojo.ExpenseDetail;
import com.practice.finance.pojo.ExpenseSimple;
import com.practice.finance.service.ExpenseService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/2 1:47
 */
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseDao expenseDao = new ExpenseDaoImpl();

    @Override
    public List<ExpenseSimple> queryAllExpenseSimpleNotPaid(String username) {
        return expenseDao.queryAllExpenseSimpleNotPaid(username);
    }


    @Override
    public List<ExpenseSimple> queryAllExpenseSimplePaid(String username) {
        return expenseDao.queryAllExpenseSimplePaid(username);
    }


    @Override
    public ExpenseSimple queryExpenseSimpleById(int ID) {
        return expenseDao.queryExpenseSimpleById(ID);
    }


    @Override
    public ExpenseDetail queryExpenseDetailById(int ID) {
        return expenseDao.queryExpenseDetailById(ID);
    }


    @Override
    public boolean applyExpense(String username, String approveName, String sendDuplicate, int applyTypeInt, int applyReasonInt, int departmentID, BigDecimal expenseMoney, String expenseText, String expenseVoucher, int status) {
        return expenseDao.applyExpense(username, approveName, sendDuplicate, applyTypeInt, applyReasonInt, departmentID, expenseMoney, expenseText, expenseVoucher, status)==2;
    }


    @Override
    public int deleteByID(int ID) {
        return expenseDao.deleteExpenseByID(ID);
    }


    @Override
    public int updateApplyStatusByID(int ID, int Status) {
        return expenseDao.updateExpenseApplyStatus(ID, Status);
    }

    @Override
    public List<ExpenseSimple> queryNeedApproveExpenseSimples(int departmentID, String username) {
        return expenseDao.queryNeedApproveExpenseSimples(departmentID, username);
    }

    @Override
    public int insertExpenseReply(int id, String reply, String username) {
        return expenseDao.insertExpenseReply(id, reply, username);
    }


}
