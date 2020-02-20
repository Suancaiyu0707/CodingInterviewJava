package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 5:41 PM
 * Description: No Description
 */
public class MyLinkedList {
    public ListNode head;

    public MyLinkedList(){
        this.head = null;
    }

    public void add(int data){
        ListNode node = new ListNode(data);
        if(this.head==null){
            this.head = node;
            return ;
        }
        ListNode next=head;
        while(next.next!=null){//表示当前的next不是最后一个节点，所以继续往下找
            next=next.next;
        }
        next.next=node;
    }

    /***
     * 从头到尾打印节点
     * @param linkedList
     */
    public static void printListInOrder(MyLinkedList linkedList){
        if(linkedList.head==null){
            return;
        }
        ListNode node = linkedList.head;
        while (node.next!=null){//表示当前节点不是最后一个节点，所以继续往下打印
            System.out.println(node.data);
            node = node.next;
        }
        //表示当前节点是最后一个节点
        System.out.println(node.data);


    }
    /***
     * 从尾到头打印节点
     * @param linkedList
     */
    public static void printListInReversedOrder(MyLinkedList linkedList){
        if(linkedList.head==null){
            return;
        }
        printListInReversedOrder(linkedList.head);
    }

    private static void printListInReversedOrder(ListNode node){
        if (node.next!=null){//如果存在下一个节点的话，先打印下一个节点
            printListInReversedOrder(node.next);
        }
        //打印完下一个节点，再打印当前节点
        System.out.println(node.data);
    }
}
