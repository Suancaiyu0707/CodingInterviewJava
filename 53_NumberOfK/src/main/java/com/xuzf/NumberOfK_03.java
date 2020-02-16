package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 9:14 AM
 * Description: No Description
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
 *
 * 重点是分成两次查询：
 *  查第一次出现的目标值的位置：通过pre不是目标值判断
 *  查最后一次出现的目标值的位置：通过next不是目标值判断
 */
public class NumberOfK_03 {
    private  static int startIndex=-1;

    private static int endIndex=-1;

    public static void main( String[] args ) {
        int[] sources =new int[]{1,2,3,3,3,3,4,5};
        int[] sources1 =new int[]{1};

        int[] sources2 =new int[]{3};
        int[] sources3 =new int[]{3,3};
        int[] sources4 =new int[]{3,3,3};
        int[] sources5 =new int[]{1,3};
        int[] sources6 =new int[]{1,2,3};



    }

}
