package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 11:24 AM
 * Description: No Description
 */
public class FindInPartiallySortedMatrix {

    public static void main( String[] args ) {
        Integer matrix[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(findNumber(matrix,4,4,6));

    }

    /***
     *
     * @param matrix
     * @param columns 总的列数
     * @param rows 总的行数
     * @param number 要查找的数值
     * @return
     */
    public static boolean findNumber(Integer matrix[][],int columns,int rows,int number){
        int row  =1;
        int column=columns;

        for(;;){
            if(column<1){
                return false;
            }
            if(row>rows){
                return false;
            }
            int data =matrix[row-1][column-1];
            if(data==number){
                return true;
            }
            if(data>number){//如果当前值比目标值大，向里缩一列
                column--;
            }
            if(data<number){//如果当前值比目标值小，向下进一行
                row++;
            }
        }
    }
}
