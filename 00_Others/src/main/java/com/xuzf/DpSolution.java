package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 3:29 PM
 * Description: No Description
 *
 * 给定一根长度为N的杆和一个包含所有小于N的小块的价格的数组，确定通过切割杆和卖件获得的最大值。
 */
public class DpSolution {
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 0; j < i; j++)
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
            subSolutions[i] = tmpMax;
        }
        return subSolutions[rodLength];
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;

        System.out.println("Max rod value: " + getValue(values, rodLength));
    }
}
