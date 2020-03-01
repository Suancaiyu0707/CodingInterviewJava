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
public class KthNodeFromEnd2 {

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

        KthNodeFromEnd2 nodeFromEnd=new KthNodeFromEnd2();

        System.out.println(nodeFromEnd.findKthNode(head,3).data==7);
        ListNode resultNode2 = nodeFromEnd.findKthNode(head,10);
        System.out.println(resultNode2==null);

        System.out.println(nodeFromEnd.findKthNode(head,1).data==9);

        System.out.println(nodeFromEnd.findKthNode(null,1)==null);
        System.out.println(nodeFromEnd.findKthNode(null,-1)==null);

//        ListNode midNode = nodeFromEnd.findMidNode(head);
//        System.out.println(midNode==null?0:midNode.data);
    }

    /***
     * 链表中倒数第k个结点（倒数从1开始数）
     * @param head 头节点
     * @param k 倒数第k个节点
     * @return
     */
    public  ListNode findKthNode(ListNode head,int k){
        if(head==null){
            return null;
        }
        if(k<=0){
            return null;
        }
        //先走的指针
        ListNode firstRef=head;
        //后走的指针
        ListNode secondRef=head;
        //先让第一个指针，先走i-1步,可能链表长度小于k，则返回null
        for(int i=1;i<k;i++){
            if(firstRef.next==null){
                return null;
            }
            firstRef=firstRef.next;
        }
        //让第一个指针和第二个指针一起走，这个时候第一个指针比第二个指针先走了k-1。
        // 所以如果第一个指针到末尾的话，则这个时候第二个指针的位置就是要找的那个位置
        while(firstRef.next!=null){
            firstRef=firstRef.next;
            secondRef=secondRef.next;
        }
        return secondRef;
    }


}
