package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 8:26 PM
 * Description: No Description
 */
public class BinaryTreeNode {
    public int data;

    public BinaryTreeNode left;

    public BinaryTreeNode right;

    public BinaryTreeNode(int data){
        this.data=data;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
