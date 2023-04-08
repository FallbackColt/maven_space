package com.spring5.test.bean;

/**
 * @author: 18040
 * @date: 2023/4/8 13:45
 */
public class Orders {

    public Orders() {
        System.out.println("1.执行了无参数构造创建bean实例");
    }

    private String oname;

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("2.调用set方法设置属性的值");
    }

    // 创建执行初始化的方法
    public void initMethod() {
        System.out.println("3.执行初始化方法");
    }

    // 创建执行销毁的方法
    public void destroyMethod() {
        System.out.println("5.执行销毁的方法");
    }

}
