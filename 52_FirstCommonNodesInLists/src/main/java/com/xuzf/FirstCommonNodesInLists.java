package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 11:26 PM
 * Description: No Description
 * 两个链表的第一个公共结点
 */
public class FirstCommonNodesInLists {

    public static void main( String[] args ) {
        ListNode phead1=new ListNode(1);
        phead1.next=new ListNode(2);
        phead1.next.next=new ListNode(3);
        phead1.next.next.next=new ListNode(6);
        phead1.next.next.next.next=new ListNode(7);

        ListNode phead2=new ListNode(4);
        phead2.next=new ListNode(5);
        phead2.next.next=new ListNode(6);
        phead2.next.next.next=new ListNode(7);

        System.out.println(findFirstCommonNode1(phead1,phead2));
    }
    /***
     * 获得两个节点的第一个公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode findFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        int count1= countNode(pHead1);
        int count2= countNode(pHead2);
        System.out.println("count1="+count1);
        System.out.println("count2="+count2);
        ListNode longHead = count2>count1?pHead2:pHead1;
        ListNode shortHead = count2>count1?pHead1:pHead2;
        //获得两个链表的长度差,先让队列长的先走sub步
        int sub = Math.abs(count1-count2);
        System.out.println("sub="+sub);
        while(sub>0){
            longHead=longHead.next;
            sub--;
        }

        while(longHead!=null&&shortHead!=null){
            if(longHead.data==shortHead.data){
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    public static int countNode(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}
