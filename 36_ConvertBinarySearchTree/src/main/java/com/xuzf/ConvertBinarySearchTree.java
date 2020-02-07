package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 5:23 PM
 * Description: No Description
 *二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBinarySearchTree {

    public static void main( String[] args ) {
        ListNode headNode =new ListNode(-1);
        ListNode currentNode = headNode;

        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        BinaryTreeNode node7 = new BinaryTreeNode(16);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left=node6;
        node3.right=node7;

        convert(currentNode,root);

        while(headNode.next!=null){
            ListNode next = headNode.next;
            headNode = next;
            System.out.print(next.data+" ");
        }
    }

    public static ListNode convert( ListNode currentNode,BinaryTreeNode treeNode){
        if(treeNode==null){
            return null;
        }
        ListNode newNode = new ListNode(treeNode.data);
        if(treeNode.left!=null){
            currentNode=convert(currentNode,treeNode.left);
        }
        currentNode.next=newNode;
        newNode.pre=currentNode;

        currentNode=newNode;
        if(treeNode.right!=null){
            currentNode=convert(currentNode,treeNode.right);
        }
        return currentNode;
    }
}
