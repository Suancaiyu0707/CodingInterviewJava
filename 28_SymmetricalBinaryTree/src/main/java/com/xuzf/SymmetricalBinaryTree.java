package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 5:15 PM
 * Description: No Description
 * 判断一个二叉树是否对称的二叉树
 */
public class SymmetricalBinaryTree {

    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(6);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        BinaryTreeNode node7 = new BinaryTreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left=node6;
        node3.right=node7;
        System.out.println(validBinaryTree(root));
    }
    /***
     * 验证一个二叉树是否对称
     * @param root
     */
    public static boolean validBinaryTree(BinaryTreeNode root){
        return compareBinaryTree(root,root);
    }

    private static boolean compareBinaryTree(BinaryTreeNode rootFromLeft,BinaryTreeNode rootFromRight){
        if (rootFromLeft==null&&rootFromRight==null){
            return true;
        }
        if (rootFromLeft==null||rootFromRight==null){
            return false;
        }
        //如果两个值不相等，就没必要比较左右节点了
        if(rootFromLeft.data!=rootFromRight.data){
            return false;
        }
        //如果左节点没有对称，则没必要比较右节点了
        if(!compareBinaryTree(rootFromLeft.left,rootFromRight.right)){
            return false;
        }
        if(!compareBinaryTree(rootFromLeft.right,rootFromRight.left)){
            return false;
        }
        return true;
    }
}
