package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/3/27
 * Time: 1:49 PM
 * Description: No Description
 */
public class TreeNode {
    public int data;
    public int height;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int element){
        this(element,null,null);
    }
    public TreeNode(int element,TreeNode left,TreeNode right){
        this.data=element;
        this.left=left;
        this.right=right;
        this.height=0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
