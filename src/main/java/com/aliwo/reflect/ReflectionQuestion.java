package com.aliwo.reflect;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {
        // 使用Properties类可以读取配置文件
        Properties props = new Properties();
        props.load(new FileInputStream("D:\\person-workSpace\\reflect-project\\src\\main\\resources\\re.properties"));
        // com.aliwo.Cat
        String classfullpath = props.get("classfullpath").toString();
        // 你是什么猫啊！
        String methodName = props.get("method").toString();
        System.out.println("classfullpath : " + classfullpath);
        System.out.println("method : " + methodName);
        // 通过反射来实现，读取配置文件来调用Cat的方法hi()，如果新增一个方法我们只需要改配置文件就行， 满足开闭原则
        //一：加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);
        //二: 通过 cls 得到你加载类 com.aliwo.Cat的对象实例
        Object o = cls.newInstance();
        System.out.println("o的运行类型=" + o.getClass()); // 运行类型
        //三： 通过cls得到你加载的类com.aliwo.Cat的methodName"hi"的方法对象，即在反射中，可以把方法视为对象(万物皆对象)
        Method method1 = cls.getMethod(methodName);
        // 通过method1 调用方法：即通过方法对象来实现调用方法
        System.out.println("==============");
        // 传统方法 对象.方法()，反射机制中 方法.invoke(对象)
        method1.invoke(o);
    }
}
