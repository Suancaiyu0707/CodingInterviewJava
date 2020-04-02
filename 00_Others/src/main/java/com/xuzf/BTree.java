package com.xuzf;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

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
    public BTree root;

    //结点的平衡因子
    int bf;
    public int level;

    public static LinkedBlockingQueue<BTree> queue = new LinkedBlockingQueue<>(100);
    public static Stack<BTree> stack = new Stack<>();
    public static Stack<BTree> stack2 = new Stack<>();

    public static ArrayList<Integer> BFSList = new ArrayList<>();
    public static ArrayList<Integer> DFSList = new ArrayList<>();

    public BTree(int data, BTree left, BTree right) {
        this.data = data;

        this.left = left;

        this.right = right;
    }

    public BTree(int data) {
        this.data = data;
    }

    public BTree() {
    }

    public void insert(int val) {
        //从根节点开始比较
        add(root, val);

    }

    /***
     * 平衡二叉树添加一个节点
     * @param val
     */
    public void add(BTree tree, int val) {
        BTree left = tree.left;
        BTree right = tree.right;
        int data = tree.data;

        if (data < val) {
            if (right == null) {
                right = new BTree(val, null, null);
                tree.right = right;
            } else {
                add(right, val);
            }
        } else {
            if (left == null) {
                left = new BTree(val, null, null);
                tree.left = left;
            } else {
                add(left, val);
            }
        }
        return;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    //         p  bf=2
    //     L  bf=1
    // N bf=0
    //以p为根结点做右旋操作
    BTree rRotate(BTree p) {
        BTree l = p.left;
        //将L的右子树变成p的左子树
        p.left = l.right;
        //将p变成L的右子树
        l.right = p;
        //将根结点替换为L
        p = l;
        return p;
    }

    /***
     * p
     *     R
     *         N
     * 以P为根结点做左旋操作
     * @param p
     */
    BTree lRotate(BTree p) {
        BTree r = p.right;
        p.right = r.left;
        r.left = p;
        p = r;
        return p;
    }

    /**
     * 左平衡旋转
     *
     * @param tree
     */
    BTree leftBalance(BTree tree) {
        BTree l = tree.left;
        //检查tree的左子树的平衡度，并作相应的平衡处理
        switch (l.bf) {
            case 1:
                //新结点放在tree的左孩子的左子树上，做右旋处理
                tree.bf = l.bf = 0;
                tree=rRotate(tree);
                break;
            case -1:
                //新结点放在tree的左孩子的右子树上，做双旋处理
                BTree lr = l.right;
                //根据右子树的bf修改根结点及左孩子的平衡因子
                switch (lr.bf) {
                    case 1:
                        tree.bf = -1;
                        l.bf = 0;
                        break;
                    case 0:
                        tree.bf = l.bf = 0;
                        break;
                    case -1:
                        tree.bf = 0;
                        l.bf = 1;
                        break;
                }
                lr.bf = 0;
                //对tree的左子树左旋
                tree.left=lRotate(l);
                //对tree右旋
                tree=rRotate(tree);
        }
        return tree;
    }

    BTree rightBalance(BTree tree) {
        BTree r = tree.right;
        switch (r.bf) {
            case -1:
                //新结点放在tree的右孩子的右子树上，左旋
                tree.bf = r.bf = 0;
                tree = lRotate(tree);
                break;
            case 1:
                //新结点放在tree的右孩子的左子树上，双旋
                BTree rl = r.left;
                switch (rl.bf) {
                    case 1:
                        tree.bf = 0;
                        r.bf = -1;
                        break;
                    case 0:
                        tree.bf = r.bf = 0;
                        break;
                    case -1:
                        tree.bf = 1;
                        r.bf = 0;
                        break;
                }
                //先对tree的右子树右旋
                tree.right=rRotate(r);
                //再对根结点左旋
                tree=lRotate(tree);

        }
        return tree;
    }

    /***
     *
     * @param
     * @param tree
     * @param e
     * @return
     */
    BTree insertAVL(BTree tree, int e, Status status) {
//        BTree left = tree.left;
//        BTree right = tree.right;
        if(tree==null){
            tree=new BTree(e);
            tree.bf=0;
            status.flag=true;
        }else{
            if(e==tree.data){
                status.flag=false;
                return null;
            }
            if(e<tree.data){//应该继续在tree的左子树中继续进行搜索
                BTree left =insertAVL(tree.left,e,status);
                if(left==null){
                    return null;
                }
                tree.left=left;
                if(status.flag){
                    switch (tree.bf) {//判断树原先的平衡因子
                        case 1:
                            //如果树原先的平衡因子是1，再添加一个元素，则这时候需要旋转了
                            //左平衡旋转 等高
                            tree=leftBalance(tree);
                            status.flag=false;
                            break;
                        case 0:
                            //树的平衡因子从0->1，左子树比右子树高，满足平衡因子<=1，所以不旋转
                            tree.bf = 1;
                            status.flag=true;
                            break;
                        case -1:
                            //左右子树等高
                            tree.bf = 0;
                            status.flag=false;
                            break;
                    }
                }
            }else{
                BTree right =insertAVL(tree.right,e,status);
                if(right==null){
                    return null;
                }
                tree.right=right;
                if(status.flag){
                    switch (tree.bf) {
                        case 1://左右子树等高
                            tree.bf = 0;
                            status.flag=false;
                            break;
                        case 0://树的平衡因子从0->-1，左子树比右子树高，满足平衡因子>=-1，所以不旋转
                            tree.bf = -1;
                            status.flag=true;
                            break;
                        case -1://如果树原先的平衡因子是-1，再添加一个元素，则这时候需要旋转了
                            tree=rightBalance(tree);
                            status.flag=false;
                            break;
                    }
                }
            }

        }
        return tree;
    }

    private int height(BTree tree) {
        if (tree != null)
            return tree.bf;

        return 0;
    }

    public int height() {
        return height(root);
    }


    public static void main( String[] args ) {
        int a[]={3,2,1,4,5,6,7,10,9,8};
        BTree bTree = new BTree();
        BTree T=null;

        Status taller=new Status();
        for(int i=0;i<a.length;i++){
            T=bTree.insertAVL(T,a[i],taller);
        }

        System.out.println("T="+T);

        List<Integer> result = new ArrayList<Integer>();
//        middlerBinary(result,tree);
        BinaryTreeNode.middlerBinary(result,T);
        System.out.println("====中序遍历===");
        System.out.println(result);

        List<Integer> result2 = new ArrayList <Integer>();
//        preBinary(result2,tree);
        BinaryTreeNode.preBinary(result2,T);
        System.out.println("====前序遍历===");
        System.out.println(result2);

        List<Integer> result3 = new ArrayList <Integer>();
//        postBinary(result3,tree);

        BinaryTreeNode.postBinary(result3,T);
        System.out.println("====后序遍历===");
        System.out.println(result3);

        System.out.println("====广度优先遍历===");
        BFS(T);
        System.out.println(BFSList);
        System.out.println("====深度优先遍历===");
        DFS(T);
        System.out.println(DFSList);

        List<Integer> list = new ArrayList<>();
        inOrder(list, T);
        System.out.println("====中序遍历（非递归）===");
        System.out.println(list);

        List<Integer> postOrderList = new ArrayList<>();
        postOrder(postOrderList, T);
        System.out.println("====后序遍历（非递归）===");
        System.out.println(postOrderList);

    }

    /**
     * 广度优先遍历 层次遍历 利用队列先进先出
     * @param root
     */
    static void BFS(BTree root){
        if (root != null){
           queue.offer(root);
        }
        while (!queue.isEmpty()){
            BTree bTree = null;
            try {
                bTree = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            BFSList.add(bTree.data);
            if (bTree.left != null){
                queue.offer(bTree.left);
            }
            if (bTree.right != null){
                queue.offer(bTree.right);
            }
        }
    }

    /**
     * 深度优先遍历 前序遍历 利用栈后进先出
     * @param root
     */
    static void DFS(BTree root){
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            BTree tree = stack.pop();
            if (tree == null){
                return;
            }
            DFSList.add(tree.data);
            if (tree.right != null){
                stack.push(tree.right);
            }
            if (tree.left != null){
                stack.push(tree.left);
            }
        }
    }

    /**
     * 中序遍历
     * @param list
     * @param root
     */
    static void inOrder(List<Integer> list, BTree root){
        if (root == null){
            return;
        }
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.data);
            root = root.right;
        }
    }

    /**
     * 后序遍历  利用前序遍历 调换左右结点的入栈顺序 弹出改为压入另一个栈
     */
    static void postOrder(List<Integer> list, BTree root){
        if (root != null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
            BTree tree = stack.pop();
            stack2.push(tree);//压入栈2
            if (tree.left != null){
               stack.push(tree.left);
            }
            if (tree.right != null){
                stack.push(tree.right);
            }
        }
        while (!stack2.isEmpty()){
            list.add(stack2.pop().data);
        }
    }
}
