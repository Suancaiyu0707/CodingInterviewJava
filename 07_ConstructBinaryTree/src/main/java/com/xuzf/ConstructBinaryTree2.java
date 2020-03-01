package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 8:21 PM
 * Description: No Description
 */
public class ConstructBinaryTree2 {


    public BinaryTreeNode rebuildBinaryTree( int preorder[], int inorder[] ) {
        if (preorder == null || inorder == null) { //如果前序或者中序有一个是空直接返回
            return null;
        }

        BinaryTreeNode node= contructBinaryTree(preorder,0,preorder.length-1,
                                    inorder,0,inorder.length-1);

        return node;

    }

    /**
     * 返回一个子树
     * @param preOrder 前序数组
     * @param inOrder 中序数组
     * @param preBegin 前序子数组的开始位置
     * @param preEnd 前序子数组的结束位置
     * @param inBegin 中序子数组的开始位置
     * @param inEnd 中序子数组的结束位置
     * @return
     */
    public BinaryTreeNode contructBinaryTree(int preOrder[], int preBegin,int preEnd,
                                             int inOrder[],int inBegin,int inEnd){
        //获得当前节点的值
        int data= preOrder[preBegin];
        int count=0;
        BinaryTreeNode currentNode = new BinaryTreeNode(data);
        if(preEnd==preBegin){
            return currentNode;
        }

        for(int i=inBegin;i<=inEnd;i++){
            if(inOrder[i]==data){
                break;
            }
            count++;
        }
        //没有左子节点
        if (count>0){
            currentNode.left=contructBinaryTree(preOrder,preBegin+1,preBegin+count,
                                    inOrder,inBegin,inBegin+count-1);
        }
        if(count<(preEnd-preBegin)){//没有右子节点
            currentNode.right=contructBinaryTree(preOrder,preBegin+count+1,preEnd,
                    inOrder,inBegin+count+1,inEnd);
        }
        return currentNode;
    }


    public static void main( String[] args ) {
        ConstructBinaryTree2 tree = new ConstructBinaryTree2();
        int preorder[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int inorder[] = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode treeNode = tree.rebuildBinaryTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
