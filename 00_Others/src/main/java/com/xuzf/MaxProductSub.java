package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 12:58 PM
 * Description: No Description
 *  给定一个数组，求它的乘积的最大子序列
 *
 *  arr[]={1, 2, 3, -2, 4, 3 }
 */
public class MaxProductSub {

    public static void main( String[] args ) {
        Integer arr[] = {1, 2, -3, -2, 4, -1};
        maxSubProduct(arr);

        maxSum(arr);

    }

//    public static Integer maxProduct(Integer[] pro){
//
//        Integer [][] result = new Integer[pro.length][2];
//
//        int max =0;
//        int min =0;
//        /****
//         * 如果当前值正数：
//         *      则乘以前一个最大值，就就更大。
//         *      则乘以前一个最小值，就就更小。
//         *
//         */
//        for(int i=0;i<pro.length;i++){
//            int base = pro[i];
//            //如果当前值大于0
//            if(base>=0){
//                //包含当前的最大值: 前一个最大值*当前值
//                result[i][0]=result[i-1][0]*base;
//                //包含当前的最小值: 前一个最小值*当前值
//                result[i][1]=result[i-1][1]*base;
//            } else{
//                //包含当前的最小值: 前一个最大值*当前值
//                result[i][1]=result[i-1][0]*base;
//                //包含当前的最大值: 前一个最小值*当前值
//                result[i][0]=result[i-1][1]*base;
//            }
//        }
//        return 0;
//
//    }

    public static void maxSubProduct( Integer arr[] ) {
        if (arr == null || arr.length == 0)
            return;
        //用于记录遍历到当前位置时的最大值
        int max = arr[0];
        //用于记录遍历到当前位置时的最小值
        int min = arr[0];
        int maxend,result = 0;
        for (int i = 1; i < arr.length; i++) {
            //最大值的来源有三种，如果arr[i]是正数，肯定与前面的最大值相乘得到最大值，
            //如果arr[i]是负数就会与前面的最小值相乘产生最大值。如果前面的为0或者负数，
            //arr[i]本身可能是最大值。
            maxend=Max(max*arr[i],min*arr[i],arr[i]);

            //用于保存最小的负值，为下一个最大值最准备
            min = Min(max * arr[i], min * arr[i], arr[i]);

            max = maxend;
            //表示遍历到当前i时，最大值
            result = Math.max(result, max);
        }
        System.out.println(result);
    }

    public static int Max( int a, int b, int c ) {
        //返回 a b c 中的最大值
        a = Math.max(a, b);
        a = Math.max(a, c);
        return a;
    }

    public static int Min( int a, int b, int c ) {
        //返回  a b c 中的最小值
        a = Math.min(a, b);
        a = Math.min(a, c);
        return a;
    }

    /***
     * 输入一个整形数组，数组里有正数也有负数。数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。求所有子数组的和的最大值。
     * 例如数组：arr[]={1, 2, 3, -2, 4, -3 } 最大子数组为 {1, 2, 3, -2, 4} 和为8。
     * @param arr
     */
    public static void maxSum( Integer arr[] ) {
        int max = 0, sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //如果前面的累加小于0，那么就直接获得当前的值，不需要累加前面的
            if (sum <= 0) {
                sum = arr[i];
                //如果 sum<0 重新赋值
            } else {
                sum += arr[i];
            }
            max = Math.max(sum, max);
            //将最大值保存在max中。
        }
        System.out.println(max);
    }


    public static void maxSubProduct1( Integer arr[] ) {
        int min = arr[0];
        int max = arr[0];
        int maxExtend =0;
        int result = arr[0];

        for(int i=1;i<arr.length;i++){
            int base = arr[i];
            maxExtend=Max(base*max,base*min,base);
            //为什么要记录最小值，因为避免负负得正啊
            min=Min(base*max,base*min,base);
            max=maxExtend;
            //
            result=Math.max(result,max);
        }

        System.out.println(result);
    }
}
