package com.xuzf.bean;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/12
 * Time: 10:16 AM
 * Description: No Description
 */
public class ListNode {
    public  ListNode next;

    public int val;

    public ListNode getNext() {
        return next;
    }

    public void setNext( ListNode next ) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal( int val ) {
        this.val = val;
    }

    public ListNode( int val ) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "next=" + next +
                ", val=" + val +
                '}';
    }
}
