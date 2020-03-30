package com.xuzf.List;

/**
 * Author: zhangjianan
 * Date: 2020/3/29 5:39 下午
 * Desc: 判断一个链表是否带有环 并求出环的入口
 */
public class ListWithLoop {


    private boolean isLoop(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            //快指针走两步 慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        //如果fast为空或先到达链表尾部则无环
        if (fast == null || fast.next == null) {
            return false;
        }
        return true;
    }

    //a = (n-1)*r + c  a为链表头到环入口距离，r为环一圈长度，b为入口点到相遇点的长度，c=r-b 即从相遇点再到入口点的长度
    //两个指针分别从链表头和相遇点开始每次一步走，会在环入口相遇
    private Node findLoopPort(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        //先判断是否有环
        while (fast != null && fast.next != null) {
            //快指针走两步 慢指针走一步
            fast = fast.next.next;
            slow = slow.next;
            //找到相遇点
            if (fast == slow) {
                break;
            }
        }
        //如果fast为空或先到达链表尾部则无环
        if (fast == null || fast.next == null) {
            return null;
        }
        //slow指针指向链表头，fast指向相遇点，同时移动，每次都各走一步直到相遇
        slow = head;
        while (slow != fast) {
            slow = head.next;
            fast = fast.next;
        }
        return slow;
    }

}
