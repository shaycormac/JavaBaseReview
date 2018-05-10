package com.goldmantis.java_study.node_tree;

/**
 * @Author: Shay-Patrick-Cormac
 * @Email: fang47881@126.com
 * @Ltd: 金螳螂企业（集团）有限公司
 * @Date: 2018/5/8 09:52
 * @Version: 1.0
 * @Description: 二叉树
 */

class NodeTree 
{
    //左叶子
    public NodeTree leftLeave;
    //右叶子
    public NodeTree rightLeave;
    //每个节点包含的信息，可能是一个对象，先用简单字符串来表示
    public String object;

    public NodeTree(NodeTree leftLeave, NodeTree rightLeave, String object) {
        this.leftLeave = leftLeave;
        this.rightLeave = rightLeave;
        this.object = object;
    }

    //没有节点的构造方法，带有值
    public NodeTree(String object) {
        this.object = object;
    }

    //对称二叉树，从跟节点A依次到G，自己脑补
    public static NodeTree createTestTree()
    {
        NodeTree G = new NodeTree("G");
        NodeTree F = new NodeTree("F");
        NodeTree C = new NodeTree(F, G, "C");

        NodeTree E = new NodeTree("E");
        NodeTree D = new NodeTree("D");
        NodeTree B = new NodeTree(D, E, "B");

        NodeTree A = new NodeTree(B, C, "A");
        return A;
    }
}
