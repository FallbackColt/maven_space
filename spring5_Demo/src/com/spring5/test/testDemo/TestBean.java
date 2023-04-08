package com.spring5.test.testDemo;

import com.spring5.test.bean.Emp;
import com.spring5.test.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: 18040
 * @date: 2023/4/6 21:50
 */
public class TestBean {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");

        UserService userService = context.getBean("userService", UserService.class);

        userService.add();
    }

    @Test
    public void testEmp() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");

        Emp emp = context.getBean("emp", Emp.class);

        System.out.println(emp);
    }

    @Test
    public void testEmp2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean4.xml");

        Emp emp1 = context.getBean("emp1", Emp.class);
        Emp emp2 = context.getBean("emp2", Emp.class);

        System.out.println(emp1);
        System.out.println(emp2);
    }

}
