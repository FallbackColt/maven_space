package com.spring5.test.testdemo;

import com.spring5.test.autowire.Emp;
import com.spring5.test.bean.Orders;
import com.spring5.test.collectiontype.Book;
import com.spring5.test.collectiontype.Course;
import com.spring5.test.collectiontype.Stu;
import com.spring5.test.factorybean.MyBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18040
 * @date: 2023/4/7 21:04
 */
public class TestDemo {

    @Test
    public void testCollection() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        Stu stu = context.getBean("stu", Stu.class);
        System.out.println(stu);

    }

    @Test
    public void testBook() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testMyBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
        Course course = context.getBean("myBean", Course.class);
        System.out.println(course);
    }

    @Test
    public void testOrders() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("4.获取创建的bean实例对象");
        System.out.println(orders);

        // 手动执行bean实例的销毁
        // ClassPathXmlApplicationContext才有close，ApplicationContext没有close
        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void testDept() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean5.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
}
