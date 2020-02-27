package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 10:15 PM
 * Description: No Description
 * 查找链表中环的入口结点
 */
public class EntryNodeInListLoop2 {
    public static void main( String[] args ) {
            ListNode head = new ListNode();
            ListNode ln2 = new ListNode();
            ListNode ln3 = new ListNode();
            ListNode ln4 = new ListNode();
            ListNode ln5 = new ListNode();
            ListNode ln6 = new ListNode();
            ListNode ln7 = new ListNode();
            ListNode ln8 = new ListNode();
            ListNode ln9 = new ListNode();
            head.next = ln2;
            ln2.next = ln3;
            ln3.next = ln4;
            ln4.next = ln5;
            ln5.next = ln6;
            ln6.next = ln7;
            ln7.next = ln8;
            ln8.next = ln9;
            ln9.next = ln7;
            head.data = 1;
            ln2.data = 2;
            ln3.data = 3;
            ln4.data = 4;
            ln5.data = 5;
            ln6.data = 6;
            ln7.data = 7;
            ln8.data = 8;
            ln9.data = 9;
        EntryNodeInListLoop2 entryNodeInListLoop = new EntryNodeInListLoop2();
            ListNode node =entryNodeInListLoop.findCycleNode(null);
        System.out.println(node==null?0:node.data);
    }

    /***
     * 获得环中节点的个数
     *
     *  第一轮先找到第一次相遇的节点
     *  第二轮从相遇的节点开始一步步的统计，直到第二次相遇
     * @param head
     * @return
     */
    private int countCycleNode(ListNode head){
        if(head== null||head.next==null){
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        boolean firstMeet = false;
        int count =0;
        while(slow!=null&&fast!=null){
            //如果快慢指针相遇了，则说明有环
            if(slow==fast){
                if(!firstMeet){//如果是第一次相遇，则标记已遇到过一次
                    firstMeet=true;
                }else{//表示第二次相遇，则直接返回这个统计的环数
                    count++;
                    return count;
                }
            }else{//如果没有相遇
                //如果快指针都到末尾了，还没有相遇，那表示无环
                if(firstMeet){
                    count++;
                }else{//如果还没相遇，就暂时不统计
                    //fast每次跳两个节点
                    if(fast.next==null||fast.next.next==null){
                        return 0;
                    }
                }
            }
            slow=slow.next;
            fast=fast.next.next;

        }
        return 0;
    }

    /***
     *
     * @param head
     * @return
     */
    public ListNode findCycleNode(ListNode head){
        if(head==null){
            return null;
        }
        int cycleCount = countCycleNode(head);
        System.out.println("cycleCount="+cycleCount);
        if(cycleCount<=0){
            return null;
        }
        /**
         * 先行的节点
         */
        ListNode firstNode = head;
        //后行的节点
        ListNode lastNode = head;
        for(int i=1;i<=cycleCount;i++){
            firstNode=firstNode.next;
        }

        while(firstNode!=lastNode){
            firstNode=firstNode.next;
            lastNode=lastNode.next;
        }
        return lastNode;
    }


}
