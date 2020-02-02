package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 4:51 PM
 * Description: No Description
 *  矩阵中的路径
 */
public class StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //用来标记被访问的单元格
        boolean[] isVisited = new boolean[rows * cols];
        for (boolean v : isVisited) {//初始化单元格标记，都未被访问过
            v = false;
        }
        int pathLength = 0;
        //遍历行
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {//遍历列
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited))
                    return true;
            }
        }
        return false;
    }

    /***
     *
     * @param matrix
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param str
     * @param pathLength
     * @param isVisited
     * @return
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength,
                                boolean[] isVisited) {
        if (row < 0  || row >= rows //如果越界
                || col < 0|| col >= cols //如果越界
                || isVisited[row * cols + col] == true //如果当前字符被访问过
                || str[pathLength] != matrix[row * cols + col] //如果字符不是待查找的字符，则返回false
                ){
            return false;
        }

        if (pathLength == str.length - 1){
            return true;
        }
        boolean hasPath = false;
        isVisited[row * cols + col] = true;
        //上下左右的查找
        hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited)//向上查找
                || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited)//向下查找
                || hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited)//向左查找
                || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);//向右查找

        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }

    // =======测试代码========

    // A B T G
    // C F C S
    // J D E H

    // BFCTB
    public void test1() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCTB".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test1 passed.");
        else
            System.out.println("Test1 failed.");
    }

    // A B T G
    // C F C S
    // J D E H

    // BFCE
    public void test2() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "BFCE".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test2 passed.");
        else
            System.out.println("Test2 failed.");
    }

    // matrix=null
    public void test3() {
        char[] matrix = null;
        int rows = 0;
        int cols = 0;
        char[] str = "BFCE".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test3 passed.");
        else
            System.out.println("Test3 failed.");
    }

    // str=null
    public void test4() {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = null;
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test4 passed.");
        else
            System.out.println("Test4 failed.");
    }

    // A

    // A
    public void test5() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "A".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test5 passed.");
        else
            System.out.println("Test5 failed.");
    }
    // A

    // B
    public void test6() {
        char[] matrix = "A".toCharArray();
        int rows = 1;
        int cols = 1;
        char[] str = "B".toCharArray();
        if (!hasPath(matrix, rows, cols, str))
            System.out.println("Test6 passed.");
        else
            System.out.println("Test6 failed.");
    }

    // AAAA
    // AAAA
    // AAAA

    // AAAAAAAAAAAA
    public void test7() {
        char[] matrix = "AAAAAAAAAAAA".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "AAAAAAAAAAAA".toCharArray();
        if (hasPath(matrix, rows, cols, str))
            System.out.println("Test7 passed.");
        else
            System.out.println("Test7 failed.");
    }
    public static void main(String[] args) {
        StringPathInMatrix demo = new StringPathInMatrix();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
    }
}
