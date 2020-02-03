package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 10:49 PM
 * Description: No Description
 * 删除一个顺序列表中重复的元素
 */
public class DeleteDuplicatedNode {


    public static void main( String[] args ) {
        ListNode head = new ListNode();
        ListNode ln2 = new ListNode();
        ListNode ln3 = new ListNode();
        ListNode ln4 = new ListNode();
        ListNode ln5 = new ListNode();
        ListNode ln6 = new ListNode();
        ListNode ln7 = new ListNode();
        ListNode ln8 = new ListNode();
        head.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;
        ln5.next = ln6;
        ln6.next = ln7;
        ln7.next = ln8;
        ln8.next = null;
        head.data = 2;
        ln2.data = 2;
        ln3.data = 2;
        ln4.data = 4;
        ln5.data = 5;
        ln6.data = 7;
        ln7.data = 7;
        ln8.data = 8;
        deleteDuplicatedNode(head);
        System.out.println(head);
    }
    public static void deleteDuplicatedNode(ListNode head){
        ListNode preNode = null;
        ListNode curNode = null;
        //如果当前遍历的前一个相邻的节点因为重复被删除了，则记录前一个被删除的节点，避免后面的元素和前面已删除的节点重复
        ListNode duplicatedNode = null;
        if(head==null||head.next==null){
            return ;
        }
        curNode=head;
        while(curNode.next!=null){
            //如果当前节点和下一个节点重复,直接删掉重复节点，并记录当前删除的重复节点
            if( curNode.data == curNode.next.data){
                if(preNode==null){
                    head=curNode.next.next;
                }else{
                    preNode.next=curNode.next.next;
                }
                duplicatedNode=curNode;
                if(curNode.next.next!=null){
                    curNode=curNode.next.next;
                }

            }else if(duplicatedNode!=null&&curNode.data==duplicatedNode.data){//直接删除就好(连续三个重复的时候，)
                if(preNode==null){
                    head=curNode.next;
                }else{
                    preNode.next=curNode.next;
                }
                curNode=curNode.next;
            }else{//如果当前的节点和下一个节点不重复，也和上一个节点不重复，则继续向下遍历
                duplicatedNode=null;
                preNode=curNode;
                curNode=curNode.next;
            }
        }
    }
}
