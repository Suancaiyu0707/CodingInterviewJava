package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 10:49 PM
 * Description: No Description
 * 删除一个顺序列表中重复的元素
 */
public class DeleteDuplicatedNode2 {


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
        DeleteDuplicatedNode2 duplicatedNode=new DeleteDuplicatedNode2();
        duplicatedNode.deleteDuplicatedNode(head);
        System.out.println(head.next);
    }

    /***
     * 删除重复的节点
     * @param head
     */
    public void deleteDuplicatedNode(ListNode head){
        if(head==null){
            return;
        }
        ListNode pre=head;
        ListNode current=head;
        //如果当前节点跟下一个节点相等
        ListNode dupliNode = null;
        while(true){
            if(current==null){//遍历到最后一个
                pre.next=null;
                return;
            }
            if(dupliNode!=null&&current.data==dupliNode.data){
                current=current.next;
                continue;
            }
            dupliNode=null;
            //如果前序还没因为重复被删掉
            if(current.next!=null&&current.data==current.next.data){
                dupliNode=current;
                current=current.next.next;
            }else{//如果当前元素跟next不一致，则pre为当前节点
                if(pre!=null){
                    pre.next=current;
                }
                pre=current;
                current=current.next;

            }
        }

    }
}
