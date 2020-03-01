package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 11:26 AM
 * Description: No Description
 * 树的子结构
 */
public class SubstructureInTree2 {


    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left=node6;
        node5.right=node7;


        BinaryTreeNode froot = new BinaryTreeNode(8);
        BinaryTreeNode fnode1 = new BinaryTreeNode(9);
//        BinaryTreeNode fnode2 = new BinaryTreeNode(2);
        froot.left=fnode1;
//        froot.right=fnode2;
        SubstructureInTree2 substructureInTree = new SubstructureInTree2();
        System.out.println(substructureInTree.hasSubtree(root,froot));

    }

    /***
     * 从树head中查找子树subTree
     * @param head
     * @param subTree
     * @return
     */
    public boolean hasSubtree(BinaryTreeNode head,BinaryTreeNode subTree){
        if(subTree==null){
            return true;
        }
        if(head==null){
            return false;
        }

        boolean result = false;
        if(head.data==subTree.data){
            result = hasSubtreeCore(head,subTree);
        }
        if(!result){//如果根节点不满足，就从左子树里继续从头开始找
            result = hasSubtree(head.left,subTree);
        }
        if(!result){//如果左子树不满足，就从右子树里继续从头开始找
            result = hasSubtree(head.right,subTree);
        }
        return result;
    }

    /***
     * 判断 node和findNode是否匹配
     * @param node
     * @param findNode
     * @return
     */
    public boolean hasSubtreeCore(BinaryTreeNode node,BinaryTreeNode findNode){
        //表示当前的值匹配
        if(findNode==null){
            return true;
        }
        if(node==null){//走到这边说明findNode不为空
            return false;
        }
        boolean result = node.data==findNode.data;
        //如果当前的值匹配了，则继续匹配左右子树了
        if(result){
            return hasSubtreeCore(node.left,findNode.left)&&
                    hasSubtreeCore(node.right,findNode.right);
        }
        return false;
    }
}
