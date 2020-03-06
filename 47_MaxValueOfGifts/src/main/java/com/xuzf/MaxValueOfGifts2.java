package com.xuzf;

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
public class MaxValueOfGifts2 {

    public static int [][]result=null;
    public static int rows=0;
    public static int cols=0;
    public static void main( String[] args ) {
        int[][]gifts =new int[][]{
                {1,10,3,8},
                {12,2,9,6},
                {5,7,16,8},
                {1,10,3,5}
        };//1 12 5 7 16 8 5
         rows=gifts.length;
         cols= gifts[0].length;

        result = new int[rows][cols];
        MaxValueOfGifts2 maxValueOfGifts = new MaxValueOfGifts2();
        maxValueOfGifts.getMaxGifts(gifts,rows,cols);

        System.out.println(result[0][0]);
    }

    /***
     *
     * @param gifts
     * @param col
     * @param row
     */
    public void getMaxGifts(int[][]gifts,int row,int col){
        //列
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1&&j==col-1){
                    result[i][j]=gifts[i][j];
                    continue;
                }
                if(i==row-1){//如果是最后一行的话
                    result[i][j]=result[i][j+1]+gifts[i][j];
                    continue;
                }
                if(j==col-1){//如果是最后一列的话
                    result[i][j]=result[i+1][j]+gifts[i][j];
                    continue;
                }
                result[i][j]= Math.max(result[i+1][j],result[i][j+1])+gifts[i][j];
            }
        }
    }
}
