package com.aliwo.reclass;

import com.aliwo.Cat;

/**
 * @author xuyayuan
 * @data 2021年06月05日
 * 获取Class对象的六种方式
 */
public class GetClass01 {
    public static void main(String[] args) throws Exception {
        /*
         一：前提，已知一个类的全类名，且该类在类路径下，可通过Class类的静态方法forName()
         获取，可能抛出ClassNotFoundException，
         实例：Class cls = Class.forName("com.aliwo.Cat")；
        应用场景：多用于配置文件，读取类全路径，加载类。
        */
        String classfullpath = "com.aliwo.Cat";
        Class cls01 = Class.forName(classfullpath);
        System.out.println("cls01 : " + cls01);
        /*
        二：前提，若已知具体的类，通过类的class获取，该方式最为安全可靠，程序性能最高，
            实例：Class cls2 = Cat.class；
        应用场景：多用于参数传递，比如通过反射得到对应构造器对象。
        */
        Class cls02 = Cat.class;
        System.out.println("cls02 : " + cls02);
        /*
         三：对象.getClass() 应用场景 对象实例已经有了
         三：前提，已知某个类的实例，调用该实例的getClass()方法获取Class对象，实例：
            Class cls03 = 对象.getClass()；// 运行类型
            应用场景：通过创建好的对象，获取Class对象
        */
        Cat cat = new Cat();
        Class cls03 = cat.getClass();
        System.out.println("cls03 : " + cls03);
        /*
         四：通过类加载器【4种】，来获取到类的Class对象
         四：其他方式
        ClassLoader classLoader = 对象.getClass().getClassLoader();
        Class cls04 = classLoader .loadClass("类的全类名")
         */
        // 第一步先得到类加载器
        ClassLoader classLoader = cat.getClass().getClassLoader();
        // 通过类加载器得到Class对象
        Class cls04 = classLoader.loadClass(classfullpath);
        System.out.println("cls04 : " + cls04);
        // cls01 cls02 cls03 cls04 其实是同一个对象
        System.out.println("=================================================");
        System.out.println("cls01 hashCode : " + cls01.hashCode());
        System.out.println("cls02 hashCode : " + cls02.hashCode());
        System.out.println("cls03 hashCode : " + cls03.hashCode());
        System.out.println("cls04 hashCode : " + cls04.hashCode());
        System.out.println("=================================================");
        /*
         五：基本数据(int，char，boolean，float，double，byte，long，short)按如下方式得到Class类型
         */
        Class cls05 = int.class;
        Class characterClass = char.class;
        System.out.println("cls05 : " + cls05);
        /*
        六：基本数据类型对应的包装类，可以通过.type得到Class类对象
        */
        Class cls06 = Integer.TYPE;
        System.out.println("cls06 : " + cls06);
        System.out.println("cls05 hashCode : " + cls05.hashCode());
        System.out.println("cls06 hashCode : " + cls06.hashCode());


    }
}
