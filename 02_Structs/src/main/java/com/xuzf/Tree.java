package com.xuzf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/22
 * Time: 11:13 AM
 * Description: No Description
 * 树结构的遍历和其它操作
 */
public class Tree {

    static List<BinaryTreeNode> result = new ArrayList<>();
    /***
     * 包含为空的节点，当成遍历一个满二叉树，所以对于空的会用默认值来代替
     */
    static List<BinaryTreeNode> result2  =new ArrayList <>();
    /***
     * 用于做广度遍历
     */
    static LinkedBlockingDeque<BinaryTreeNode> queue=new LinkedBlockingDeque <>();

    /***
     *
     *         10
     *    5           12
     * 4     7           13
     * @param args
     */
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        BinaryTreeNode node6 = new BinaryTreeNode(13);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
//        node3.right=node6;
        preOrderErgodic(root);
        System.out.println();
        preOrderErgodicWithFull(root,1,3);
        System.out.println();
        preOrderErgodicWithStack(root);
        System.out.println();
        inOrderErgodic(root);
        System.out.println();
        inOrderErgodicWithFull(root,1,3);
        System.out.println();
        postOrderErgodic(root);
        System.out.println();
        postOrderErgodicWithFull(root,1,3);


    }



    /***
     * 前序遍历
     * 父节点-->左子树-->右子树
     */
    public static void preOrderErgodic(BinaryTreeNode node){
        if(node==null){
            return;
        }
        result.add(node);
        System.out.print(node.data+"-->");
        BinaryTreeNode left = node.left;
        if(left!=null){
            preOrderErgodic(left);
        }
        BinaryTreeNode right = node.right;
        if(right!=null){
            preOrderErgodic(right);
        }
    }

    /***
     * 前序遍历-利用栈
     * 父节点-->左子树-->右子树
     */
    public static void preOrderErgodicWithStack(BinaryTreeNode node){
        Stack<BinaryTreeNode> s= new Stack <>();
        /***
         * 判断当前节点不为空，如果当前节点为空，则从栈中弹出父节点，去查看兄弟节点(父节点的右节点)
         */
        while(node!=null||!s.isEmpty()){
            if(node!=null){//如果当前节点不为空，则继续判断当前节点的左节点
                System.out.print(node.data+"-->");
                s.add(node);
                node=node.left;
            }else {//如果当前节点为空，则从栈中弹出当前节点的父节点
                node=s.pop();//从栈中弹出当前节点的父节点
                node=node.right;//获得右节点
            }


        }
    }

    /**
     * 当作一个满二叉树来遍历--前序遍历
     * 父节点-->左子树-->右子树
     * @param node
     * @param currentLevel 当前的高度
     * @param depth 树的高度
     */
    public static void preOrderErgodicWithFull(BinaryTreeNode node,int currentLevel,int depth){
        if(node==null){
            return;
        }
        result2.add(node);
        System.out.print(node.data+"-->");
        BinaryTreeNode left = node.left;
        if(left!=null){
            preOrderErgodicWithFull(left,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        BinaryTreeNode right = node.right;
        if(right!=null){
            preOrderErgodicWithFull(right,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
    }

    /***
     * 中序遍历
     * 左子树-->父节点-->右子树
     */
    public static void inOrderErgodic(BinaryTreeNode node){
        if(node==null){
            return ;
        }
        if(node.left!=null){
            inOrderErgodic(node.left);
        }
        result.add(node);
        System.out.print(node.data+"-->");
        if(node.right!=null){
            inOrderErgodic(node.right);
        }

    }

    /**
     * 当作一个满二叉树来遍历-中序遍历
     * 左子树-->父节点-->右子树
     * @param node
     * @param currentLevel 当前的高度
     * @param depth 树的高度
     */
    public static void inOrderErgodicWithFull(BinaryTreeNode node,int currentLevel,int depth){
        if(node==null){
            return;
        }

        BinaryTreeNode left = node.left;
        if(left!=null){
            inOrderErgodicWithFull(left,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        result2.add(node);
        System.out.print(node.data+"-->");

        BinaryTreeNode right = node.right;
        if(right!=null){
            inOrderErgodicWithFull(right,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
    }


    /***
     * 后序遍历
     * 左子树-->右子树-->父节点
     */
    public static void postOrderErgodic(BinaryTreeNode node){
        if(node==null){
            return;
        }

        if(node.left!=null){
            postOrderErgodic(node.left);
        }
        if(node.right!=null){
            postOrderErgodic(node.right);
        }
        result.add(node);
        System.out.print(node.data+"-->");
    }

    /***
     * 当作一个满二叉树来遍历--后序遍历
     * 左子树-->右子树-->父节点
     * @param node
     * @param currentLevel
     * @param depth
     */
    public static void postOrderErgodicWithFull(BinaryTreeNode node,int currentLevel,int depth){
        if(node==null){
            return;
        }

        if(node.left!=null){
            postOrderErgodicWithFull(node.left,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        if(node.right!=null){
            postOrderErgodicWithFull(node.right,currentLevel+1,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        result2.add(node);
        System.out.print(node.data+"-->");
    }

    /**
     * 广度优先遍历
     * 借助于队列的先进先出
     */
    public static void BFS(BinaryTreeNode node) throws InterruptedException {
        if(node==null){
            return;
        }
        queue.add(node);
        while(!queue.isEmpty()){
            BinaryTreeNode current = queue.take();
            if(current.left!=null){
                queue.add(current.left);
            }
            if(current.right!=null){
                queue.add(current.right);
            }
            System.out.print(current.data+"-->");
        }
    }
}
