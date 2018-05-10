package com.goldmantis.java_study.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Shay-Patrick-Cormac
 * @Email: fang47881@126.com
 * @Ltd: 金螳螂企业（集团）有限公司
 * @Date: 2018/5/10 0010 15:12
 * @Version:
 * @Description: comparator 主要用来对类的某个属性进行比较，而非让整个类实现Compareable
 */

 public class ComparatorBean
{
    public int age;
    public String name;

    public ComparatorBean(int age, String name) 
    {
        this.age = age;
        this.name = name;
    }
    
    
    //只对它的属性进行处理
    static class AgeComparator implements Comparator<ComparatorBean>
    {

        @Override
        public int compare(ComparatorBean o1, ComparatorBean o2) 
        {
            //对这两个对象进行取其中的值进行比较
            int preAge = o1.age;
            int currAge = o2.age;
            //拿当前this的属性和传过来的进行比较
            if (preAge>currAge)
            {
                return 1;
            }else if (preAge<currAge)
            {
                return -1;
            }
            return 0;
        }

       
    }


    public static List<ComparatorBean> createList()
    {
        List<ComparatorBean> beanList = new ArrayList<>();
        ComparatorBean bean = new ComparatorBean(15, "小明");
        beanList.add(bean);
        bean = new ComparatorBean(2, "小朋友");
        beanList.add(bean);
        bean = new ComparatorBean(92, "老朋友");
        beanList.add(bean);
        return beanList;
    }


    public static void main(String[] args)
    {
        List<ComparatorBean> beanList = createList();
        Collections.sort(beanList,new AgeComparator());
        for (int i = 0; i < beanList.size(); i++)
        {
            System.out.println("人名字为："+beanList.get(i).name);

        }
    }
}
