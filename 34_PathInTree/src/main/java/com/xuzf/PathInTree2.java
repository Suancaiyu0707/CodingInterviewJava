package com.xuzf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 11:05 AM
 * Description: No Description
 * 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree2 {

    private static List<Integer> list = new ArrayList<>();

    private static Stack<BinaryTreeNode> stack = new Stack <>();
    private static  int dest=0;
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        dest=22;
        PathInTree2 path=new PathInTree2();
        path.pathInTree(root,22);
    }

    /****
     * 根据前序遍历遍历二叉树
     * @param root 当前树的根节点
     * @param dest 当前树里要查找路径总和
     */
    public  void pathInTree(BinaryTreeNode root,int dest){

        if(root==null){
            return;
        }
        stack.add(root);
        int data = root.data;
        //如果当前节点的值大于要查找的路径总和，那么只要经过该节点data的路径也就没有继续往下遍历了
        if(data>dest){
            stack.pop();
            return ;
        }
        //如果当前节点是叶子节点
        if(root.left==null&&root.right==null){
            //如果当前节点是叶子节点
            if(data==dest){//找到目标对象
                List<BinaryTreeNode> result = stack.subList(0,stack.size());
                for(int i=0;i<result.size();i++){
                    System.out.print(result.get(i).data+" ");
                }
                System.out.println();

            }
        }else{//如果当前节点不是叶子节点
            //检查左子树
            if(root.left!=null) {
                pathInTree(root.left, dest - data);
            }
            if(root.right!=null){
                pathInTree(root.right,dest-data);
            }
        }
        //检查完当前子树的话，要把根节点弹出
        stack.pop();


    }
}
