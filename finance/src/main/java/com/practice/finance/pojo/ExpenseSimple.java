package com.practice.finance.pojo;


import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author: 18040
 * @date: 2023/3/1 12:25
 */
public class ExpenseSimple {

    // 索引
    private int id;

    // 申请报销的用户
    private String username;

    // 审批人
    private String approveName;

    // 抄送
    private String sendDuplicate;

    // 申请的状态
    private int applyStatus;

    // 申请的时间
    private LocalDateTime applyTime;

    public ExpenseSimple() {
    }

    public ExpenseSimple(int id, String username, String approveName, String sendDuplicate, int applyStatus, LocalDateTime applyTime) {
        this.id = id;
        this.username = username;
        this.approveName = approveName;
        this.sendDuplicate = sendDuplicate;
        this.applyStatus = applyStatus;
        this.applyTime = applyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApproveName() {
        return approveName;
    }

    public void setApproveName(String approveName) {
        this.approveName = approveName;
    }

    public String getSendDuplicate() {
        return sendDuplicate;
    }

    public void setSendDuplicate(String sendDuplicate) {
        this.sendDuplicate = sendDuplicate;
    }

    public int getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(int applyStatus) {
        this.applyStatus = applyStatus;
    }

    public LocalDateTime getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(LocalDateTime applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    public String toString() {
        return "ExpenseSimple{" +
                "id='" + id + '\'' +
                "username='" + username + '\'' +
                ", approveName='" + approveName + '\'' +
                ", sendDuplicate='" + sendDuplicate + '\'' +
                ", applyStatus=" + applyStatus +
                ", applyTime=" + applyTime +
                '}';
    }



}
