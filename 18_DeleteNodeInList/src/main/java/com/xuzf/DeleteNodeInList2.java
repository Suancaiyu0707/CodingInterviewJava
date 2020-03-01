package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 10:30 PM
 * Description: No Description
 * 给定头节点和指定节点，采用O(1)的时间复杂度删除指定的节点
 */
public class DeleteNodeInList2 {

    public static void main( String[] args ) {
        DeleteNodeInList2 deleteNodeInList = new DeleteNodeInList2();
        ListNode head = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        head.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        head.data = 1;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;
        deleteNodeInList.deleteNode(head,ln2);
        System.out.println(head);
    }
    /***
     * 删除指定节点
     * @param head 头节点
     * @param deleteNode 待删除的节点
     */
    public  void deleteNode(ListNode head,ListNode deleteNode){
        if(deleteNode==head){//如果是head节点
            head=head.next;
        }
        //如果当前节点不是尾巴节点，则把删除节点的下一个节点的额内容复制到当前节点，并且当前节点的额指针指向下下节点
        if(deleteNode.next!=null){
            deleteNode.data= deleteNode.next.data;
            deleteNode.next=deleteNode.next.next;
        }
        //如果删除节点是一个尾节点
        if(deleteNode.next==null){
            ListNode current=head;
            //如果下一个节点是待删除节点，则
            while(current.next==deleteNode){
                current= current.next;
            }
            current.next=null;

        }
    }
}
