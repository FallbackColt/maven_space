package com.practice.finance.service;

import com.practice.finance.pojo.ExpenseDetail;
import com.practice.finance.pojo.ExpenseSimple;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: 18040
 * @date: 2023/3/2 1:47
 */
public interface ExpenseService {

    /**
     * 查询当前用户未打款的报销申请
     * @param username 用户名
     * @return
     */
    public List<ExpenseSimple> queryAllExpenseSimpleNotPaid(String username);


    /**
     * 查询当前用户已打款的报销申请
     * @param username 用户名
     * @return
     */
    public List<ExpenseSimple> queryAllExpenseSimplePaid(String username);


    /**
     * 根据ID查询简略表
     * @param ID ID索引
     * @return
     */
    public ExpenseSimple queryExpenseSimpleById(int ID);


    /**
     * 根据ID查询详情表
     * @param ID ID索引
     * @return
     */
    public ExpenseDetail queryExpenseDetailById(int ID);


    /**
     * 提交报销申请
     * @param username 用户名
     * @param approveName 审批人姓名
     * @param sendDuplicate 抄送
     * @param applyTypeInt 申请的类型
     * @param applyReasonInt 申请事由
     * @param departmentID 部门ID
     * @param expenseMoney 申请报销的金额
     * @param expenseText 报销描述
     * @param expenseVoucher 报销凭证
     * @param status 状态
     * @return
     */
    public boolean applyExpense(String username, String approveName, String sendDuplicate,
                                int applyTypeInt, int applyReasonInt, int departmentID,
                                BigDecimal expenseMoney, String expenseText, String expenseVoucher, int status);


    /**
     * 通过ID删除申请报销的信息
     * @param ID ID索引
     * @return
     */
    public int deleteByID(int ID);



    /**
     * 通过ID更新申请状态
     * @param ID ID索引
     * @param Status 申请状态的id
     * @return
     */
    public int updateApplyStatusByID(int ID, int Status);


    /**
     * 查询需要当前用户审批的报销简略表
     * @param departmentID 当前用户的部门ID
     * @param username 当前用户的用户名
     * @return
     */
    public List<ExpenseSimple> queryNeedApproveExpenseSimples(int departmentID, String username);


    /**
     * 更改报销申请状态
     * @param id 索引
     * @param reply 回复的理由
     * @param username 操作用户的用户名
     * @return
     */
    public int insertExpenseReply(int id, String reply, String username);


}
