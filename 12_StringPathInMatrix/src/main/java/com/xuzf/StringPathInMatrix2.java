package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 4:51 PM
 * Description: No Description
 *  矩阵中的路径
 */
public class StringPathInMatrix2 {
    public boolean hasPath(char[][] matrix, int rows, int cols, String str) {
        boolean[][] visted =new boolean[rows][cols];
        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                boolean match =hashPathCore(matrix,row,rows,col,cols,0,str,visted);
                if(match){
                    return true;
                }
            }
        }

        return false;
    }

    /***
     * 判断某个位置的字符是否跟str的第pathLengh字符匹配
     * @param matrix 输入数组
     * @param row 当前字符所处的行
     * @param rows 数组行数
     * @param col 当前字符所属的列
     * @param cols 数组列数
     * @param pathLengh 当前需要匹配的字符在字符串里的位置
     * @param str 字符串
     * @param visted 遍历过的字符
     * @return
     */
    public boolean hashPathCore(char[][] matrix,int row,int rows,
                                int col,int cols,
                                int pathLengh,String str,
                                boolean[][] visted){
        if(str==null||"".equals(str)){
            return true;
        }
        if(row>=rows||row<0){
            return false;
        }
        if(col>=cols||col<0){
            return false;
        }
        if(visted[row][col]){
            return false;
        }

        //判断当前字符是不是要查找的字符
        boolean isMatch = matrix[row][col]==str.toCharArray()[pathLengh];
        if(!isMatch){
            return false;
        }
        pathLengh++;
        //如果匹配，且长度已经满足了，直接返回true
        if(pathLengh==str.length()){
            return true;
        }
        //记录已被匹配过的字符
        visted[row][col]=true;
        /**
         * 如果当前字符匹配了，则判断下一个的字符是否匹配，分别从上下左右匹配
         */
        if(isMatch){
            isMatch=
                    hashPathCore(matrix,row+1,rows,col,cols,pathLengh,str,visted)
                    ||hashPathCore(matrix,row,rows,col+1,cols,pathLengh,str,visted)
                    ||hashPathCore(matrix,row-1,rows,col,cols,pathLengh,str,visted)
                    ||hashPathCore(matrix,row,rows,col-1,cols,pathLengh,str,visted);
        }
        //如果下一个字符不匹配，则要回溯，并将访问记录的对应位置还原回去
        if(!isMatch){
            visted[row][col]=false;
            pathLengh--;
        }
        return isMatch;
    }

    // =======测试代码========

    // A B T G
    // C F C S
    // J D E H

    // BFCTB
    public void test1() {
//        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;

        char[][]matrix = new char[][]{
                {'A','B','T','G'},
                {'C','F','C','S'},
                {'J','D','E','H'}
        };
//        char[] str = "BFCTB".toCharArray();
        if (hasPath(matrix, rows, cols, "BFCTB"))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

    // A B T G
    // C F C S
    // J D E H

    // BFCE
    public void test2() {
        int rows = 3;
        int cols = 4;

        char[][]matrix = new char[][]{
                {'A','B','T','G'},
                {'C','F','C','S'},
                {'J','D','E','H'}
        };
        if (hasPath(matrix, rows, cols, "BFCE"))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }

    // matrix=null
    public void test3() {
        char[][] matrix = null;
        int rows = 0;
        int cols = 0;
        if (hasPath(matrix, rows, cols, "BFCE"))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }

    // str=null
    public void test4() {
        int rows = 3;
        int cols = 4;

        char[][]matrix = new char[][]{
                {'A','B','T','G'},
                {'C','F','C','S'},
                {'J','D','E','H'}
        };
        if (hasPath(matrix, rows, cols, ""))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }

    // A

    // A
    public void test5() {
        int rows = 1;
        int cols = 1;

        char[][]matrix = new char[][]{
                {'A'}
        };
        if (hasPath(matrix, rows, cols, "A"))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }
    // A

    // B
    public void test6() {
        int rows = 1;
        int cols = 1;

        char[][]matrix = new char[][]{
                {'A'}
        };
        char[] str = "B".toCharArray();
        if (hasPath(matrix, rows, cols, "B"))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }

    // AAAA
    // AAAA
    // AAAA

    // AAAAAAAAAAAA
    public void test7() {
        char[][]matrix = new char[][]{
                {'A','A','A','A'},
                {'A','A','A','A'},
                {'A','A','A','A'}
        };
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, "AAAAAAAAAAAA"))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }
    public static void main(String[] args) {
        StringPathInMatrix2 demo = new StringPathInMatrix2();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
