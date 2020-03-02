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
public class GreatestSumOfSubarrays2 {
    public static void main( String[] args ) {
        Integer [] sources = new Integer[]{1,-2,3,10,-4,7,2,-5};
        Integer [] sources2 = new Integer[]{-2,-5};
        GreatestSumOfSubarrays2 greatestSumOfSubarrays = new GreatestSumOfSubarrays2();
        System.out.println(greatestSumOfSubarrays.greatestSumOfSubarrays(sources));;
        System.out.println(greatestSumOfSubarrays.greatestSumOfSubarrays2(sources));;
        System.out.println(greatestSumOfSubarrays.greatestSumOfSubarrays(sources2));;
        System.out.println(greatestSumOfSubarrays.greatestSumOfSubarrays2(sources2));;
//        greatestSumOfSubarrays.maxSubProduct(sources);
    }

    /***
     *
     * @param sources
     * @return
     * 1、如果之前的累加小于0，则忽略之前的值，则新的最大累加值是当前值，否则新的累加值是 之前的累加值+当前的值
     */
    public  Integer greatestSumOfSubarrays(Integer[] sources){
        if(sources==null||sources.length<=0){
            return 0;
        }
        Integer max =0;
        //到前一个元素的累加值
        Integer sum =0 ;
        for(Integer ele:sources){
            //如果之前的累加小于0，则忽略之前的值，则新的累加值是当前值
            if(sum<0){
                sum=ele;
            }else{//否则新的累加值是 之前的累加值+当前的值
                sum=sum+ele;
            }
            //比较新的累加值和之前的最大值进行比较，哪个比较大
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }

    /***
     * 采用动态规划
     * @param sources
     * @return
     * 1、从0遍历到最后一位
     *      如果索引是0的话，则如果当前值大于0的话，则maxProduct[0]=sources[0],否则maxProduct[0]=0
     *      如果索引不是0的话：
     *          如果遍历到前一位时，最大值是<=0;则新的最大值是当前值，也就是丢弃前面的最大值，不和负值左累加：maxProduct[i]=sources[i]
     *          如果遍历到前一位时，最大值是>0;则新的最大值是当前值加上前面的最大值：maxProduct[i]=sources[i]+maxProduct[i-1]
     */
    public  Integer greatestSumOfSubarrays2(Integer[] sources){
        //数据的每个元素代表着，当遍历到sources对应索引时的最大值
        Integer[] maxProduct = new Integer[sources.length];

        for(int i=0;i<sources.length;i++){
            if(i==0){
                if(sources[i]<=0){
                    maxProduct[i]=0;
                }else{
                    maxProduct[i]=sources[i];
                }
            }else{
                if(maxProduct[i-1]<0){
                    maxProduct[i]=sources[i];
                }else{
                    maxProduct[i]=sources[i]+maxProduct[i-1];
                }
            }
        }
        int max=0;
        for(int i=0;i<maxProduct.length;i++){
            if(maxProduct[i]>max){
                max=maxProduct[i];
            }
        }
        return max;
    }

    /***
     * 最大的乘积，这个主要是要注意一个符号
     * @param arr
     */
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
