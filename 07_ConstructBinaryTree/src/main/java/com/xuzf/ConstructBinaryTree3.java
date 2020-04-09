package com.xuzf;

/**
 * Author: zhangjianan
 * Date: 2020/4/7 3:41 下午
 * Desc: 重建二叉树
 * 根据前序遍历{1,2,4,7,3,5,6,8}和中序遍历{4,7,2,1,5,3,8,6}构建二叉树
 */
public class ConstructBinaryTree3 {

    public static void main(String[] args) {
        int[] preOrder = {1,2,4,7,3,5,6,8};
        int[] inOrder = {4,7,2,1,5,3,8,6};
        System.out.println(construct(preOrder, inOrder));
    }


    static BinaryTreeNode construct(int[] preOrder, int[] inOrder){
        if (preOrder == null || inOrder == null){
            return null;
        }
        //构建二叉树
        BinaryTreeNode binaryTreeNode =
                constructCore(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
        return binaryTreeNode;
    }

    static BinaryTreeNode constructCore(int[] preOrder, int[] inOrder, int startPre, int endPre, int startIn, int endIn){
        //前序遍历的第一个数字是根结点的值
        int rootValue = preOrder[startPre];
        BinaryTreeNode root = new BinaryTreeNode(rootValue);
        if (endPre == startPre){
            return root;
        }

        int count = 0;
        //在中序遍历中找到根结点的值
        for (int i=startIn; i<=endIn; i++){
            if (inOrder[i]==rootValue){
                break;
            }
            //统计左子树结点个数
            count++;
        }

        if (count>0){
            //构建左子树
            root.left = constructCore(preOrder, inOrder, startPre+1, startPre+count, startIn, startIn+count-1);
        }

        if (count<(endPre-startPre)){
            //构建右子树
            root.right = constructCore(preOrder, inOrder, startPre+count+1, endPre, startIn+count+1, endIn);
        }
        return root;
    }
}
