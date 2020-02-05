package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 9:25 AM
 * Description: No Description
 */
public class MergeSortedLists {

    public static void main( String[] args ) {
        ListNode head1 = new ListNode();
        ListNode head2 = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        ListNode ln9 = new ListNode();
        head1.next = ln3;
        head2.next = ln2;
        ln2.next = ln4;
        ln3.next = ln5;
        ln4.next = ln6;
        ln5.next = ln7;
        ln6.next = ln8;
        ln7.next = ln9;
        ln8.next=null;
        ln9.next = null;
        head1.data = 1;
        head2.data = 0;
        ln2.data = 2;
        ln3.data = 3;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 6;
        ln7.data = 7;
        ln8.data = 8;
        ln9.data = 9;

        ListNode node =sort2(head1,head2);
        System.out.println(node);
    }
    public static ListNode sort(ListNode head1,ListNode head2){
        if(head1==null||head2==null){
            return head1==null?
                    (head2==null?null:head2)
                    :head1;//如果head1不等于null，那么head2肯定为null
        }

        ListNode curNode1= head1;
        ListNode curNode2= head2;
        ListNode mergedNode = null;
        ListNode preNode = null;
        while(true){
            ListNode next1=curNode1==null?null:curNode1.next;
            ListNode next2=curNode2==null?null:curNode2.next;
            ListNode minNode = null;
            //遍历结束了
            if(curNode1==null&&curNode2==null){
                return mergedNode;
            }
            //如果节点a比节点a'小
            if(curNode2==null// head2遍历结束了,只遍历head1就好了
                    ||curNode1.data<=curNode2.data){
                minNode=curNode1;
                curNode1=next1;
            }else if(curNode1==null
                    ||curNode1.data>curNode2.data){
                minNode=curNode2;
                curNode2=next2;
            }

            if(preNode==null){
                mergedNode = minNode;
                preNode = mergedNode;
            }else{
                preNode.next=minNode;
                preNode=preNode.next;
            }
        }
    }


    /***
     * 每次取链表1和链表2中大的那个节点，同时要把当前节点pMergedHead和下一个节点关联起来，所以有next指针
     * @param head1 链表1
     * @param head2 链表2
     * @return
     */
    public static ListNode sort2(ListNode head1,ListNode head2) {
        if(head1==null) return head2;
        if(head2==null) return head1;

        ListNode pMergedHead =null;

        if(head1.data<head2.data) {//如果链表1的头节点的值小于链表2的头节点的值，因此链表1的头节点是合并后链表的头节点
            pMergedHead =head1;
            //把当前节点和剩下的子链表里最大的那个节点用next指针关联起来
            pMergedHead.next=sort2(head1.next, head2);
        }else {
            pMergedHead =head2;
            //把当前节点和剩下的子链表里最大的那个节点用next指针关联起来
            pMergedHead.next=sort2(head1, head2.next);
        }
        return pMergedHead;
    }

}
