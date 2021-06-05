package com.aliwo.reflect;

import com.aliwo.Cat;

import java.lang.reflect.Method;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 * 反射的优点和缺点
 * 优点：可以动态的创建和使用对象(也是框架底层核心)，使用灵活，没有反射机制，框架技术就失去底层支撑。
 * 缺点：使用反射基本是解释执行，对执行速度有影响
 */
public class ReflectionQuestion3 {
    public static void main(String[] args) throws Exception {
        m1();
        m2();
        m3();
    }

    /**
     * 传统方式调用方法
     * @author xuyy
     * @date 2021/6/5 17:55
     */
    public static void m1() {
        Cat cat = new Cat();
        Long starttime = System.currentTimeMillis();
        for (int i = 0; i <100000000; i++ ) {
            cat.hi2();
        }
        Long endtime = System.currentTimeMillis();
        System.out.println("传统方式耗时:" + (endtime-starttime));
    }

    /**
     * 通过反射调用方法
     * @author xuyy
     * @date 2021/6/5 17:55
     */
    public static void m2() throws Exception {
        // 第一步获取Class对象
        Class cls = Class.forName("com.aliwo.Cat");
        // 得到 com.aliwo.Cat的对象实例
        Object o = cls.newInstance();
        // 获取对象中的方法
        Method method = cls.getMethod("hi2");
        Long starttime = System.currentTimeMillis();
        for (int i = 0; i <100000000; i++ ) {
            // 使用反射调用，传统是 对象.方法名 反射机制是 方法对象.对象
            method.invoke(o);
        }
        Long endtime = System.currentTimeMillis();
        System.out.println("使用反射耗时:" + (endtime-starttime));
    }

    /**
     * 通过反射调用方法的优化
     * 反射调用优化-关闭访问检查
     * 一;Method和Field，Constructor对象都有setAccessible()方法
     * 二：setAccessible作用是启动和禁用访问安全检查的开关
     * 三：参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率，参数值为false则表示反射的对象执行访问检查。
     * @author xuyy
     * @date 2021/6/5 17:55
     */
    public static void m3() throws Exception {
        // 第一步获取Class对象
        Class cls = Class.forName("com.aliwo.Cat");
        // 得到 com.aliwo.Cat的对象实例
        Object o = cls.newInstance();
        // 获取对象中的方法
        Method method = cls.getMethod("hi2");
        // 参数值为true表示反射的对象在使用时取消访问检查，提高反射的效率，参数值为false则表示反射的对象执行访问检查。
        method.setAccessible(true);
        Long starttime = System.currentTimeMillis();
        for (int i = 0; i <100000000; i++ ) {
            // 使用反射调用，传统是 对象.方法名 反射机制是 方法对象.对象
            method.invoke(o);
        }
        Long endtime = System.currentTimeMillis();
        System.out.println("使用反射耗时:" + (endtime-starttime));
    }
}
