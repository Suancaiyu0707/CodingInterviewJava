package com.xuzf;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 10:56 PM
 * Description: No Description
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 */
public class PrintTreesInLines2 {

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
        PrintTreesInLines2 printTreesInLines=new PrintTreesInLines2();
        printTreesInLines.printTree(root);
    }
    public  void printTree(BinaryTreeNode root){
        if(root==null){
            return ;
        }
        LinkedBlockingDeque<BinaryTreeNode> queue = new LinkedBlockingDeque <BinaryTreeNode>();
        queue.offer(root);
        //记录每一行的元素个数
        int currentLineCount =1;
        int nextLineCount =0;
        BinaryTreeNode node = null;
        while (!queue.isEmpty()){
            System.out.println();
            //遍历每一层的所有节点，并统计下一层的总节点数
            for(int i=0;i<currentLineCount;i++){
                node = queue.poll();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    queue.add(node.left);
                    nextLineCount++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    nextLineCount++;
                }
            }
            //遍历完该层节点后，更新下一层要遍历的节点总数

            currentLineCount= nextLineCount;
            nextLineCount=0;
        }

    }
}
