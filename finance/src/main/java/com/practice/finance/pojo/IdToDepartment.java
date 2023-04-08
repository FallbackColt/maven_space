package com.practice.finance.pojo;

/**
 * @author: 18040
 * @date: 2023/3/1 12:32
 */
public class IdToDepartment {

    // id
    private int id;
    // 部门
    private String departmentName;

    public IdToDepartment() {
    }

    public IdToDepartment(int id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public String toString() {
        return "IdToDepartment{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
