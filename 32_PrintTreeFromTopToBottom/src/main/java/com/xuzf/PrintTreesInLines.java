package com.xuzf;

import javax.swing.tree.TreeNode;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 10:56 PM
 * Description: No Description
 * 从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。
 */
public class PrintTreesInLines {

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

        printTree(root);
    }
    public static void printTree(BinaryTreeNode root){
        if(root==null){
            return ;
        }
        LinkedBlockingDeque<BinaryTreeNode> queue = new LinkedBlockingDeque <BinaryTreeNode>();
        queue.offer(root);
        BinaryTreeNode node = null;
        int currentLevelCount=0; //当前层结点数目，用于控制需要将队列中对应的个数的节点划入同一行
        int nextLevelCount =1;//下一层结点数目，这边下一层是root节点，因为从root开始遍历
        while(!queue.isEmpty()){
            currentLevelCount=nextLevelCount;//表示当前层要弹出的元素个数
            nextLevelCount=0;
            for(int i=0;i<currentLevelCount;i++){
                node=queue.pop();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    queue.add(node.left);
                    //统计下一层的节点数，控制遍历到什么时候结束
                    nextLevelCount++;
                }
                if(node.right!=null){
                    queue.add(node.right);
                    nextLevelCount++;
                }
            }
            System.out.println();
        }
    }
}
