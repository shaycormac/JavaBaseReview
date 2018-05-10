package com.goldmantis.java_study.array;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ShayPatrickCormac on 2018/5/10.
 *  重新认识以下什么叫做数组
 *  数组是一个特殊的对象
 *  不管在其他语言中数组是什么，在java中它就是对象。一个比较特殊的对象。
 *  普通的java类是以全限定路径名+类名来作为自己的唯一标示的，而数组则是以若干个[+L+数组元素类全限定路径+类来最为唯一标示的。
 *  这个不同也许在某种程度上说明了数组也普通java类在实现上存在很大的区别，也许可以利用这个区别来使得JVM在处理数组和普通java类时作出区分
 */
public class ReNewArray
{
    public static void main(String[] args) 
    {
        Dog[] dogs = new Dog[10];
        String[] strings = new String[5];
        float[] integers = new float[2];
        System.out.println("数组的父类是："+dogs.getClass().getSuperclass());
        System.out.println("数组的类名是："+integers.getClass().getName());
        //数组的父类是：class java.lang.Object
       // 数组的类名是：[Lcom.goldmantis.java_study.array.ReNewArray$Dog;
        //所以他的类名为 [代表了数组的维度，一个[表示一维，两个[表示二维。可以简单的说数组的类名由若干个'['和数组元素类型的内部名称组成
        // 

        String[] array = new String[10];
        Class clazz = array.getClass();
        System.out.println(clazz.getDeclaredFields().length);
        System.out.println(clazz.getDeclaredMethods().length);
        System.out.println(clazz.getDeclaredConstructors().length);
        System.out.println(clazz.getDeclaredAnnotations().length);
        System.out.println(clazz.getDeclaredClasses().length);
        //结果全部是0
        //从这个运行结果可以看出，我们亲爱的[I没有生命任何成员变量、成员方法、构造函数、Annotation甚至
        // 连length成员变量这个都没有，它就是一个彻彻底底的空类
        //JVM对数组的长度做了特殊的处理，它是通过arraylength这条指令来实现的
        
        //三种形式
        int a[] = new int[2];    //默认为0,如果是引用数据类型就为null  
        int b[] = new int[] {1,2,3,4,5};
        int c[] = {1,2,3,4,5};
        
        //数组转换成list的坑点  Arrays这个工具的asList()方法将其转换成列表
        int[] datas =new int[]{1,2,3,4,5};
        List list = Arrays.asList(datas);
        System.out.println(list.size());//长度为1
        //原因 ：基本数据类型是不可能泛型化的，也是就说8个基本数据类型是不可作为泛型参数的
        //但是为什么编译器没有报错呢？这是因为在java中，数组会当做一个对象来处理，它是可以泛型的，
        // 所以我们的程序是把一个int型的数组作为了T的类型，所以在转换之后List中就只会存在一个类型为int数组的元素了
        // 所以我们这样的程序System.out.println(datas.equals(list.get(0)));输出结果肯定是true
        // 当然，如果改成Integer的话，长度又变成5了。
        //todo !!! asList返回的是一个长度不可变的列表。数组是多长，转换成的列表是多长，我们是无法通过add、remove来增加或者减少其长度的。
        //因为Arrays.asList返回的arrayList并不是我们认为的arrayList，而是Arrays的一个内部类，并且没有实现add方法，父类的add方法就是抛异常。，

    }
    
    class Dog
    {
        public String name;
        public int age;
    }
}
