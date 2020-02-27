package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 5:00 PM
 * Description: No Description
 * 求一个二叉树的镜像
 */
public class SymmetricalBinaryTree2 {


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
        SymmetricalBinaryTree2 symmetricalBinaryTree = new SymmetricalBinaryTree2();
        System.out.println(symmetricalBinaryTree.mirrorOfBinaryTree(root));
    }
    public  boolean mirrorOfBinaryTree(BinaryTreeNode root){
        if(root==null){
            return true;
        }

        BinaryTreeNode leftCursor = root;
        BinaryTreeNode rightCursor = root;
        return mirrorOfBinaryTreeCore(root,root);
    }

    public  boolean mirrorOfBinaryTreeCore(BinaryTreeNode leftCursor,BinaryTreeNode rightCursor){
        if(leftCursor==null&&rightCursor==null){
            return true;
        }
        if(leftCursor==null||rightCursor==null){
            return false;
        }
        if(leftCursor.data==rightCursor.data){
            return  mirrorOfBinaryTreeCore(leftCursor.left,rightCursor.right)
                    && mirrorOfBinaryTreeCore(leftCursor.right,rightCursor.left);
        }
        return false;
    }
}
