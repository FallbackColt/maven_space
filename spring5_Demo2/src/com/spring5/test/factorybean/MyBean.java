package com.spring5.test.factorybean;

import com.spring5.test.collectiontype.Course;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author: 18040
 * @date: 2023/4/7 22:47
 */
public class MyBean implements FactoryBean<Course> {

    // 定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("test");
        return course;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
