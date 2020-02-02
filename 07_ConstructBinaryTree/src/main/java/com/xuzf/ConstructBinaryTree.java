package com.xuzf;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 8:21 PM
 * Description: No Description
 */
public class ConstructBinaryTree {


    public BinaryTreeNode rebuildBinaryTree( int preorder[], int inorder[] ) {
        if (preorder == null || inorder == null) { //如果前序或者中序有一个是空直接返回
            return null;
        }
        // 定义构建二叉树的核心算法
        BinaryTreeNode root = rebuildBinaryTreeCore(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
        return root;
    }

    // 构建二叉树的核心算法
    public BinaryTreeNode rebuildBinaryTreeCore( int preorder[], int startPreorder,
                                                 int endPreorder, int inorder[], int startInorder, int endInorder ) {
        if (startPreorder > endPreorder || startInorder > endInorder) { //停止递归的条件
            return null;
        }
        //创建一个根节点
        BinaryTreeNode parent = new BinaryTreeNode(preorder[startPreorder]);
        //遍历中序遍历的元素，找到跟当前根节点一样的元素的索引
        for (int i = startInorder; i <= endInorder; i++) {
            if (preorder[startPreorder] == inorder[i]) {
                // 其中（i - startInorder）为中序排序中左子树结点的个数
                int leftTreeNodeCount = i - startInorder;
                //左子树
                parent.left = rebuildBinaryTreeCore(preorder,
                        //这两个下标定义了parent节点下的左子树的节点在前序遍历数组中的索引范围
                        startPreorder + 1, startPreorder + leftTreeNodeCount,
                        inorder,
                        //这两个下标定义了parent节点下的左子树的节点在中序遍历数组中的索引范围
                        startInorder, i - 1);
                //右子树
                parent.right = rebuildBinaryTreeCore(preorder,
                        //这两个下标定义了parent节点下的右子树的节点在数组中的索引范围
                        leftTreeNodeCount + startPreorder + 1, endPreorder,
                        //这两个下标定义了parent节点下的右子树的节点在中序遍历数组中的索引范围
                        inorder,
                        i + 1, endInorder);

            }
        }
        return parent;
    }

    public static void main( String[] args ) {
        ConstructBinaryTree tree = new ConstructBinaryTree();
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode treeNode = tree.rebuildBinaryTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
