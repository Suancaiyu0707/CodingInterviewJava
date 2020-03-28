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
}
