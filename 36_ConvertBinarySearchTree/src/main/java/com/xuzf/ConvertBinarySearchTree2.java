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
public class ConvertBinarySearchTree2 {

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
        ConvertBinarySearchTree2 convertBinarySearchTree = new ConvertBinarySearchTree2();
        convertBinarySearchTree.convert(currentNode,root);

        while(headNode.next!=null){
            ListNode next = headNode.next;
            headNode = next;
            System.out.print(next.data+" ");
        }
    }

    /***
     * 前置节点
     * @param currentNode
     * @param node 当前节点
     * @return
     */
    public  ListNode convert( ListNode currentNode,BinaryTreeNode node){
        if(node==null){
            return null;
        }
        ListNode newNode = new ListNode(node.data);
        //如果当前节点包含左子🌲，那么currentNode的下一个节点应该是在左子树里
        if(node.left!=null){
            currentNode=convert(currentNode,node.left);
        }

        currentNode.next=newNode;
        newNode.pre=currentNode;
        currentNode=newNode;
        //如果节点包含右子🌲，则继续从右子🌲里查找下一个节点，并currentNode指向右子树
        if(node.right!=null){
            currentNode=convert(currentNode,node.right);
        }
        return currentNode;

    }
}
