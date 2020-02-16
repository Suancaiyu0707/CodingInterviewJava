package com.xuzf.com.xuzf;

import com.xuzf.BinaryTreeNode;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 2:16 PM
 * Description: No Description
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalancedBinaryTree {

    public static boolean isBalanced=true;
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(8);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//
//        BalancedBinaryTree tree = new BalancedBinaryTree();
//        tree.IsBalanced_Solution(root);
//
//        isBalaced(root,0);
        isBalaced(root,0);
        System.out.println(isBalanced);


    }
    public static void isBalaced( BinaryTreeNode tree, int level){
        getLevel(tree,level);
    }

    public static int getLevel( BinaryTreeNode tree, int level){
        //如果上一层已经发现是非平衡树了，就直接返回，没有必须继续遍历了
        if (!isBalanced){
            return -1;
        }
        if(tree==null) return level;
        level++;
        int leftLevel = getLevel(tree.left,level);
        int rightLevel = getLevel(tree.right,level);

        if(Math.abs((leftLevel-rightLevel))>1){
            isBalanced=false;
        }
        return Math.max(leftLevel,rightLevel);
    }

    public boolean IsBalanced_Solution(BinaryTreeNode root) {
        return getDepth(root)!=-1;
    }
    public int getDepth(BinaryTreeNode root) {
        if(root==null)    return 0;
        int left=getDepth(root.left);
        if(left==-1)    return -1;
        int right=getDepth(root.right);
        if(right==-1)    return -1;
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}
