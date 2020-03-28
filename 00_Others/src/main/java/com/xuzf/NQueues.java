package com.xuzf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/1/28
 * Time: 1:23 PM
 * Description: No Description
 */
public class NQueues {
    private static int n=4;
    public static void main( String[] args ) {
        find();
    }

    public static String[] find(){
        //记录已被占用的列
        Set<Integer> haveCols = new HashSet <Integer>();
        //
        Set<Integer> colSubRow=new HashSet <Integer>();

        Set<Integer> rowAddCol=new HashSet <Integer>();
        List<String> result= new ArrayList();
        DFS(0,haveCols,rowAddCol,colSubRow,result);
        return null;
    }

    /**
     *
     * @param row 深度遍历的行数，从0开始
     * @param haveCols 已经填充的列
     * @param rowAddCol
     * @param colSubRow
     * @param result
     */
    public static void DFS(int row,Set<Integer> haveCols,
                           Set<Integer> rowAddCol,Set<Integer> colSubRow,
                           List<String> result){
        //符号
        if(row>=n){
            System.out.println(result);
            return;
        }
        for(int col=0;col<n;col++){
            if(haveCols.contains(col)){
                continue;
            }
            if(colSubRow.contains(col-row)){//如果row-col 已经包含了，则不行
                continue;
            }
            if(rowAddCol.contains(row+col)){//如果row-col 已经包含了，则不行
                continue;
            }
            haveCols.add(col);
            rowAddCol.add(row+col);
            colSubRow.add(col-row);
            result.add("("+row+","+col+")");
            DFS(row+1,haveCols,rowAddCol,colSubRow,result);
            result.remove("("+row+","+col+")");
            haveCols.remove(col);
            rowAddCol.remove(row+col);
            colSubRow.remove(col-row);
        }

    }
}
