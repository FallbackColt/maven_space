package com.practice.finance.pojo;

import java.math.BigDecimal;

/**
 * @author: 18040
 * @date: 2023/3/1 12:25
 */
public class ExpenseDetail {

    // 索引
    private int id;

    // 申请类型的ID
    private int applyType;

    // 申请事由
    private int applyReason;

    // 所在部门的ID
    private int department;

    // 报销金额
    private BigDecimal expenseMoney;

    // 报销描述
    private String expenseText;

    // 报销凭证
    private String expenseVoucher;

    public ExpenseDetail() {
    }

    public ExpenseDetail(int id, int applyType, int applyReason, int department, BigDecimal expenseMoney, String expenseText, String expenseVoucher) {
        this.id = id;
        this.applyType = applyType;
        this.applyReason = applyReason;
        this.department = department;
        this.expenseMoney = expenseMoney;
        this.expenseText = expenseText;
        this.expenseVoucher = expenseVoucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApplyType() {
        return applyType;
    }

    public void setApplyType(int applyType) {
        this.applyType = applyType;
    }

    public int getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(int applyReason) {
        this.applyReason = applyReason;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public BigDecimal getExpenseMoney() {
        return expenseMoney;
    }

    public void setExpenseMoney(BigDecimal expenseMoney) {
        this.expenseMoney = expenseMoney;
    }

    public String getExpenseText() {
        return expenseText;
    }

    public void setExpenseText(String expenseText) {
        this.expenseText = expenseText;
    }

    public String getExpenseVoucher() {
        return expenseVoucher;
    }

    public void setExpenseVoucher(String expenseVoucher) {
        this.expenseVoucher = expenseVoucher;
    }

    @Override
    public String toString() {
        return "ExpenseDetail{" +
                "id=" + id +
                ", applyType=" + applyType +
                ", applyReason=" + applyReason +
                ", department=" + department +
                ", expenseMoney=" + expenseMoney +
                ", expenseText='" + expenseText + '\'' +
                ", expenseVoucher='" + expenseVoucher + '\'' +
                '}';
    }
}
