package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/3/1 12:32
 */
public class IdToApplyStatus {

    // id
    private int id;

    // 申请状态
    private String applyStatus;

    public IdToApplyStatus() {
    }

    public IdToApplyStatus(int id, String applyStatus) {
        this.id = id;
        this.applyStatus = applyStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "IdToApplyStatus{" +
                "id=" + id +
                ", applyStatus='" + applyStatus + '\'' +
                '}';
    }
}
