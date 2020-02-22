package com.xuzf;

import java.util.ArrayList;
import java.util.List;
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
            preOrderErgodicWithFull(left,++currentLevel,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        BinaryTreeNode right = node.right;
        if(right!=null){
            preOrderErgodicWithFull(right,++currentLevel,depth);
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
            inOrderErgodicWithFull(left,++currentLevel,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        result2.add(node);
        System.out.print(node.data+"-->");

        BinaryTreeNode right = node.right;
        if(right!=null){
            inOrderErgodicWithFull(right,++currentLevel,depth);
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
            postOrderErgodicWithFull(node.left,++currentLevel,depth);
        }else if(currentLevel<depth){
            result2.add(BinaryTreeNode.defaultTreeNode());
        }
        if(node.right!=null){
            postOrderErgodicWithFull(node.right,++currentLevel,depth);
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
