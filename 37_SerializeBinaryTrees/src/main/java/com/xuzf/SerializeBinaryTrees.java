package com.xuzf;

import javax.swing.tree.TreeNode;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/7
 * Time: 6:16 PM
 * Description: No Description
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 *    一般情况下，需要采用前/后序遍历和中序遍历才能确定一个二叉树，但是其实可以只采用前序遍历（从根结点开始），将空结点(null)输出为一个特殊符号（如“$”），就可以确定一个二叉树了。
 *
 *  　将二叉树序列化为字符串，就是前序遍历的过程，遇见空结点时，序列化为“$”，每个结点间使用逗号分隔开。
 *
 * 　 将字符串反序列化为二叉树，也使用前序遍历，遇见一个新数字(或者$)就建立一个新结点，不过需要注意的是，数字可能不只是个位数字，因此创建了一个全局Int变量index（在字符串上的移动的指针），以便于截取字符串中当前的结点值
 */
public class SerializeBinaryTrees {

    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(6);
        BinaryTreeNode node3 = new BinaryTreeNode(14);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(8);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        BinaryTreeNode node7 = new BinaryTreeNode(16);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left=node6;
        node3.right=node7;
        SerializeBinaryTrees sb= new SerializeBinaryTrees();
        String str = sb.serialize(root);
        System.out.println(str);
        BinaryTreeNode treeNode = sb.deserialize(str);
        System.out.println(treeNode.data);
    }

    String serialize(BinaryTreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node == null) {
            sb.append("$,");
        } else {
            sb.append(node.data + ",");
            sb.append(serialize(node.left));
            sb.append(serialize(node.right));
        }
        return sb.toString();
    }

    int index = 0;


    BinaryTreeNode deserialize( String str) {
        BinaryTreeNode node = null;
        if (str == null || str.length() == 0)
            return node;
        int start = index;
        while (str.charAt(index) != ',')
            index++;
        if (!str.substring(start, index).equals("$")) {
            node = new BinaryTreeNode(Integer.parseInt(str.substring(start, index)));
            index++; // 这条语句位置别放错了
            node.left = deserialize(str);
            node.right = deserialize(str);
        } else {
            index++;
        }
        return node;
    }
}
