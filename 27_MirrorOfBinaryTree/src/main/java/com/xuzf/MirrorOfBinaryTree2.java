package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 5:00 PM
 * Description: No Description
 * 求一个二叉树的镜像
 */
public class MirrorOfBinaryTree2 {


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
        MirrorOfBinaryTree2 mirrorOfBinaryTree = new MirrorOfBinaryTree2();
        System.out.println(mirrorOfBinaryTree.mirrorOfBinaryTree(root));;
        System.out.println("=========");
    }
    public  BinaryTreeNode mirrorOfBinaryTree(BinaryTreeNode root){
        if(root==null){
            return root;
        }
        BinaryTreeNode temp = new BinaryTreeNode(-1);
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null){
            mirrorOfBinaryTree(root.left);
        }
        if(root.right!=null){
            mirrorOfBinaryTree(root.right);
        }
        return root;
    }

}
