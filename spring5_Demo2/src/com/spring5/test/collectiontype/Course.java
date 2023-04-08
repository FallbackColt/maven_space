package com.spring5.test.collectiontype;

/**
 * @author: 18040
 * @date: 2023/4/7 21:14
 */
public class Course {

    // 课程名称
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
