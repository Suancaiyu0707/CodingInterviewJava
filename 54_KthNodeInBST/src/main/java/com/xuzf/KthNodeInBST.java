package com.xuzf;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 12:46 PM
 * Description: No Description
 */
public class KthNodeInBST {


    public static  int count = 0;

    static int index=0;
    public static   BinaryTreeNode result = null;
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
        node3.left=node6;
        node3.right=node7;
        findKNode(root,2);
        System.out.println(result);
        System.out.println(getKthNode(root,2));


    }
    public static BinaryTreeNode findKNode(BinaryTreeNode node,int k){
        if(node==null){
            return null;
        }
        BinaryTreeNode right = node.right;
        if(right!=null){
            findKNode(right,k);
        }

        int data = node.data;
        count++;
        if(count==k){
            result=node;
        }
        if(result!=null){
            return result;
        }
        BinaryTreeNode left = node.left;
        if(left!=null){
            return findKNode(left,k);
        }
        return null;
    }

    private static BinaryTreeNode getKthNode( BinaryTreeNode pRoot, int k){
        BinaryTreeNode kthNode=null;

        if(pRoot.left!=null)
            kthNode=getKthNode(pRoot.left,k);

        if(kthNode==null){
            index++;
            if(k==index)
                kthNode = pRoot;
        }

        if(kthNode==null && pRoot.right!=null)
            kthNode=getKthNode(pRoot.right,k);

        return kthNode;
    }
}
