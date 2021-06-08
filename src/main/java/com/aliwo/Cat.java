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
    String address;
    protected String email;
    private static String sex;

    public Cat(){}

    public Cat(String username) {
        this.username = username;
    }
    private Cat(String username, String password) {
         this.username = username;
         this.password = password;
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
