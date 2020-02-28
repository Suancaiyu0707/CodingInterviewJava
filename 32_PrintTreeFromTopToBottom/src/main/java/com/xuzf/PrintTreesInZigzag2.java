package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 11:07 PM
 * Description: No Description
 * 实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
 */
public class PrintTreesInZigzag2 {
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left=node6;
        node5.right=node7;
        PrintTreesInZigzag2 printTreesInZigzag = new PrintTreesInZigzag2();
        printTreesInZigzag.printTree(root);
    }
    public  void printTree(BinaryTreeNode root){
        if(root==null){
            return ;
        }
        Stack<BinaryTreeNode> stackFromLeft = new Stack <BinaryTreeNode>();
        Stack<BinaryTreeNode> stackFromRight = new Stack <BinaryTreeNode>();
        BinaryTreeNode node = null;
        stackFromLeft.push(root);
        while (!stackFromLeft.isEmpty()||!stackFromRight.isEmpty()){
            while(!stackFromLeft.isEmpty()){
                node=stackFromLeft.pop();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    stackFromRight.add(node.left) ;
                }
                if(node.right!=null){
                    stackFromRight.add(node.right) ;
                }
            }
            System.out.println();
            while(!stackFromRight.isEmpty()){
                node = stackFromRight.pop();
                System.out.print(node.data+" ");
                if(node.right!=null){
                    stackFromLeft.add(node.right) ;
                }
                if(node.left!=null){
                    stackFromLeft.add(node.left) ;
                }

            }
            System.out.println();
        }
    }
}
