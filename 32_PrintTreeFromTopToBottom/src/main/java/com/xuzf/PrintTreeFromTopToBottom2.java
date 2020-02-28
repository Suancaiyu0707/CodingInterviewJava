package com.xuzf;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 10:43 PM
 * Description: No Description
 * 从上到下，打印一个二叉树
 */
public class PrintTreeFromTopToBottom2 {
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
        PrintTreeFromTopToBottom2 printTreeFromTopToBottom = new PrintTreeFromTopToBottom2();
        printTreeFromTopToBottom.printTree(root);
    }
    public void printTree(BinaryTreeNode root){
        if(root==null) return ;
        LinkedBlockingDeque<BinaryTreeNode> queue = new LinkedBlockingDeque <BinaryTreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            System.out.print(node.data+"-->");

            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }


    }
}
