package com.xuzf;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: zhangjianan
 * Date: 2020/4/8 3:14 下午
 * Desc: 找出二叉树的下一个结点
 *  给定一个二叉树和其中一个结点，找出中序遍历序列{d,b,h,e,i,a,f,c,g}的下一个结点
 *  树中的结点除了有两个分别指向左、右子结点的的指针，还有一个指向其父结点的指针
 */
public class NextNodeInBinaryTrees3 {

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode("a");
        TreeLinkNode node2 = new TreeLinkNode("b");
        TreeLinkNode node3 = new TreeLinkNode("c");
        TreeLinkNode node4 = new TreeLinkNode("d");
        TreeLinkNode node5 = new TreeLinkNode("e");
        TreeLinkNode node6 = new TreeLinkNode("f");
        TreeLinkNode node7 = new TreeLinkNode("g");
        TreeLinkNode node8 = new TreeLinkNode("h");
        TreeLinkNode node9 = new TreeLinkNode("i");

        node1.left = node2;
        node1.right = node3;
        node2.parent = node3.parent = node1;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.parent = node5.parent = node2;
        node5.left = node8;
        node5.right = node9;
        node6.parent = node7.parent = node3;
        node8.parent = node9.parent = node5;
        List<String> result = new ArrayList<String>();
        inOrder(result, node1);
        System.out.println("中序遍历的结果："+result);

        System.out.println(getNext(node1).val2);
        System.out.println(getNext(node2).val2);
        System.out.println(getNext(node4).val2);
        System.out.println(getNext(node9).val2);
    }

    //            a

    //     b               c

    //d        e       f      g

    //      h     i
    static TreeLinkNode getNext(TreeLinkNode pNode){
        if (pNode == null){
            return null;
        }
//        TreeLinkNode parent = pNode.parent;
        //第一种情况 当前结点有右子树，那么它的下一个结点就是右子树上的最左子结点 eg: b的下一个结点是h
        if (pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null){
                pRight = pRight.left;
            }
            return pRight;
        }

        //第二种情况 当前结点无右子树
        while (pNode.parent != null) {
            //如果当前结点是其父结点的左结点，那下一个结点就是父结点 eg: d的下一个结点是b
            if (pNode == pNode.parent.left) {
                return pNode.parent;
            }
            //当前结点是其父结点的右结点，沿其父结点的指针一直向上遍历，直到找到一个结点是其父结点的左子结点，
            //这个结点的父结点就是下一个结点 eg: i的下一个结点是a  i->e->b->a
            pNode = pNode.parent;
        }
        return null;
    }

    static void inOrder(List<String> list, TreeLinkNode node){
        if (node == null){
            return;
        }
        if (node.left != null){
            inOrder(list, node.left);
        }
        list.add(node.val2);
        if (node.right != null){
            inOrder(list, node.right);
        }
    }
}
