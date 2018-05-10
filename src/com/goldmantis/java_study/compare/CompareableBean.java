package com.goldmantis.java_study.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Shay-Patrick-Cormac
 * @Email: fang47881@126.com
 * @Ltd: 金螳螂企业（集团）有限公司
 * @Date: 2018/5/10 0010 14:56
 * @Version: 1.0 
 * @Description: 实现Compareable接口的JavaBean,用来对象的比较
 */

class CompareableBean implements Comparable<CompareableBean> 
{
    public int age;
    public String name;

    public CompareableBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(CompareableBean o) 
    {
        //拿当前this的属性和传过来的进行比较
        if (this.age>o.age)
        {
            return 1;
        }else if (this.age<o.age)
        {
            return -1;
        }
        return 0;
    }
    
    
    public static List<CompareableBean> createList()
    {
        List<CompareableBean> beanList = new ArrayList<>();
        CompareableBean bean = new CompareableBean(15, "小明");
        beanList.add(bean);
        bean = new CompareableBean(2, "小朋友");
        beanList.add(bean);
        bean = new CompareableBean(92, "老朋友");
        beanList.add(bean);
        return beanList;
    }


    public static void main(String[] args) 
    {
        List<CompareableBean> beanList = createList();
        Collections.sort(beanList);
        for (int i = 0; i < beanList.size(); i++)
        {
            System.out.println("当前的人名字为："+beanList.get(i).name);
            
        }
    }
    
}
