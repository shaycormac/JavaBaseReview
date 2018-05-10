package com.goldmantis.java_study.node_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Shay-Patrick-Cormac
 * @Email: fang47881@126.com
 * @Ltd: 金螳螂企业（集团）有限公司
 * @Date: 2018/5/8 10:00
 * @Version:
 * @Description:
 */

class TestTree {
    public static void main(String[] args) {
        NodeTree tree = NodeTree.createTestTree();
        //遍历前序 根左右
        //  frontTree(tree);
        //后序 左右根
        // backTree(tree);
        //中序 左根右
      //  middleTree(tree);
      //  reverseNodeTree(tree);
      //  System.out.println("--------");
      //  middleTree(tree);
        traverseTreeLayer(tree);
    }

    /**
     * 前序遍历 根，左右，分而治之
     */
    public static void frontTree(NodeTree root) {
        //base case
        if (root == null) {
            return;
        }
        System.out.println(root.object);
        frontTree(root.leftLeave);
        frontTree(root.rightLeave);
    }

    /**
     * 后序遍历 左右，根
     */
    public static void backTree(NodeTree root) {
        //base case
        if (root == null) {
            return;
        }
        backTree(root.leftLeave);
        backTree(root.rightLeave);
        System.out.println(root.object);

    }

    /**
     * 中序 左根右
     */
    public static void middleTree(NodeTree root) { //base case
        if (root == null) {
            return;
        }
        middleTree(root.leftLeave);
        System.out.println(root.object);
        middleTree(root.rightLeave);

    }

    /**
     * 对二叉树进行翻转，分而治之，简化到对每一个二叉树进行反转，进行递归
     */
    public static void reverseNodeTree(NodeTree root) {
        //最基本的，为null，就啥也不做
        if (root == null) {
            return;
        }
        //左叶子
        NodeTree left = root.leftLeave;
        //右叶子
        NodeTree right = root.rightLeave;
        //递归翻转，先找到子节点的最深度，进行叶子互换，即可。
        reverseNodeTree(left);
        reverseNodeTree(right);
        root.leftLeave = right;
        root.rightLeave = left;
    }

    /**
     * 把二叉树铺平，分而治之就是对于每一个二叉树，将左孩子放到右孩子的节点上，并把右孩子作为这个左孩子的右孩子节点，有点绕
     */
    public static void flatTree(NodeTree root) {
        //最基本的，为null，就啥也不做
        if (root == null) {
            return;
        }
        //还是后序
        //左叶子
        NodeTree left = root.leftLeave;
        //右叶子
        NodeTree right = root.rightLeave;
        flatTree(left);
        flatTree(right);

        //把左指针和右指针先指向空。
        root.leftLeave = null;
        root.rightLeave = null;
        //假如左子树生成的链表为空，那么忽略它，把右子树生成的链表指向根节点的右指针
        if (left == null) {
            root.rightLeave = right;

        } else {
            //如果左子树生成链表不为空，那么用while循环获取最后一个节点，并且它的右指针要指向右子树生成的链表的头节点
            //首先把当前跟节点的右节点赋值给左孩子
            root.rightLeave = left;
            //其次，遍历左孩子，将左孩子的最下面的找出来，把它的右节点赋值给现在的右孩子，即可。
            NodeTree lastLeft = left;
            //while 进行遍历，获取左孩子的最后一个节点
            while (lastLeft != null && lastLeft.rightLeave != null) {
                lastLeft = lastLeft.rightLeave;
            }
            lastLeft.rightLeave = right;


        }

        root.rightLeave = left;
        root.leftLeave = null;
        left.leftLeave = null;
        left.rightLeave = right;
    }

    /**
     * 层序遍历二叉树，广度优先，而非深度优先，即二叉树的每一层进行遍历
     * 巧妙办法，使用队列来解决。
     * 巧妙的在于，首先将跟节点存进去，取出来，然后做一个while循环，里面进行左右孩子遍历，添加进
     * 队列，再取出来。这样就把广度优先搞出来。
     */
    public static void traverseTreeLayer(NodeTree root) {
        //最基本的，为null，就啥也不做
        if (root == null) {
            return;
        }
        
        //使用一个队列来解决问题，先进先出嘛
        Queue<NodeTree> queue = new LinkedList<NodeTree>();
        //先把跟节点添加进来
        queue.add(root);
        //遍历这个数
        //利用队列先进先出的性质，我们可以一层层的打印二叉树的节点们
        while (!queue.isEmpty())
        {
            //精髓在于，先把最先进去的搞出来，然后再存下面的，使用队列做了一次中介，屌的一逼。
            
            //先把这个跟节点拉出来
            NodeTree current = queue.poll();
            //把这个节点取出来
            System.out.println(current.object);
            //把左右节点都加进去
            if (current.leftLeave!=null)
            {
                queue.add(current.leftLeave);
            }

            if (current.rightLeave!=null)
            {
                queue.add(current.rightLeave);
            }
        }
    }
}
