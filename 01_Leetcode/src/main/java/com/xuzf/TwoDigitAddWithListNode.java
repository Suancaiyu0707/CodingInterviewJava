package com.xuzf;

import com.xuzf.bean.ListNode;

import javax.xml.ws.soap.Addressing;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/12
 * Time: 10:15 AM
 * Description: No Description
 * 2.两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 */
public class TwoDigitAddWithListNode {

    public static void main( String[] args ) {
        ListNode l1 = new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);

        TwoDigitAddWithListNode test = new TwoDigitAddWithListNode();
        System.out.println(test.addTwoNumbers(l1,l2));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode cur = new ListNode(0);
        //进位
        int carry=0;
        ListNode pre =cur;
        while (true){
            int data1 = l1==null?0:l1.val;
            int data2= l2==null?0:l2.val;
            int addData=(data1+data2+carry)%10;
            carry=(data1+data2+carry)/10;
            cur.next=new ListNode(addData);
            cur=cur.next;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            if(l1==null&&l2==null){
                break;
            }
        }
        if(carry>0){
            cur.next=new ListNode(carry);
        }
        return pre.next;
    }
}
