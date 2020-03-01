package com.xuzf;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 11:07 PM
 * Description: No Description
 * 实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推
 */
public class PrintTreesInZigzag2 {
    public static void main( String[] args ) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(7);
        BinaryTreeNode node4 = new BinaryTreeNode(9);
        BinaryTreeNode node5 = new BinaryTreeNode(2);
        BinaryTreeNode node6 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left=node6;
        node5.right=node7;
        PrintTreesInZigzag2 printTreesInZigzag = new PrintTreesInZigzag2();
        printTreesInZigzag.printTree(root);

        System.out.println("{\\\"took\\\":23,\\\"timed_out\\\":false,\\\"_shards\\\":{\\\"total\\\":200,\\\"successful\\\":200,\\\"skipped\\\":195,\\\"failed\\\":0},\\\"hits\\\":{\\\"total\\\":727,\\\"max_score\\\":0.0,\\\"hits\\\":[]},\\\"aggregations\\\":{\\\"DV\\\":{\\\"value\\\":61},\\\"app_id_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":8,\\\"buckets\\\":[{\\\"key\\\":\\\"10639\\\",\\\"doc_count\\\":176,\\\"DV\\\":{\\\"value\\\":9},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"teacher\\\",\\\"doc_count\\\":129,\\\"UV\\\":{\\\"value\\\":10}},{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":47,\\\"UV\\\":{\\\"value\\\":5}}]},\\\"LV\\\":{\\\"value\\\":15}},{\\\"key\\\":\\\"10173\\\",\\\"doc_count\\\":69,\\\"DV\\\":{\\\"value\\\":4},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"teacher\\\",\\\"doc_count\\\":40,\\\"UV\\\":{\\\"value\\\":3}},{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":29,\\\"UV\\\":{\\\"value\\\":2}}]},\\\"LV\\\":{\\\"value\\\":5}},{\\\"key\\\":\\\"120\\\",\\\"doc_count\\\":31,\\\"DV\\\":{\\\"value\\\":2},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":31,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":3}},{\\\"key\\\":\\\"740\\\",\\\"doc_count\\\":25,\\\"DV\\\":{\\\"value\\\":5},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":25,\\\"UV\\\":{\\\"value\\\":3}}]},\\\"LV\\\":{\\\"value\\\":1}},{\\\"key\\\":\\\"710\\\",\\\"doc_count\\\":10,\\\"DV\\\":{\\\"value\\\":1},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":10,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":2}},{\\\"key\\\":\\\"730\\\",\\\"doc_count\\\":6,\\\"DV\\\":{\\\"value\\\":1},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":6,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":2}},{\\\"key\\\":\\\"11040\\\",\\\"doc_count\\\":5,\\\"DV\\\":{\\\"value\\\":1},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"preview\\\",\\\"doc_count\\\":5,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":1}},{\\\"key\\\":\\\"111\\\",\\\"doc_count\\\":5,\\\"DV\\\":{\\\"value\\\":5},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":5,\\\"UV\\\":{\\\"value\\\":5}}]},\\\"LV\\\":{\\\"value\\\":5}},{\\\"key\\\":\\\"140\\\",\\\"doc_count\\\":5,\\\"DV\\\":{\\\"value\\\":1},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":5,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":2}},{\\\"key\\\":\\\"513\\\",\\\"doc_count\\\":5,\\\"DV\\\":{\\\"value\\\":1},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"preview\\\",\\\"doc_count\\\":3,\\\"UV\\\":{\\\"value\\\":1}},{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":2,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":1}}]},\\\"role_stat\\\":{\\\"doc_count_error_upper_bound\\\":0,\\\"sum_other_doc_count\\\":0,\\\"buckets\\\":[{\\\"key\\\":\\\"student\\\",\\\"doc_count\\\":311,\\\"UV\\\":{\\\"value\\\":20}},{\\\"key\\\":\\\"teacher\\\",\\\"doc_count\\\":263,\\\"UV\\\":{\\\"value\\\":14}},{\\\"key\\\":\\\"preview\\\",\\\"doc_count\\\":143,\\\"UV\\\":{\\\"value\\\":4}},{\\\"key\\\":\\\"replay\\\",\\\"doc_count\\\":10,\\\"UV\\\":{\\\"value\\\":1}}]},\\\"LV\\\":{\\\"value\\\":36}}}".length());
    }
    public  void printTree(BinaryTreeNode root){
        if(root==null){
            return ;
        }
        Stack<BinaryTreeNode> stackFromLeft = new Stack <BinaryTreeNode>();
        Stack<BinaryTreeNode> stackFromRight = new Stack <BinaryTreeNode>();
        BinaryTreeNode node = null;
        stackFromLeft.push(root);
        while (!stackFromLeft.isEmpty()||!stackFromRight.isEmpty()){
            while(!stackFromLeft.isEmpty()){
                node=stackFromLeft.pop();
                System.out.print(node.data+" ");
                if(node.left!=null){
                    stackFromRight.add(node.left) ;
                }
                if(node.right!=null){
                    stackFromRight.add(node.right) ;
                }
            }
            System.out.println();
            while(!stackFromRight.isEmpty()){
                node = stackFromRight.pop();
                System.out.print(node.data+" ");
                if(node.right!=null){
                    stackFromLeft.add(node.right) ;
                }
                if(node.left!=null){
                    stackFromLeft.add(node.left) ;
                }

            }
            System.out.println();
        }
    }


}
