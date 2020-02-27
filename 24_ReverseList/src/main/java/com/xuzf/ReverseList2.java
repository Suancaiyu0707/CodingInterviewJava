package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 10:59 PM
 * Description: No Description
 * 反转链表
 */
public class ReverseList2 {
    public static void main( String[] args ) {
        ListNode head = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ListNode ln9 = new ListNode();
        head.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = ln9;
        ln9.next = null;
        head.data = 1;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;
        ln9.data = 9;

        ListNode node =reverse(null);
        System.out.println(node);
    }

    public static ListNode  reverse(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode curNode = head;
        ListNode preNode = null;
        while(curNode!=null){
            ListNode next = curNode.next;
            curNode.next=preNode;
            preNode=curNode;
            curNode=next;
        }

        return preNode;
    }
}
