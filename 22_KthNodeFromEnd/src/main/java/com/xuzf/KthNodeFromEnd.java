package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 9:20 PM
 * Description: No Description
 * 链表中倒数第k个结点（倒数从1开锁数）
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾结点是倒数第1个结点。
 * 例如一个链表有6个结点，从头结点开始它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个结点是值为4的结点。
 */
public class KthNodeFromEnd {

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
        ListNode resultNode = findKthNode(head,3);
        System.out.println(resultNode==null?0:resultNode.data);


        ListNode midNode = findMidNode(head);
        System.out.println(midNode==null?0:midNode.data);
    }

    /***
     * 链表中倒数第k个结点（倒数从1开始数）
     * @param head 头节点
     * @param k
     * @return
     */
    public static ListNode findKthNode(ListNode head,int k){
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        int i = 0;

        ListNode firstStepNode = head;
        ListNode secondStepNode = head;
        //先把firstStepNode走到第k个节点
        while(i<k-1){//当firstStep=k-2为最后一次循环
            if(firstStepNode.next==null){
                return null;
            }
            //当i=k-2的时候，也就是遍历了k-1次，所以此时，firstStepNode在第k个节点上
            firstStepNode=firstStepNode.next;
            i++;
        }
        //此时，firstStepNode在第k个节点上，secondStepNode在第1个节点上
        while(firstStepNode.next!=null){
            secondStepNode = secondStepNode.next;
            firstStepNode=firstStepNode.next;
        }
        return secondStepNode;
    }

    /**
     * 查找链表的中间节点
     * @param head
     * @return
     */
    public static ListNode findMidNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode oneStepNode = head;
        ListNode twoStepNode = head;
        while(oneStepNode.next!=null&&twoStepNode.next!=null&&twoStepNode.next.next!=null){
            oneStepNode = oneStepNode.next;
            twoStepNode=twoStepNode.next.next;
        }
        return oneStepNode;
    }
}
