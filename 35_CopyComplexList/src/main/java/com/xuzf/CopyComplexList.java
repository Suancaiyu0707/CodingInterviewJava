package com.xuzf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 12:46 PM
 * Description: No Description
 * 复杂链表的复制
 * 请实现函数ComplexListNode* Clone(ComplexListNode* pHead)，复制一个复杂链表。在复杂链表中，
 * 每个结点除了有一个m_pNext指针指向下一个点外，还有一个m_pSibling 指向链表中的任意结点或者nullptr。
 */
public class CopyComplexList {

    static Map<ListNode,ListNode> map =new HashMap<>();

    public static void main( String[] args ) {
        ListNode root= new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3= new ListNode(3);
        ListNode node4= new ListNode(4);
        ListNode node5= new ListNode(5);
        root.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;

        root.sblingNode=node3;
        node2.sblingNode=node5;
        node4.sblingNode=node2;
        ListNode cloneNode = copyNode(root);
        ListNode cloneNode2 = copyNode2(root);
        System.out.println("");

    }
    public static ListNode copyNode(ListNode root){
        if(root==null){
            return null;
        }

        ListNode cloneRoot = null;

        ListNode current = root;

        ListNode cloneCurrent = new ListNode(current.data);

        cloneRoot= cloneCurrent;

        map.put(current,cloneCurrent);

        while(current.next!=null){
            ListNode next = current.next;
            ListNode copyNext = new ListNode(next.data);
            map.put(next,copyNext);
            cloneCurrent.next=copyNext;

            current = next;
            cloneCurrent= copyNext;
        }
        if(root.sblingNode!=null){
            cloneRoot.sblingNode= map.get(root.sblingNode);
        }
        current = root;

        while(current.next!=null){
            ListNode next = current.next;

            if(next.sblingNode!=null){
                ListNode cloneNext = map.get(next);
                cloneNext.sblingNode= map.get(next.sblingNode);
            }
            current = next;
        }
        return cloneRoot;
    }

    public static ListNode copyNode2(ListNode root) {
        if (root == null) {
            return null;
        }
        ListNode current = root;
        ListNode cloneCurrent=new ListNode(root.data);
        ListNode next = current.next;
        root.next=cloneCurrent;
        //克隆
        while(next!=null){
            ListNode copyNext = new ListNode(next.data);
            cloneCurrent.next=next;
            next=next.next;
            cloneCurrent.next.next=copyNext;
            cloneCurrent=copyNext;
        }
        // 第二步：根据原结点的sibling，设置复制结点的sibling
        ListNode oldNode = root;
        ListNode newNode =root.next;
        while(oldNode.next.next!=null){
            ListNode siblingNode = oldNode.sblingNode;
            if(siblingNode!=null){
                newNode.sblingNode=siblingNode.next;
            }
            oldNode = oldNode.next.next;
            newNode = newNode.next.next;
        }
        //将长链表拆分成原始链表和复制链表（根据奇偶位置）
        ListNode newRoot = root.next;
        newNode =newRoot;
        oldNode=root;
        while(oldNode.next.next!=null){
            ListNode oldNext = oldNode.next.next;
            ListNode newNext = newNode.next.next;
            newNode.next=newNext;
            newNode=newNext;
            oldNode=oldNext;
        }
        return newRoot;
    }
}
