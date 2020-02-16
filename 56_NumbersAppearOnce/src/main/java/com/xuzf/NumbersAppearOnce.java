package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/16
 * Time: 2:56 PM
 * Description: No Description
 * 数组中只出现一次的两个数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class NumbersAppearOnce {

    public static void main( String[] args ) {
        int [] sources=new int[]{1,2,3,10,3,2};
        int [] sources2=new int[]{1,2};
        int [] sources3=new int[]{1,1};
        int []result = numbersAppearOnce(sources);
        int []result2 = numbersAppearOnce(sources2);
        int []result3 = numbersAppearOnce(sources3);
        System.out.println(result);
    }
    public static int[] numbersAppearOnce(int[] sources){
        int[] result = new int[]{0,0};
        if(sources==null || sources.length<2) {
            return null;
        }
        //获得所有值的异或的结果
        int resultExclusiveOR =0;
        for(int ele:sources){
            resultExclusiveOR^=ele;
        }
        if(resultExclusiveOR==0){
            return null;
        }

        int bitIndex = 1;
        //从低位到高位遍历resultExclusiveOR的位，如果当前位和1与为0，也就是当前位是0，则继续查看下一位
        //
        while((resultExclusiveOR&1)==0){
            if(bitIndex>32){//超过int的位数了
                break;
            }
            //resultExclusiveOR 向右移一位，也就是检查高一位是否位1
            resultExclusiveOR=resultExclusiveOR >> 1;
            bitIndex++;
        }
        int bitNum = 1;
        // 从000000000001 -> 000000010000 类似这样的
        bitNum=bitNum<<(bitIndex-1);
        for(int ele:sources){
            //如果第bitIndex位是1的话，跟result[0]左运算
            if((ele^bitNum)==0){
                result[0]=result[0]^ele;
            }else{
                result[1]=result[1]^ele;
            }
        }

        return result;

    }
}
