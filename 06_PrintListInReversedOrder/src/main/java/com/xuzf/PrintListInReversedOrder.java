package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 5:39 PM
 * Description: No Description
 */
public class PrintListInReversedOrder {

    public static void main( String[] args ) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        MyLinkedList.printListInOrder(linkedList);
        MyLinkedList.printListInReversedOrder(linkedList);

    }
}
