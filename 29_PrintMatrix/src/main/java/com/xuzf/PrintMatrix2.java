package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/5
 * Time: 5:30 PM
 * Description: No Description
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 思路
 * 　　每次打印矩阵最外面的一圈（用方法printMatrixInCircle()表示），每次都是这个操作，所以可以采用递归。每次打印矩阵的左上角的横纵坐标相同，即为start，而其余三个角的坐标都与行列数以及start有关，因此只需要for循环即可实现打印。
 *
 * 　　当然，其实只要针对start进行循环判断，start*2的值小于行数和列数时才需要继续打印，这样，通过这个条件，可以用循环来打印每次的最外圈矩阵。
 */
public class PrintMatrix2 {

    public static void main( String[] args ) {
        int[][] a= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        int[][] a2= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};
        PrintMatrix2 printMatrix = new PrintMatrix2();
        printMatrix.printMatrixInCircle(a,4,4);
        System.out.println();
        printMatrix.printMatrixInCircle(a2,4,3);
        printMatrix.printMatrixInCircle(null,0,0);
    }
    /***
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     * @param matrix 矩阵，当前环的开始横坐标
     * @param cols 列数(也就是长)
     * @param rows 行数(也就是宽)
     */
    public void printMatrixInCircle(int[][] matrix,int cols,int rows){
        if(matrix==null||matrix.length<=0){
            return ;
        }
        if(matrix.length<rows){
            return ;
        }
        if(matrix[0].length<cols){
            return ;
        }
        for(int i=0;i<=rows/2;i++){
            int beginRowIndex=i;
            int beginColIndex=i;
            int endColIndex = cols-i-1;
            int endRowIndex = rows-i-1;

            //打印上边
            for(int col=beginColIndex;col<=endColIndex;col++){
                System.out.print(matrix[i][col]+" ");
            }
            //打印右边
            for(int row=beginRowIndex+1;row<=endRowIndex;row++){
                System.out.print(matrix[row][endColIndex]+" ");
            }

            //打印下边
            for(int col=endColIndex-1;col>beginColIndex;col--){
                System.out.print(matrix[endRowIndex][col]+" ");
            }
            //打印左边边
            for(int row=endRowIndex;row>beginRowIndex;row--){
                System.out.print(matrix[row][beginColIndex]+" ");
            }
        }

    }
}
