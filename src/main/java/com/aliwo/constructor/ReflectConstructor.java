package com.aliwo.constructor;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author xuyayuan
 * @data 2021年06月08日
 * 通过反射创建对象
 * 一：方式一、调用类中的public修饰的无参构造器
 * 二：方式二、调用类中指定的构造器
 * 三：Class类相关的方法
 * newInstance、调用类中无参构造器，获取对应类的对象
 * getConstructor(Class ...classzz)根据参数列表，获取对应public构造器对象
 * getDeclaredConstructor(Class....classzz)根据参数列表，获取对应的所有构造器对象
 * 四：Constructor类相关的方法
 * setAccsssible 爆破
 * newInstance(Object ...obj)调用构造器
 */
public class ReflectConstructor {
    @Test
    public void testConstructor() throws Exception{
        //  获取Class类对象
        Class constructorCls = Class.forName("com.aliwo.Cat");
        // 方式一、调用类中的public修饰的无参构造器创建对象
        Object obj = constructorCls.newInstance();
        System.out.println("调用类中的public修饰的无参构造器创建对象 : " + obj);
        // 方式二：调用类中指定的构造器 public修饰的有参构造器
        // constructorCls.getConstructor(String.class); 相当于调用的是
        //  public Cat(String username) {
        //        this.username = username;
        //    }
        // 的构造方法
        Constructor constructor = constructorCls.getConstructor(String.class);
        Object o = constructor.newInstance("有参public构造器");
        System.out.println("调用类中指定的构造器 public修饰的有参构造器 : " + o);

        // 方式三：调用类中指定的构造器 非public修饰的有参构造器
        // Constructor constructor1 = constructorCls.getDeclaredConstructor(String.class, String.class); 相当于调用的是
        // private Cat(String username, String password) {
        //         this.username = username;
        //         this.password = password;
        //    }
        // 的构造方法
        Constructor constructor1 = constructorCls.getDeclaredConstructor(String.class, String.class);
        constructor1.setAccessible(true); // 爆力破解，使用反射可以访问private的构造器/方法/属性
        Object obj1 = constructor1.newInstance("非public修饰的有参构造器", "非public修饰的有参构造器");
        System.out.println("非public修饰的有参构造器 ：" + obj1);
    }

}
