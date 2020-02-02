package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 8:23 PM
 * Description: No Description
 */
public class BinaryTree {
    public void ConnectTreeNodes(BinaryTreeNode pParent,
                                 BinaryTreeNode pLeft,
                                 BinaryTreeNode pRight){
        if(pParent != null){
            pParent.left = pLeft;
            pParent.right = pRight;
        }
    }

    public void PrintTreeNode(BinaryTreeNode pNode){
        if(pNode != null){
            System.out.printf("value of this node is: %d\n", pNode.data);
            BinaryTreeNode left = pNode.left;
            if(left!=null) {
                System.out.printf("value of its left child is: %d.\n", left.data);
            }else {
                System.out.printf("left child is nullptr.\n");
            }
            BinaryTreeNode right = pNode.right;
            if(right!=null) {
                System.out.printf("value of its left child is: %d.\n", right.data);
            }else {
                System.out.printf("right child is nullptr.\n");
            }
        }else{
            System.out.printf("this node is nullptr.\n");
        }
        System.out.printf("\n");
    }


    public void PrintTree( BinaryTreeNode pRoot) {
        PrintTreeNode(pRoot);

        if(pRoot != null)
        {
            if(pRoot.left != null) {
                PrintTree(pRoot.left);
            }
            if(pRoot.right != null) {
                PrintTree(pRoot.right);
            }
        }
    }

    public void DestroyTree(BinaryTreeNode pRoot)
    {
        if(pRoot != null)
        {
            BinaryTreeNode pLeft = pRoot.left;
            BinaryTreeNode pRight = pRoot.right;
            pRoot = null;
            DestroyTree(pLeft);
            DestroyTree(pRight);
        }
    }
}
