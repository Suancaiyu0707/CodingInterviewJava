package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 5:39 PM
 * Description: No Description
 */
public class PrintListInReversedOrder2 {
    public static Stack<Integer> stack = new Stack <>();
    public static void main( String[] args ) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);


        PrintListInReversedOrder2 order2 = new PrintListInReversedOrder2();
        order2.reversePrint(linkedList.head);
        System.out.println();
        order2.reversePrint2(linkedList.head);
    }

    /***
     * 当链表过长时，会有函数调用栈溢出
     * @param head
     */
    public void reversePrint(ListNode head){
        if(head==null){
            return;
        }

        if(head.next!=null){
            reversePrint(head.next);
        }
        System.out.print(head.data+"-->");
    }

    public void reversePrint2(ListNode head){
        if(head==null){
            return;
        }

        ListNode next = head.next;
        stack.add(head.data);
        while(next!=null){
            stack.add(next.data);
            next=next.next;
        }

        while(!stack.isEmpty()){

            System.out.print(stack.pop()+"-->");
        }
    }
}
