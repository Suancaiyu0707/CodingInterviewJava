package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 10:32 PM
 * Description: No Description
 */
public class ListNode {
    //属性定义成公开的方便调用和使用
    public int data;
    //公有属性
    public ListNode next;

    public ListNode( int data ) {
        this.data = data;
    }
    public ListNode( ) {
    }


    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
