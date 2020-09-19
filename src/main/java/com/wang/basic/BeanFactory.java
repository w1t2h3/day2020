package com.wang.basic;

public class BeanFactory {
    public static UserService getUserService(){
        return new UserServiceImpl();
    }
}
