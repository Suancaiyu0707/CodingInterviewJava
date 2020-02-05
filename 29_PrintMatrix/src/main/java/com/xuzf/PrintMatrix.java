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
public class PrintMatrix {

    public static void main( String[] args ) {
        int[][] a= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        printMatrixInCircle(a,4,4);
    }
    /***
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
     * @param matrix 矩阵，当前环的开始横坐标
     * @param columns 列数(也就是长)
     * @param rows 行数(也就是宽)
     */
    public static void printMatrixInCircle(int[][] matrix,int columns,int rows){
        if(matrix==null){
            return ;
        }
        int startIndex=0;
        //遍历每一个环
        while(2*startIndex<columns &&startIndex*2<rows){
            forEachCircle(matrix,columns,rows,startIndex);
            startIndex++;
        }
    }


    public static void  forEachCircle(int[][] matrix,int columns,int rows,int start){
        int colmnEndIndex = columns-1-start;
        int rowEndIndex = rows-1-start;
        //打印上面的边
        for(int i=start;i<=colmnEndIndex;i++){
            System.out.print(matrix[start][i]);
            System.out.print(" ");
        }

        //打印右面的边
        for(int i=start+1;i<=rowEndIndex;i++){
            System.out.print(matrix[i][colmnEndIndex]);
            System.out.print(" ");
        }

        //打印下面的边
        for(int i=colmnEndIndex-1;i>=start;i--){
            System.out.print(matrix[rowEndIndex][i]);
            System.out.print(" ");
        }

        //打印左面的边
        for(int i=rowEndIndex-1;i>=start+1;i--){
            System.out.print(matrix[i][start]);
            System.out.print(" ");
        }


    }
}
