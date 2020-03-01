package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 9:24 PM
 * Description: No Description
 *  中序遍历的下一个节点
 */
public class NextNodeInBinaryTrees2 {
    /***
     * 从一个树里，获得目标节点的下一个节点
     * @param target
     * @return
     */
    public TreeLinkNode getNext(TreeLinkNode target) {
        if(target==null){
            return null;
        }
        TreeLinkNode parent = target.parent;

        //如果当前节是一个右子节点且当前节点有右子树，那么就在右子树里找第一个出现的节点
        if(target.right!=null){
            TreeLinkNode pre = target.right;
            //如果有左子节点
            while(pre.left!=null){
                pre=pre.left;
            }
            return pre;
        }
        //走到这里表明它没有右子树，也就是说，需要一直往上遍历，找到第一个出现当前子树是作为左子树
        while(target.parent!=null){
            if(target.parent.left==target){
                return parent;
            }
            target=target.parent;
        }
        return null;
    }

    //创建树较为繁琐，未包括所有测试代码。
    public void test1() {
        TreeLinkNode node = null;
        TreeLinkNode nextNode = getNext(node);
        if(nextNode!=null)
            System.out.println(nextNode.val);
        else
            System.out.println("无下一结点");
    }

    public void test2() {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.parent = node1;
        node3.parent = node1;
        node3.right=node4;
        node4.parent=node3;
        TreeLinkNode nextNodeOf1=getNext(node1);
        TreeLinkNode nextNodeOf2=getNext(node2);
        TreeLinkNode nextNodeOf3=getNext(node3);
        TreeLinkNode nextNodeOf4=getNext(node4);
        if(nextNodeOf1!=null)
            System.out.println("1结点的下一个结点值为："+nextNodeOf1.val);
        else
            System.out.println("1结点无下一结点");
        if(nextNodeOf2!=null)
            System.out.println("2结点的下一个结点值为："+nextNodeOf2.val);
        else
            System.out.println("2结点无下一结点");
        if(nextNodeOf3!=null)
            System.out.println("3结点的下一个结点值为："+nextNodeOf3.val);
        else
            System.out.println("3结点无下一结点");
        if(nextNodeOf4!=null)
            System.out.println("4结点的下一个结点值为："+nextNodeOf4.val);
        else
            System.out.println("4结点无下一结点");
    }

    public static void main(String[] args) {
        NextNodeInBinaryTrees2 demo = new NextNodeInBinaryTrees2();
        System.out.print("test1:");
        demo.test1();
        System.out.print("test2:");
        demo.test2();
    }

}
