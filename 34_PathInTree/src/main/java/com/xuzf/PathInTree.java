package com.xuzf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 11:05 AM
 * Description: No Description
 * 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {

    private static List<Integer> list = new ArrayList<>();

    private static  int dest=0;
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        dest=22;
        pathInTree(root,22);
    }

    /***
     *
     * @param root
     * @return
     */
    public static void pathInTree(BinaryTreeNode root,int dest){

        if(root==null){
            return ;
        }
        int data = root.data;

        dest = dest-data;
        list.add(data);
        //如果到了叶子节点，判断这个值是不是为0，为0表示该路径符合要求
        if(root.right==null&&root.left==null){//叶子节点
            if(dest==0){//符合，打印数据
                System.out.println(" ");
                System.out.println(" find the path");
                for (int i=0;i<list.size();i++){
                    System.out.print(list.get(i)+" ");
                }
            }

        }

        //判断是否有左子节点，有的话，说明还不是叶子节点，继续向下累加
        if(root.left!=null){
             pathInTree(root.left,dest);
        }
        //判断是否有右子节点，有的话，说明还不是叶子节点，继续向下累加
        if(root.right!=null){
             pathInTree(root.right,dest);
        }
        //把数恢复回去，并弹出最后一个
        dest=dest+data;
        list.remove(list.size()-1);
    }
}
