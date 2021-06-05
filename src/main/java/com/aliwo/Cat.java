package com.aliwo;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 */
public class Cat {
    private String name = "你是什么猫啊！";
    public Integer age = 100;
    public String username = "xuyy";
    public String password = "12344";

    public Cat(){}

    public Cat(String name) {
        name = this.name;
    }

    public void hi() {
        System.out.println("hi" + name);
    }

    public void hi2() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
