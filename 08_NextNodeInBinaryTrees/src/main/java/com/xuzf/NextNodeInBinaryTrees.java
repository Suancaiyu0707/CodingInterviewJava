package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 9:24 PM
 * Description: No Description
 *  中序遍历的下一个节点
 */
public class NextNodeInBinaryTrees {
    private class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode parent = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            System.out.print("结点为null ");
            return null;
        }
        //如果当前节点有右子树，那么下一个节点就是它的右子树中的最左子节点
        if (pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left!=null)
                pNode=pNode.left;
            return pNode;
        }
        //如果当前节点没有右子树，且存在父节点
        while(pNode.parent !=null){
            //如果当前节点是父节点的左节点，则下一个节点就是其父节点
            if(pNode==pNode.parent.left){
                return pNode.parent;
            }else{//如果当前节点是父节点的右节点，则沿着父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点
                pNode=pNode.parent;
            }
        }
        return null;
    }

    //创建树较为繁琐，未包括所有测试代码。
    public void test1() {
        TreeLinkNode node = null;
        TreeLinkNode nextNode = GetNext(node);
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
        node4.left=node1;
        node1.parent=node4;
        TreeLinkNode nextNodeOf1=GetNext(node1);
        TreeLinkNode nextNodeOf2=GetNext(node2);
        TreeLinkNode nextNodeOf3=GetNext(node3);
        TreeLinkNode nextNodeOf4=GetNext(node4);
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
        NextNodeInBinaryTrees demo = new NextNodeInBinaryTrees();
        System.out.print("test1:");
        demo.test1();
        System.out.print("test2:");
        demo.test2();
    }

}
