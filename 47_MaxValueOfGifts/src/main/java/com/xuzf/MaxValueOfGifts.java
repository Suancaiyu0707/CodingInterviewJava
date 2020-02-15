package com.xuzf;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/15
 * Time: 3:53 PM
 * Description: No Description
 * 礼物的最大价值
 *
 * 把数字翻译成字符串
 在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，
 并每次向左或者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValueOfGifts {

    public static int [][]result=null;
    public static int rows=0;
    public static int cols=0;
    public static void main( String[] args ) {
        int[][]gifts =new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,16,8},
                {1,10,3,5}
        };
         rows=gifts.length;
         cols= gifts[0].length;

        result = new int[rows][cols];

        for(int i=rows-1;i>=0;i--){
            for(int j=cols-1;j>=0;j--){
                getMaxGifts(gifts,j,i);
            }
        }
        System.out.println(result[0][0]);
    }

    public static void getMaxGifts(int[][]gifts,int col,int row){
        if(row==rows-1&&col==cols-1){
            result[row][col]=gifts[row][col];
            return;
        }
        if(row==rows-1){//如果是最后一行
            result[row][col]=result[col+1][row]+gifts[row][col];
            return;
        }
        if(col==cols-1){//如果是最后一列
            result[row][col]=result[col][row+1]+gifts[row][col];
            return;
        }
        result[row][col]=Math.max(result[col+1][row],result[col][row+1])+gifts[row][col];
    }
}
