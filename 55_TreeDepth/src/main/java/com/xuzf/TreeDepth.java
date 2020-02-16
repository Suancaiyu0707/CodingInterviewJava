package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 1:38 PM
 * Description: No Description
 *
 * 获得一个二叉树的深度
 */
public class TreeDepth {

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
//        node3.left=node6;
//        node3.right=node7;
        System.out.println(depth(root,0));
    }
    /***
     * 获得每个子树的最大深度，作为父节点的最大深度
     * @param node
     * @param level
     * @return
     */
    public static int depth(BinaryTreeNode node,int level){

        if(node==null){
            return level;
        }
        level++;
        //左子树的最大深度
        int leftDepth=0;
        //右子树的最大深度
        int rightDepth=0;
        leftDepth= depth(node.left,level);

        rightDepth= depth(node.right,level);
        //从左右子树中获得最大的深度
        return  Math.max(leftDepth,rightDepth);
    }
}
