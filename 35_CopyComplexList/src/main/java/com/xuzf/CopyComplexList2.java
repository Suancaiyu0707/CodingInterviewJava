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
public class CopyComplexList2 {

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
        CopyComplexList2 copyComplexList = new CopyComplexList2();
        ListNode cloneNode = copyComplexList.copyNode(root);
        System.out.println(cloneNode);
        ListNode cloneNode2 = copyComplexList.copyNode2(root);
        System.out.println(cloneNode2);

    }

    /***
     * 从头节点开始遍历，并复制一个链表
     * @param head
     * @return
     */
    public ListNode copyNode(ListNode head){

        if(head==null){
            return null;
        }

        ListNode current = head;

        ListNode cloneNode_head = new ListNode(current.data);
        ListNode cloneNode_current = cloneNode_head;
        map.put(head,cloneNode_head);
        //第一步，先遍历链表，复制一个只有next指针的一摸一样的链表,并维护映射关系
        while(current.next!=null){
            ListNode next = current.next;
            ListNode cloneNode_next = new ListNode(next.data);
            map.put(next,cloneNode_next);
            cloneNode_current.next=cloneNode_next;
            current = next;
            cloneNode_current=cloneNode_next;
        }
        //第二步，根据旧的链表的sibling关系，维护新链表的sibling关系
        current = head;
        cloneNode_current = cloneNode_head;
        while(current!=null){
            ListNode siblingNode = current.sblingNode;
            if(siblingNode!=null){
                cloneNode_current.sblingNode=map.get(siblingNode);
            }
            current = current.next;
            cloneNode_current=cloneNode_current.next;
        }
        return cloneNode_head;
    }

    /***
     *
     * @param head
     * @return
     */
    public  ListNode copyNode2(ListNode head) {
        if (head == null) {
            return null;
        }
        if(head==null){
            return null;
        }

        ListNode current = head;
        //创建一个克隆链表:A->A'->B->B'.....
        while(current!=null){
            //获得当前节点的next节点
            ListNode next = current.next;
            //根据当前节点获得克隆节点
            ListNode cloneNode_current = new ListNode(current.data);
            current.next=cloneNode_current;
            cloneNode_current.next=next;
            //将cloneNode_current的next指向下一个节点
            current=next;
        }
        //从头到尾遍历原始的节点，并维护sbling
        //A->A'->B->B'.....
        current = head;
        while(current!=null){
            if(current.sblingNode!=null){
                current.next.sblingNode=current.sblingNode.next;
            }
            //每次要跳开两个节点
            current=current.next.next;
        }
        current = head;
        ListNode cloneNode_head = current.next;
        ListNode cloneNode_current = cloneNode_head;
        while (current!=null){
            //获得当前节点的克隆节点的的下一个节点的
            current.next=cloneNode_current.next;
            if(current.next!=null){
                cloneNode_current.next=current.next.next;
            }
            current=current.next;
            cloneNode_current=cloneNode_current.next;
        }
        return cloneNode_head;
    }
}
