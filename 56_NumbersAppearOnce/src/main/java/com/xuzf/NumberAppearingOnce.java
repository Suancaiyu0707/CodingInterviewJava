package com.xuzf;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 3:22 PM
 * Description: No Description
 * 数组中唯一只出现一次的数字
 * 在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 *
 * 思路:
 *    这道题中数字出现了三次，无法像56-1) 数组中只出现一次的两个数字一样通过利用异或位运算进行消除相同个数字。但是仍然可以沿用位运算的思路。
 * 　　将所有数字的二进制表示的对应位都加起来，如果某一位能被三整除，那么只出现一次的数字在该位为0；反之，为1。
 */
public class NumberAppearingOnce {

    public static void main( String[] args ) {
        int sources[]=new int[]{8};
        System.out.println(findNumberAppearingOnce(sources,3));
        int sources2[]=new int[]{10,2,2,2,3,3,3};
        System.out.println(findNumberAppearingOnce(sources2,3));
        int sources3[]=new int[]{2,2,2,3,3,3};
        System.out.println(findNumberAppearingOnce(sources3,3));
    }
    /***
     * 查找出现次为1的那个数
     * @param sources
     * @param k 其它元素出现的次数
     * @return
     */
    public static int findNumberAppearingOnce(int sources[],int k){
        //定义一个32位长的数组，数组的每一个元素的值代表了所有的元素相同位的总和
        int []bitNum = new int[32];
        //遍历每个元素的位，并按照位进行累加后存放到数组里
        for(int ele:sources){
            int bitMask=1;
            for(int j=31;j>=0;j--) {
                //当前元素左运算
                int bit=ele&bitMask;
                if(bit!=0) {//如果当前位是1的话
                    bitNum[j] += 1;
                }
                bitMask=bitMask<<1;
            }
        }
        int result =0;
        for(int i=0;i<32;i++) {
            result=result<<1;
            result+=(bitNum[i]%k);
        }
        return result;
    }
}
