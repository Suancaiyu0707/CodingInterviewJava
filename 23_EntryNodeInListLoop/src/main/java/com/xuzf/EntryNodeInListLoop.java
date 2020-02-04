package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/4
 * Time: 10:15 PM
 * Description: No Description
 * 链表中环的入口结点
 */
public class EntryNodeInListLoop {
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
            ln9.next = head;
            head.data = 1;
            ln2.data = 2;
            ln3.data = 3;
            ln4.data = 4;
            ln5.data = 5;
            ln6.data = 6;
            ln7.data = 7;
            ln8.data = 8;
            ln9.data = 9;

            ListNode node =findCycleNode(head);
        System.out.println(node==null?0:node.data);
    }
    /***
     * 链表中环的入口结点
     */
    public static ListNode findCycleNode(ListNode head){
        if(head==null||head.next==null){
            return null;
        }
        //计算环中的节点数
        int cycleNodeNum = cycleNodeCount(head);
        System.out.println(cycleNodeNum);
        if(cycleNodeNum==0){//表示无环
            return null;
        }

        ListNode oneStepNode = head;
        ListNode twoStepNode = head;
        int i =0;
        //先让oneStepNode指针走cycleNodeNum步
        while(i<cycleNodeNum){
            oneStepNode=oneStepNode.next;
            i++;
        }
        while(true){
            if(oneStepNode==twoStepNode){
                break;
            }
            oneStepNode=oneStepNode.next;
            twoStepNode=twoStepNode.next;
        }
        return oneStepNode;
    }

    /***
     * 计算环中有多个节点
     * @param head
     * @return
     */
    public static int cycleNodeCount(ListNode head){
        ListNode oneStepNode = head;
        ListNode twoStepNode = head.next;
        int count =1;
        boolean afterFirstMeet =false;
        /***
         * 走到两个节点重复的情况下，退出循环，并开始计数
         */
        while(twoStepNode.next!=null&&twoStepNode.next.next!=null){
            oneStepNode=oneStepNode.next;
            twoStepNode=twoStepNode.next.next;
            count++;
            if(oneStepNode.data==twoStepNode.data){
                if(afterFirstMeet){//第二次相遇
                    return count;
                }else{//第一次相遇
                    afterFirstMeet=true;
                    count=0;
                }
            }
        }
        return 0;
    }
}
