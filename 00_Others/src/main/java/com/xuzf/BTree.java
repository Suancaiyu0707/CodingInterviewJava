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

    //结点的平衡因子
    int bf;

    public int level;

    public BTree(int data,BTree left,BTree right){
        this.data=data;

        this.left = left;

        this.right=right;
    }

    public BTree(int data){
        this.data=data;
    }

    public BTree() {
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


    //         p  bf=2
    //     L  bf=1
    // N bf=0
    //以p为根结点做右旋操作
     void rRotate(BTree p){
        BTree l = p.left;
        //将L的右子树变成p的左子树
        p.left = l.right ;
        //将p变成L的右子树
        l.right = p;
        //将根结点替换为L
        p = l;
    }

    /***
     * p
     *     R
     *         N
     * 以P为根结点做左旋操作
     * @param p
     */
     void lRotate(BTree p){
        BTree r = p.right;
        p.right = r.left;
        r.left = p;
        p = r;
    }

    /**
     * 左平衡旋转
     * @param tree
     */
     void leftBalance(BTree tree){
        BTree l = tree.left;
        //检查tree的左子树的平衡度，并作相应的平衡处理
        switch (l.bf){
            case 1:
                //新结点放在tree的左孩子的左子树上，做右旋处理
                tree.bf = l.bf = 0;
                rRotate(tree);
                break;
            case -1:
                //新结点放在tree的左孩子的右子树上，做双旋处理
                BTree lr = l.right;
                //根据右子树的bf修改根结点及左孩子的平衡因子
                switch (lr.bf){
                    case 1:
                        tree.bf = -1;
                        l.bf = 0;
                        break;
                    case 0:
                        tree.bf = l.bf = 0;
                        break;
                    case -1:
                        tree.bf =0;
                        l.bf = 1;
                        break;
                }
                lr.bf = 0;
                //对tree的左子树左旋
                lRotate(l);
                //对tree右旋
                rRotate(tree);
        }
    }

     void rightBalance(BTree tree){
        BTree r = tree.right;
        switch (r.bf){
            case -1:
                //新结点放在tree的右孩子的右子树上，左旋
                tree.bf = r.bf = 0;
                lRotate(tree);
                break;
            case 1:
                //新结点放在tree的右孩子的左子树上，双旋
                BTree rl = r.left;
                switch (rl.bf){
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
                rRotate(r);
                //再对根结点左旋
                lRotate(tree);

        }
    }

    /***
     *
     * @param tree
     * @param e
     * @param taller 标记tree是否长高
     * @return
     */
     boolean insertAVL(BTree tree, int e, boolean taller){
        if (tree==null){
            BTree tree1 = new BTree(e, null, null);
            tree1.bf= 0;
            taller = true;
        }else {
            if (e==tree.data){
                taller =false;
                return false;
            }
            if (e<tree.data){
                //在左子树中递归查找，找到返回false
                if (!insertAVL(tree.left, e, taller)){
                    return false;
                }
                if (taller){
                    switch (tree.bf){
                        case 1:
                            //左平衡旋转 等高
                            leftBalance(tree);
                            taller = false;
                            break;
                        case 0:
                            //左子树比右子树高
                            tree.bf = 1;
                            taller = true;
                            break;
                        case -1:
                            //左右子树等高
                            tree.bf = 0;
                            taller = false;
                            break;
                    }
                }
            } else {
                //在右子树中查找
                if (!insertAVL(tree.right, e, taller)){
                    return false;
                }
                if (taller){
                    switch (tree.bf){
                        case 1:
                            tree.bf = 0;
                            taller = false;
                            break;
                        case 0:
                            tree.bf =-1;
                            taller = true;
                            break;
                        case -1:
                            rightBalance(tree);
                            taller = false;
                            break;
                    }
                }
            }
        }
        return true;
    }
}
