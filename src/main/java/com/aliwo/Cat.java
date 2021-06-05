package com.aliwo;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 */
public class Cat {
    private String name = "你是什么猫啊！";
    public Integer age = 100;

    public Cat(){}

    public Cat(String name) {
        name = this.name;
    }

    public void hi() {
        System.out.println("hi" + name);
    }
}
