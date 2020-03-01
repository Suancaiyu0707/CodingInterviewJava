package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/31
 * Time: 11:24 AM
 * Description: No Description
 */
public class FindInPartiallySortedMatrix2 {

    public static void main( String[] args ) {
        Integer matrix[][] = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        FindInPartiallySortedMatrix2 matrix2 = new FindInPartiallySortedMatrix2();
        System.out.println(matrix2.exsits(matrix,4,4,10));

    }

   public  boolean exsits(Integer matrix[][],int rows,int cols,int target){
        int row= 0;
        int col=cols-1;
        while(matrix[row][col]!=target){
           //比目标值大，则要向左移动
           if(matrix[row][col]>target){
               if(col==0){
                   return false;
               }
               col--;
           }else if(matrix[row][col]<target){//比目标值大，则要向下移动
               if(row==rows-1){
                   return false;
               }
               row++;
           }
       }
       return true;
   }
}
