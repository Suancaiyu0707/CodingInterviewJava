package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 10:30 PM
 * Description: No Description
 * 给定头节点和指定节点，采用O(1)的时间复杂度删除指定的节点
 */
public class DeleteNodeInList {

    public static void main( String[] args ) {
        ListNode head = new ListNode();
        ListNode deleteNode = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        head.next = deleteNode;
        deleteNode.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        head.data = 1;
        deleteNode.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;
        deleteNode(head,deleteNode);
        System.out.println(head);
    }
    /***
     * 删除指定节点
     * @param head 头节点
     * @param deleteNode 待删除的节点
     */
    public static void deleteNode(ListNode head,ListNode deleteNode){
        if(head==null||deleteNode==null){
            return ;
        }
        if(deleteNode.next!=null){//表示删除的不是尾节点
            ListNode next = deleteNode.next;
            deleteNode.next=next.next;
            deleteNode.data=next.data;
            next.next=null;
        }else {//如果deleteNode是尾节点
            if(head==deleteNode){
                head=null;
                deleteNode=null;
            }else{
                ListNode curNode = head;
                //如果下一个节点不为空，且不是目标节点
                while(curNode.next!=null//遍历到末尾或者遍历到要删除的节点的前一个节点
                        &&curNode.next!=deleteNode){
                    curNode=curNode.next;
                }
                if(curNode.next==null){
                    return ;
                }
                ListNode next = curNode.next;
                curNode.next=next.next;
                next.next=null;
            }
        }
    }
}
