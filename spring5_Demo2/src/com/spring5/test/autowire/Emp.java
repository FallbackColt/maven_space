package com.spring5.test.autowire;

/**
 * @author: 18040
 * @date: 2023/4/8 14:48
 */
public class Emp {

    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
