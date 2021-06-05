package com.aliwo.reclass;


import java.lang.reflect.Field;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 * Class类的常用方法介绍
 */
public class Class01 {
    public static void main(String[] args) throws Exception {
        String classfullpath = "com.aliwo.Cat";
        // 一：获取Cat类对应的Class对象
        Class cls = Class.forName(classfullpath);
        // 二：输出cls
        // 显示cls对象，是哪个类的Class对象 class com.aliwo.Cat
        System.out.println("cls 是哪个类的Class对象 : " + cls);
        // 输出cls的运行类型   class java.lang.Class
        System.out.println("cls的运行类型为 ：" + cls.getClass());
        // 三：得到包名
        System.out.println("包名为 ：" + cls.getPackage().getName()); // com.aliwo
        // 四：得到全类名
        System.out.println("全类名：" + cls.getName());
        // 五：通过cls创建对象实例
        Object o = cls.newInstance();
        System.out.println("对象实例为：" + o);
        // 六：通过反射获取属性 注意 cls.getField()只能获得公共的成员变量,其他访问权限的会报错
        Field ageField = cls.getField("age");
        // 通过反射实现，传统的是对象.成员变量，反射是 成员对象.get(对象)
        System.out.println("得到age属性所对应的值 : " + ageField.get(o));
        // 七：通过反射给属性赋值
        ageField.set(o, 90);
        System.out.println("通过反射给属性赋值之后的值 ：" + ageField.get(o));
        // 得到所有的属性字段名称
        Field[] fields =  cls.getFields();
        System.out.println("================= 得到所有的属性字段名称"); // age username password
        for (Field f : fields) {
            System.out.print(f.getName() + " ");
        }
        // 得到所有的属性字段名称所对应的值
        Field[] fieldValues =  cls.getFields();
        System.out.println("================= 得到所有的属性字段名称所对应的值"); // 90 xuyy 12344
        for (Field f : fields) {
            System.out.print(f.get(o)+ " ");
        }
    }
}
