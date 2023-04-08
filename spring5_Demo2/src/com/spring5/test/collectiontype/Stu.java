package com.spring5.test.collectiontype;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: 18040
 * @date: 2023/4/7 20:30
 */
public class Stu {
    
    // 数组类型属性
    private String[] courses;

    // list集合类型属性
    private List<String> list;

    // map集合类型属性
    private Map<String, String> maps;

    // set集合类型属性
    private Set<String> sets;

    // 学生所学的多门课程
    private List<Course> courseList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", maps=" + maps +
                ", sets=" + sets +
                ", courseList=" + courseList +
                '}';
    }
}
