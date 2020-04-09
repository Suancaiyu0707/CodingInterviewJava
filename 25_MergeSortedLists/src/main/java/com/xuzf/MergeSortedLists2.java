package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 9:25 AM
 * Description: No Description
 */
public class MergeSortedLists2 {

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
        MergeSortedLists2 mergeSortedLists = new MergeSortedLists2();
        ListNode node =mergeSortedLists.sort(head1,head2);
        System.out.println(node);
    }
    public ListNode sort(ListNode head1,ListNode head2){
        ListNode mergedNodeHead = new ListNode(-1);
        ListNode mergedNode = mergedNodeHead;
        if(head1==null||head2==null){
            return head1!=null?head1:(head2==null?mergedNode:head2);
        }

        ListNode cursor1=head1;
        ListNode cursor2=head2;
        //两个链表都遍历完才结束
        while(cursor1!=null||cursor2!=null){
            if(cursor1==null){//如果链表1遍历结束，则直接把剩下的cursor2全加到mergedNode末尾即可
                mergedNode.next=cursor2;
                break;
            }
            if(cursor2==null){//如果链表2遍历结束，则直接把剩下的cursor1全加到mergedNode末尾即可
                mergedNode.next=cursor1;
                break;
            }
            //走到这边，说明两个链表都还没遍历结束，则需要做比较
            if(cursor1.data<cursor2.data){
                mergedNode.next=cursor1;
                mergedNode=mergedNode.next;
                cursor1=cursor1.next;
            }else{
                mergedNode.next=cursor2;
                mergedNode=mergedNode.next;
                cursor2=cursor2.next;
            }
        }
        return mergedNodeHead.next;
    }


}
