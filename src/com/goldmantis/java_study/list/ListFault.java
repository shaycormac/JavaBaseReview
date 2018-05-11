package com.goldmantis.java_study.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Shay-Patrick-Cormac
 * @Email: fang47881@126.com
 * @Ltd: 金螳螂企业（集团）有限公司
 * @Date: 2018/5/11 0011 14:45
 * @Version: 1.0
 * @Description: List集合的一些缺陷
 */

class ListFault {

    public static void main(String[] args)
    {
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);

        //通过构造函数新建一个包含list1的列表 list2
        List<Integer> list2 = new ArrayList<Integer>(list1);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list3 = list1.subList(0, list1.size());

        //修改list3
        list3.add(3);

        System.out.println("list1 == list2：" + list1.equals(list2));//false
        System.out.println("list1 == list3：" + list1.equals(list3));//true
        //ubList返回的只是原列表的一个视图，它所有的操作最终都会作用在原列表上
        
        //todo  subList生成子列表后，不要试图去操作原列表

        List<Integer> list4 = new ArrayList<Integer>();
        list4.add(1);
        list4.add(2);

        //通过subList生成一个与list1一样的列表 list3
        List<Integer> list5 = list4.subList(0, list4.size());
        //修改list3
        list4.add(3);

        System.out.println("list1'size：" + list4.size());
        System.out.println("list3'size：" + list5.size());
        
        //对于子列表视图，它是动态生成的，生成之后就不要操作原列表了，否则必然都导致视图的不稳定而抛出异常。
        // 最好的办法就是将原列表设置为只读状态，要操作就操作子列表
        //通过subList生成一个与list1一样的列表 list3
      //  List<Integer> list3 = list1.subList(0, list1.size());

//对list1设置为只读状态
      //  list1 = Collections.unmodifiableList(list1);
        
        //3.推荐使用subList处理局部列表
        //开发过程中我们一定会遇到这样一个问题：获取一堆数据后，需要删除某段数据。例如，有一个列表存在1000条记录，我们需要删除100-200位置处的数据
        
        /*
        * 当然这段代码存在问题，list remove之后后面的元素会填充上来，
         * 所以需要对i进行简单的处理，当然这个不是这里讨论的问题。
         */
       /* for(int i = 0 ; i < list1.size() ; i++){
            if(i >= 100 && i <= 200){
                list1.remove(i);
       
            }
        }*/
       //下面一行代码全部搞定
        list1.subList(100, 200).clear();
    }
}
