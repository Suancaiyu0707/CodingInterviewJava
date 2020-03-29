package com.xuzf;


import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/***
 * 树遍历k
 */
public class TreeErgodic {

    public static void main(String[] args) {
        TreeErgodic treeErgodic = new TreeErgodic();
        LinkedList<Integer> inputs =new LinkedList<Integer>(Arrays.asList(new Integer[]{
                100,3,50,null,null,21,null,null,12,null,9
        }));

        TreeNode node = createTree(inputs);

        System.out.println("前序遍历");
        treeErgodic.preErgodic(node);
        System.out.println("中序遍历");
        treeErgodic.midErgodic(node);
        System.out.println("后序遍历");
        treeErgodic.postErgodic(node);
        System.out.println("广度遍历");
        treeErgodic.rangeErgodic(node);
    }
    /**
     * 前序遍历
     * @param node
     */
    private  void preErgodic(TreeNode node){
        //找到基准线
        if(node==null){
            return ;
        }
        //前序遍历，崩管三七二十一，先输出父节点，再遍历子节点
        //先遍历父节点
        System.out.println(node.getData());
        //再遍历左子树
        preErgodic(node.getLeft());
        //再遍历右子树
        preErgodic(node.getRight());
    }

    /***
     * 后序遍历
     * @param node
     */
    private  void postErgodic(TreeNode node){
        //找到基准线，用来终止递归
        if(node==null){
            return ;
        }
        //先遍历左子树
        postErgodic(node.getLeft());
        //再遍历右子树
        postErgodic(node.getRight());
        //再遍历父节点
        System.out.println(node.getData());
    }

    private void midErgodic(TreeNode node){
        //找到基准线，用来终止递归
        if(node==null) return;
        //先遍历左子树
        midErgodic(node.getLeft());
        //再遍历父节点
        System.out.println(node.getData());
        //再遍历右子树
        midErgodic(node.getRight());
    }

    public static TreeNode createTree(LinkedList<Integer> inputs){
        TreeNode node = null;
        if(inputs.isEmpty()){
            return null;
        }
        //每次弹出一个头元素，判断是否为空节点
        Integer data = inputs.removeFirst();
        if(data != null){//如果节点有值，说明这不是一个空节点
            node = new TreeNode(data);//创建一个新节点
            //设置节点的值
            node.setData(data);
            //设置左节点的值
            node.setLeft(createTree(inputs));
            //设置右节点的值
            node.setRight(createTree(inputs));
        }
        return node;
    }


    public void rangeErgodic(TreeNode node){
        Queue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
        queue.add(node);
        while(true){

            TreeNode treeNode = queue.poll();
            if(treeNode==null){//队列空了，则退出
                break;
            }
            TreeNode left = treeNode.getLeft();
            TreeNode right = treeNode.getRight();
            if(left!=null){
                queue.offer(left) ;
            }
            if(right!=null){
                queue.offer(right) ;
            }
            System.out.println(treeNode.getData());
        }
    }
}
