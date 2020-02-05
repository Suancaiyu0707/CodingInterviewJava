package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 11:26 AM
 * Description: No Description
 * 树的子结构
 */
public class SubstructureInTree {


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

        System.out.println(hasSubtree(root,froot));

    }


    /***
     * 表示从findTree的根节点里开始匹配
     * @param pRoot 子树
     * @param findTree 要查找的目标子树
     * @return
     */
    public static boolean hasSubtree(BinaryTreeNode pRoot,BinaryTreeNode findTree){
        if(pRoot==null){
            return false;
        }
        if(findTree==null){
            return true;
        }
        boolean result = false;
        //如果当前根节点值一样，则比较子节点
        if(pRoot.data==findTree.data){
            result= doesTree1HaveTree2(pRoot,findTree);
        }
        //如果根节点的子树和目标树不匹配，则继续在左子树里查找
        if(!result){
            result=hasSubtree(pRoot.left,findTree);
        }
        //如果左子树里没有，继续在右子树里查找
        if(!result){//继续向左节点遍历，比较根节点
            result=hasSubtree(pRoot.right,findTree);
        }
        return result;
    }

    /***
     * 比较 pRoot1和pRoot2的子节点
     * @param pRoot1 要查找的节点
     * @param pRoot2 被匹配的节点
     * @return
     */
    public static boolean doesTree1HaveTree2(BinaryTreeNode pRoot1, BinaryTreeNode pRoot2){
        if(pRoot2==null){
            return true;
        }
        if(pRoot1==null){
            return false;
        }
        if(pRoot1.data!=pRoot2.data){
            return false;
        }
        boolean leftValid = doesTree1HaveTree2(pRoot1.left,pRoot2.left);
        if(leftValid){
            return doesTree1HaveTree2(pRoot1.right,pRoot2.right);
        }
        return leftValid;
    }
}
