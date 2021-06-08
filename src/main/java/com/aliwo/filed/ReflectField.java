package com.aliwo.filed;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author xuyayuan
 * @data 2021年06月08日
 * 一：根据属性名获取Field对象
 * Field f = clazz对象.getDeclaredField(属性名);
 * 二：爆破：f.setAccessible(true) //f是Field
 * 三：访问
 * f.set(o,值);
 * 四：如果是静态属性，则set和get中的参数o，可以写成null
 */
public class ReflectField {
    @Test
    public void test01() throws Exception {
        // 获取Class对象
        Class cls = Class.forName("com.aliwo.Cat");
        // 通过反射调用无参构造方法获取对象
        Object obj = cls.newInstance();
        System.out.println("通过反射获取无参构造方法对象 : " + obj); //Cat{name='你是什么猫啊！', age=100, username='xuyy', password='12344'}
        // 通过反射获取public属性age对象   public java.lang.Integer com.aliwo.Cat.age
        Field field = cls.getField("age");
        System.out.println("field : " + field);
        // 通过反射获取属性的值  传统方式 对象.get属性  反射 属性对象.get(对象)
        Object fieldValue = field.get(obj);
        System.out.println("fieldValue : " + fieldValue);
        // 通过反射获取属性(包括public private等)对象
        Field fieldPrivate = cls.getDeclaredField("sex");
        System.out.println("fieldPrivate : " + fieldPrivate); // private static java.lang.String com.aliwo.Cat.sex
        // 暴力破解，可以访问私有的属性变量对象
        fieldPrivate.setAccessible(true);
        // 静态变量第一种形式设置值 通过反射设置私有属性变量的值
        //fieldPrivate.set(obj, "男 私有属性变量");
        // 静态变量第二种形式设置值 通过反射设置私有属性变量的值 静态变量 可以 null的形式
        fieldPrivate.set(null, "男 私有属性变量 null");
        Object fieldPrivateValue = fieldPrivate.get(obj);
        System.out.println("fieldPrivateValue : " + fieldPrivateValue); //男 私有属性变量




    }
}
