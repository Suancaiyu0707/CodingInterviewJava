package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/11
 * Time: 2:15 PM
 * Description: No Description
 * 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中一个或连续的多个整/数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class GreatestSumOfSubarrays {
    public static void main( String[] args ) {
        Integer [] sources = new Integer[]{1,-2,3,10,-4,7,2,-5};
        maxSum(sources);
        maxSubProduct(sources);
    }
    public static Integer greatestSumOfSubarrays(Integer[] sources){
        int currentSum =0;
        int largestSum =0;
        if(sources==null||sources.length==0){
            return 0;
        }
        for(int i=0;i<sources.length;i++){
            if(currentSum<=0){
                currentSum=sources[i];
            }else{
                currentSum=sources[i]+currentSum;
            }
            //说明 sources[i]>0
            if(currentSum>largestSum){
                largestSum=currentSum;
            }
        }
        return largestSum;
    }

    /***
     * 动态规划
     * @param arr
     * @return
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
}
