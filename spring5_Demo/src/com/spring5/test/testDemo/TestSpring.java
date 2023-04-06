package com.spring5.test.testDemo;

import com.spring5.test.Book;
import com.spring5.test.Orders;
import com.spring5.test.User;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18040
 * @date: 2023/4/3 1:59
 */
public class TestSpring {

    @Test
    public void testAdd() {
        // 1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置文件创建的对象
        User user = context.getBean("user", User.class);


        System.out.println(user);
        user.add();
    }


    @Test
    public void testBookSet() {
        // 1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置文件创建的对象
        Book book = context.getBean("book", Book.class);
        Book book2 = context.getBean("book2", Book.class);

        System.out.println(book);
        System.out.println(book2);
    }

    @Test
    public void testOrderConstructor() {
        // 1. 加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        // 2. 获取配置文件创建的对象
        Orders order = context.getBean("orders", Orders.class);

        System.out.println(order);
    }

}
