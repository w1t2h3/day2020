package com.wang.basic;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
//        UserService userService = BeanFactory.getUserService();

        
        //使用通用工厂方法来解耦合
        UserService userService = (UserService) BeanFactory.getBean("userService");
        userService.login("name","456789");

        User user = new User("wang", "123456");
        userService.register(user);
    }

    @Test
    public void test2(){
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println("person = " + person);
    }

    @Test
    public void test3(){

        /*Spring提供 ApplicationContext这个工厂接口 ，用于对象的创建
            作用：解耦合
           非web环境实现类：ClassPathXmlApplicationContext  (main方法入口 ，junit方法测试 )
           web环境实现类; XmlWebApplicationContext
        */

//        获得Spring的工厂，找到配置文件的位置
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");

//        通过工厂类  获得 对象
//        Person person = (Person) ctx.getBean("person");
//        Person person = ctx.getBean("person", Person.class);
//        这种方便需要注意  配置文件中只有一种Person类型的Bean
        Person person = ctx.getBean(Person.class);
        System.out.println("person = " + person);
    }



}
