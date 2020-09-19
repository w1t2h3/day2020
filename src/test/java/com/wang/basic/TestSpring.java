package com.wang.basic;


import org.junit.Test;


public class TestSpring {

    /**
     * 用于测试:工厂类进行解耦合的作用
     * 面向对象设计的开闭原则：打开扩展，关闭修改
     */
    @Test
    public void test1(){

        //创建对象的代码硬编码在这里，高耦合
        //UserService userService = new UserServiceImpl();
        //使用工厂方法来创建对象，解耦合
        UserService userService = BeanFactory.getUserService();

        userService.login("name","456789");

        User user = new User("wang", "123456");
        userService.register(user);
    }

}
