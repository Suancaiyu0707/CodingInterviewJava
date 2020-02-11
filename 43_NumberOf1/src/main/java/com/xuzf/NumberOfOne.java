package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/11
 * Time: 2:16 PM
 * Description: No Description
 *从1到n整数中1出现的次数
 *
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 */
public class NumberOfOne {


    public static void main( String[] args ) {
        System.out.println(numberOfOne1(20938));
        System.out.println(numberOfOne2(20938));
    }

    /***
     * 这种时间复杂度是O(logNum)
     * @param num
     * @return
     */
    public static int numberOfOne1(int num){
        int count=0;
        //从十位开始，十位、百位、千位、万位
        for(int i=1;i<=num;i*=10){  //i代表位数,分别是10，100，1000，。。。
            int high=num/(i*10); //更高位数字
            int low=(num%i);  //更低位数字
            int cur=(num/i)%10;  //当前位数字
            count+= high*i;

            if(cur==0){
//                count+=high*i;
            }else if(cur==1){
//                count+=high*i+(low+1);
                count+=low+1;
            }else{
//                count+=(high+1)*i;
                count+=i;
            }
        }
        return count;
    }

    /***
     * 不断的循环遍历每个数，把这些数的1的个数相加求和
     * @param n
     * @return
     */
    public static int numberOfOne2(int n){
        int count=0;
        for(int i=1;i<=n;i++){  //i代表位数
            count=count+count(i);
        }
        return count;
    }

    /***
     * 每个数都判断有几个1
     * @param i
     * @return
     */
    public static int count(int i){
        int c=0;
        while(i>0){
            if(i%10==1){
               c++;
            }
            i=i/10;
        }
        return c;
    }

}
