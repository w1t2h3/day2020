package com.wang.basic;

public class User {
    private String name;
    private String password;

    public User(String name,String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{name = " + name + ",password = " + password + "}";
    }
}
