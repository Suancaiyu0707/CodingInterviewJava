package com.xuzf;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 12:02 PM
 * Description: No Description
 * 实现三角形最小路径和
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 *   自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）
 *
 *
 */
public class MinimumTotal {


    public static void main( String[] args ) {
        Integer[][] triangle = new Integer[][]{
                {2},
                {3,4},
                {6,5,7},
                {4,1,8,3}
        };

        System.out.println(minimumTotal(triangle));
    }
    public static int minimumTotal (Integer[][] triangle){
        if (triangle == null || triangle.length == 0){
            return 0;
        }
        int size = triangle.length;
        int dp[][]=new int[size][size];
        //初始化最底层的值
        for(int i=0;i<size;i++){
            dp[size-1][i]=triangle[size-1][i];
        }
        for(int i=size-2;i>=0;i--){
            for(int j =0;j<triangle[i].length;j++){
                dp[i][j]=triangle[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
