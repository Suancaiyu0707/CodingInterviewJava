package com.xuzf.List;

import java.util.Stack;

/**
 * Author: zhangjianan
 * Date: 2020/3/29 3:00 下午
 * Desc: 单链表倒序打印
 */
public class ListReverseOrder {

    private Node head;
    private int size;


    public void insert(int data){
        Node node = new Node(data);
        if (head == null){
            head = node;
            size++;
            return;
        }
        Node next = head;
        while (next.next != null){
            next = next.next;
        }
        next.next = node;
        size++;
    }


    private  static Stack<Integer> stack = new Stack();

    private static void printReverse(ListReverseOrder listReverseOrder){
        if (listReverseOrder.head == null){
            return;
        }
        Node node = listReverseOrder.head;
        while (node.next != null){
            stack.push(node.data);
            node = node.next;
        }
        stack.push(node.data);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    static class Node{
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    public static void main( String[] args ) {
        ListReverseOrder listReverseOrder = new ListReverseOrder();
        listReverseOrder.insert(1);
        listReverseOrder.insert(2);
        listReverseOrder.insert(3);
        listReverseOrder.insert(4);
        System.out.println("size="+listReverseOrder.size);
        printReverse(listReverseOrder);

    }
}
