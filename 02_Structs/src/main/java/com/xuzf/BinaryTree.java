package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/29
 * Time: 10:57 AM
 * Description: No Description
 * 二叉树的操作
 */
public class BinaryTree {
    /***
     * 在二叉树查找指定元素
     * @param head
     * @param key
     */
    public BinaryTreeNode searchBST(BinaryTreeNode head,int key){
        if(head==null){
            return null;
        }
        BinaryTreeNode result = null;
        if(head.data==key){
            return head;
        }
        result= searchBST(head.left,key);
        if(result==null){
            return searchBST(head.right,key);
        }
        return result;
    }

    /***
     * 往二叉树里添加节点
     * @param head 二叉树
     * @param key 目标节点
     * @return
     */
    public Boolean addNode(BinaryTreeNode head,int key){
        if(head==null){
            head= new BinaryTreeNode(key);
            return true;
        }
        return insertBST(head,key);
    }

    /***
     * 插入一个元素
     * @param node
     * @param key
     */
    public boolean insertBST(BinaryTreeNode node,int key){
        //如果当前节点和插入的值相等，则返回false
        if(node.data==key){
            return false;
        }
        //如果当前节点的值小于目标值，则在右子树里插入
        if(node.data<key){
            if(node.right==null){
                node.right=new BinaryTreeNode(key);
                return true;
            }
            insertBST(node.right,key);
        }
        //如果当前节点的值大于目标值，则在左子树里插入
        if(node.data>key){
            if(node.left==null){
                node.left=new BinaryTreeNode(key);
                return true;
            }
            insertBST(node.left,key);
        }
        return false;
    }

    public boolean deleteBST(BinaryTreeNode parent,BinaryTreeNode node,int key){
        if(node==null){
            return false;
        }
        boolean result = false;
        //找到要删除的节点
        if(node.data==key){
            deletNode(parent,node);
            return true;
        }
        //检查左子树里是否右目标节点
        result= deleteBST(node,node.left,key);
        if(!result){
            //检查右子树里是否右目标节点
            result=deleteBST(node,node.right,key);
        }
        return result;
    }

    /**
     * 找到对应的待删除的节点node
     * @param parent 待删除节点的父节点
     * @param node 待删除节点
     * @return
     */
    public void deletNode(BinaryTreeNode parent,BinaryTreeNode node){
        BinaryTreeNode left = node.left;

        BinaryTreeNode right = node.right;
        //如果删除的是叶子节点
        if(left==null&&right==null){
            adjustParent(parent,node,null);
        }
        //如果删除的节点只有右子树，则右子树直接作为parent的子节点
        if(left==null){
            adjustParent(parent,node,right);
        }
        //如果删除的节点只有左子树，则左子树直接作为parent的子节点
        if(right==null){
            adjustParent(parent,node,left);
        }
        //如果删除的节点左右子树都有
        if(right.left==null){
            adjustParent(parent,node,right);
            right.left=left;
        }else{
            BinaryTreeNode minNodeFromRight = findMinNodeFromRight(right,right.left);
            adjustParent(parent,node,minNodeFromRight);
            minNodeFromRight.right=right;
            minNodeFromRight.left=left;


        }
    }

    /**
     * 在右子树里查找最小的节点
     * @param parent
     * @param left
     * @return
     */
    public BinaryTreeNode findMinNodeFromRight(BinaryTreeNode parent,BinaryTreeNode left){
        //如果当前节点没有左子节点，那么当前节点肯定是右子树里最小的
        if(left.left==null){
            //当当前节点的右子节点设置为父节点的左子节点
            parent.left=left.right;
            left.right=null;
            return left;
        }else{
            findMinNodeFromRight(left,left.left);
        }
        return null;
    }
    public void adjustParent(BinaryTreeNode parent,BinaryTreeNode node,BinaryTreeNode dest){
        if(parent==null){
            return;
        }
        if(parent.left==node){
            parent.left=dest;
        }
        if(parent.right==node){
            parent.right=dest;
        }
    }
}
