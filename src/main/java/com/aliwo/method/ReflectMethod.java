package com.aliwo.method;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author xuyayuan
 * @data 2021年06月10日
 * 反射爆破操作方法
 * 访问方法
 * 一：根据方法名和参数列表获取Method方法对象，Method m = clazz.getDeclaredMethod(方法名, xx.class);得到本类的所有方法
 * 二：获取对象：Object o = clazz.newInstance();
 * 三：爆破、m.setAccessible(true);
 * 四：访问、Object returnValue = m.invoke(o, 实参列表); // o就是对象
 * 五：注意、如果是静态方法，则invoke的参数o，可以写成null
 */
public class ReflectMethod {

    @Test
    public void test01() throws Exception {
        // 获取类对象
        Class cls = Class.forName("com.aliwo.Cat");
        // 获取类对象的实例对象
        Object o = cls.newInstance();
        // 获取类对象的所有方法，包括public/private/等访问权限的方法
        Method publicMethod = cls.getDeclaredMethod("hi");
        Object returnValue = publicMethod.invoke(o);
        // 获取类对象中的普通方法
        Method privateMethod = cls.getDeclaredMethod("hi2", String.class);
        // 方法爆破
        privateMethod.setAccessible(true);
        Object returnPrivateValue = privateMethod.invoke(o, "privateMethod 设置值");
        // hi2()方法的返回值
        System.out.println("returnPrivateValue : " + returnPrivateValue);
        // 获取类对象中的静态方法
        Method privateStaticMethod = cls.getDeclaredMethod("hi3", String.class, String.class);
        privateStaticMethod.setAccessible(true);
        // 静态方法可以使用null
        Object returnPrivateStaticValue = privateStaticMethod.invoke(null, "privateStaticMethod 设置值username",
                "privateStaticMethod 设置值password");
    }
}
