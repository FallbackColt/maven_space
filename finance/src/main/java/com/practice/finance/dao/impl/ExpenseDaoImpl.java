package com.practice.finance.dao.impl;

import com.practice.finance.dao.ExpenseDao;
import com.practice.finance.pojo.ExpenseDetail;
import com.practice.finance.pojo.ExpenseSimple;
import com.practice.finance.pojo.IdToApplyStatus;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/1 22:27
 */
public class ExpenseDaoImpl extends BaseDao implements ExpenseDao {


    @Override
    public List<ExpenseSimple> queryAllExpenseSimpleNotPaid(String username) {
        String sql = "select `id`, `approveName`, `sendDuplicate`, `applyStatus`, `applyTime`" +
                " from expenseSimple where `username`=? and `applyStatus`<=5 order by `applyStatus`";
        return queryForList(ExpenseSimple.class, sql, username);
    }

    @Override
    public List<ExpenseSimple> queryAllExpenseSimplePaid(String username) {
        String sql = "select `id`, `approveName`, `sendDuplicate`, `applyStatus`, `applyTime`" +
                " from expenseSimple where `username`=? and `applyStatus`>5 order by FIELD(`applyStatus`, 8, 6, 7)";
        return queryForList(ExpenseSimple.class, sql, username);
    }


    @Override
    public ExpenseSimple queryExpenseSimpleById(int ID) {
        String sql = " select * from expenseSimple where `id`=?";
        return queryForOne(ExpenseSimple.class, sql, ID);
    }


    @Override
    public ExpenseDetail queryExpenseDetailById(int ID) {
        String sql = " select * from expenseDetail where `id`=?";
        return queryForOne(ExpenseDetail.class, sql, ID);
    }


    @Override
    public int applyExpense(
            String username, String approveName, String sendDuplicate, int applyTypeInt, int applyReasonInt,
            int departmentID, BigDecimal expenseMoney, String expenseText, String expenseVoucher, int status) {
        String sql1 = "INSERT INTO expenseSimple VALUE(?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO expenseDetail VALUE(?, ?, ?, ?, ?, ?, ?)";
        String sql3 = "select `id` from expenseSimple where `applyTime`=? and `username`=?";
        String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date().getTime());


        return update(
                sql1,
                null,
                username,
                approveName,
                sendDuplicate,
                status,
                date
        ) + update(
                sql2,
                // 根据时间和用户名确定当前数据在Simple表中的id
                queryForOne(ExpenseSimple.class, sql3, date, username).getId(),
                applyTypeInt,
                applyReasonInt,
                departmentID,
                expenseMoney,
                expenseText,
                // 处理报销凭证的图片名称为"时间_用户名_图片扩展名"
                expenseVoucher.equals("") ? "": date + "_" + username + "_" + expenseVoucher.substring(expenseVoucher.length()-4)
        );
    }

    @Override
    public int deleteExpenseByID(int id) {
        String sql1 = "delete from expenseSimple where `id`=?";
        String sql2 = "delete from expenseDetail where `id`=?";

        return update(sql1, id) + update(sql2, id);

    }

    @Override
    public int updateExpenseApplyStatus(int id, int Status) {
        String sql1 = "update expenseSimple set `applyStatus`=? where `id`=?";
        return update(sql1, Status, id);
    }

    @Override
    public List<ExpenseSimple> queryNeedApproveExpenseSimples(int departmentID, String username) {
//        String sql = "select `id`, `approveName`, `sendDuplicate`, `applyStatus`, `applyTime`" +
//                " from expenseSimple where `applyStatus`=? and `approveName`=?";
        String sql = "select `id`, `approveName`, `sendDuplicate`, `applyStatus`, `applyTime`" +
                " from expenseSimple where `applyStatus`=?";
        // 将departmentID与StatusID对应起来
//        return queryForList(ExpenseSimple.class, sql, (2-(departmentID-3)), username);
        return queryForList(ExpenseSimple.class, sql, (2-(departmentID-3)));
    }

    @Override
    public int insertExpenseReply(int id, String reply, String username) {
        String sql = "insert into expenseReply value(?, ?, ?)";
        return update(sql, id, reply, username);
    }

}
