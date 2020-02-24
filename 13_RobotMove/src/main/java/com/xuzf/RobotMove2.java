package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/1
 * Time: 5:35 PM
 * Description: No Description
 */
public class RobotMove2 {
    public int movingCount(int threshold, int rows, int cols) {
        if (rows <= 0 || cols <= 0 || threshold < 0)
            return 0;

        boolean[][] isVisited = new boolean[rows][ cols];
        int count = movingCountCore(threshold, rows, cols, 0, 0, isVisited);// 用两种方法试一下
        return count;
    }

    private int movingCountCore(int threshold,
                                int rows, int cols,
                                int row, int col,
                                boolean[][] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || isVisited[row][col]
                || cal(row) + cal(col) > threshold){
            return 0;
        }

        isVisited[row][col] = true;
        return 1 + movingCountCore(threshold, rows, cols, row - 1, col, isVisited)
                + movingCountCore(threshold, rows, cols, row + 1, col, isVisited)
                + movingCountCore(threshold, rows, cols, row, col - 1, isVisited)
                + movingCountCore(threshold, rows, cols, row, col + 1, isVisited);
    }


    private int cal(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // ========测试代码=========
    void test(String testName, int threshold, int rows, int cols, int expected) {
        if (testName != null)
            System.out.print(testName + ":");

        if (movingCount(threshold, rows, cols) == expected)
            System.out.println("Passed.");
        else
            System.out.println("Failed.");
    }

    // 方格多行多列
    void test1() {
        test("Test1", 5, 10, 10, 21);
    }

    // 方格多行多列
    void test2() {
        test("Test2", 15, 20, 20, 359);
    }

    // 方格只有一行，机器人只能到达部分方格
    void test3() {
        test("Test3", 10, 1, 100, 29);
    }

    // 方格只有一行，机器人能到达所有方格
    void test4() {
        test("Test4", 10, 1, 10, 10);
    }

    // 方格只有一列，机器人只能到达部分方格
    void test5() {
        test("Test5", 15, 100, 1, 79);
    }

    // 方格只有一列，机器人能到达所有方格
    void test6() {
        test("Test6", 15, 10, 1, 10);
    }

    // 方格只有一行一列
    void test7() {
        test("Test7", 15, 1, 1, 1);
    }

    // 方格只有一行一列
    void test8() {
        test("Test8", 0, 1, 1, 1);
    }

    // 机器人不能进入任意一个方格
    void test9() {
        test("Test9", -10, 10, 10, 0);
    }

    public static void main(String[] args) {
        RobotMove2 demo = new RobotMove2();
        demo.test1();
        demo.test2();
        demo.test3();
        demo.test4();
        demo.test5();
        demo.test6();
        demo.test7();
        demo.test8();
        demo.test9();
    }

}
