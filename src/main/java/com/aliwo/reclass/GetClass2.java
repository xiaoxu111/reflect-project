package com.aliwo.reclass;

import java.io.Serializable;

/**
 * @author xuyayuan
 * @data 2021年06月06日
 * **哪些类型有Class对象**
 * 一：外部类，成员内部类，静态内部类，局部内部类，匿名内部类
 * 二：Interface接口
 * 三：数组
 * 四：enum枚举
 * 五：annotation注解
 * 六：基本数据类型
 * 其：void
 */
public class GetClass2 {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;// 外部类
        Class<Serializable> cls2 = Serializable.class; //接口
        Class<Integer[]> cls3 = Integer[].class;//数组
        Class<float[][]> cls4 = float[][].class; //二维数组
        Class<Deprecated> cls5 = Deprecated.class; //注解
        Class<Thread.State> cls6 = Thread.State.class;
        Class<Long> cls7 = long.class; //基本数据类型
        Class<Void> cls8 = void.class; //void数据类型
        Class<Class> cls9 = Class.class; //外部类
        System.out.println("cls1 : " + cls1);
        System.out.println("cls2 : " + cls2);
        System.out.println("cls3 : " + cls3);
        System.out.println("cls4 : " + cls4);
        System.out.println("cls5 : " + cls5);
        System.out.println("cls6 : " + cls6);
        System.out.println("cls7 : " + cls7);
        System.out.println("cls8 : " + cls8);
        System.out.println("cls9 : " + cls9);

    }
}
