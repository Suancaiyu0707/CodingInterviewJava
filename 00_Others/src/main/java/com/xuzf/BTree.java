package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/25
 * Time: 4:03 PM
 * Description: No Description
 */
public class BTree {
    public int data;
    public BTree left;
    public BTree right;
    public  BTree root;

    public int level;

    public BTree(int data,BTree left,BTree right){
        this.data=data;

        this.left = left;

        this.right=right;
    }

    public BTree(int data){
        this.data=data;
    }

    public  void insert(int val){
        //从根节点开始比较
        add(root,val);

    }
    /***
     * 平衡二叉树添加一个节点
     * @param val
     */
    public  void add(BTree tree,int val){
        BTree left = tree.left;
        BTree right = tree.right;
        int data= tree.data;

        if(data<val){
            if(right==null){
                right = new BTree(val,null,null);
                tree.right=right;
            }else{
                add(right,val);
            }
        }else{
            if(left==null){
                left = new BTree(val,null,null);
                tree.left=left;
            }else{
                add(left,val);
            }
        }
        return ;

    }

    public int getLevel() {
        return level;
    }

    public void setLevel( int level ) {
        this.level = level;
    }
}
