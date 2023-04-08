package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/3/1 12:32
 */
public class IdToApplyReason {

    // id
    private int id;

    // 申请事由
    private String applyReasonName;

    public IdToApplyReason() {
    }

    public IdToApplyReason(int id, String applyReasonName) {
        this.id = id;
        this.applyReasonName = applyReasonName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyReasonName() {
        return applyReasonName;
    }

    public void setApplyReasonName(String applyReasonName) {
        this.applyReasonName = applyReasonName;
    }

    @Override
    public String toString() {
        return "IdToApplyReason{" +
                "id=" + id +
                ", applyReasonName='" + applyReasonName + '\'' +
                '}';
    }
}
