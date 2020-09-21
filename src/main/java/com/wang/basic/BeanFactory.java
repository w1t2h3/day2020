package com.wang.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {

    //第一种
    /*
    public static UserService getUserService(){
        //硬编码还是会出现高耦合
        //return new UserServiceImpl();

        //使用反射创建对象来解耦
        UserService userService = null;
        try {

            //如果哪天要创建UserServiceImplNew,则需要改动，还是高耦合
            Class clazz = Class.forName("com.wang.basic.UserServiceImpl");
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return userService;
    }

     */

    //第二种

    /*
    //输入流
    private static Properties env = new Properties();

    static {
        try {
            //第一步：获得IO输入流
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");


            //第二步：文件内容封装到Properties集合中 key=userService  value=com.wang.basic.UserServiceImpl
            env.load(inputStream);


            //关闭IO输入流
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public static UserService getUserService(){

        UserService userService = null;
        try {
            Class clazz = Class.forName(env.getProperty("userService"));
            userService = (UserService) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return userService;
    }

    public static UserDao getUserDao() {
        UserDao userDao = null;

        try {
            Class<?> clazz = Class.forName(env.getProperty("userDao"));
            userDao = (UserDao) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return userDao;
    }

     */


    //第三种  通用工厂

    private static Properties env = new Properties();

    static{
        try {
            InputStream inputStream = BeanFactory.class.getResourceAsStream("/applicationContext.properties");
            env.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static Object getBean(String key){
        Object ret = null;

        try {
            Class<?> clazz = Class.forName(env.getProperty(key));
            ret = clazz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return ret;
    }


}
