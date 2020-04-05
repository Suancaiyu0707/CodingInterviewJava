package com.xuzf;

/**
 * Author: zhangjianan
 * Date: 2020/4/5 5:08 下午
 * Desc: 二维数组的查找
 */
public class FindInPartiallySortedMatrix3 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},
                          {2,4,9,12},
                          {4,7,10,13},
                          {6,8,11,15}};
        System.out.println(find(matrix, 4, 4, 7));
    }

    static boolean find(int[][] matrix, int rows, int columns, int number) {
        if (rows < 1 || columns < 1) {
            return false;
        }
        int i = 0;
        int j = columns - 1;
        //首先选取数组右上角的数字开始比较
        while (i < rows && j >= 0) {
            if (matrix[i][j] == number) {
                return true;
            } else if (matrix[i][j] > number) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}
