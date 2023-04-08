package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/3/1 12:32
 */
public class IdToApplyType {

    // id
    private int id;

    // 申请类型
    private String applyTypeName;

    public IdToApplyType() {
    }

    public IdToApplyType(int id, String applyTypeName) {
        this.id = id;
        this.applyTypeName = applyTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplyTypeName() {
        return applyTypeName;
    }

    public void setApplyTypeName(String applyTypeName) {
        this.applyTypeName = applyTypeName;
    }

    @Override
    public String toString() {
        return "IdToApplyType{" +
                "id=" + id +
                ", applyTypeName='" + applyTypeName + '\'' +
                '}';
    }
}
