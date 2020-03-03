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
public class NumberOfOne2 {


    public static void main( String[] args ) {
        NumberOfOne2 numberOfOne= new NumberOfOne2();
        System.out.println(numberOfOne.numberOfOne1(20938));
        System.out.println(numberOfOne.numberOfOne2(20938));
    }

    /***
     * 这种时间复杂度是O(logNum)
     * @param num 20938
     * @return
     * 对于整数n，我们将这个整数分为三部分：
     *      当前位数字cur，更高位数字high，更低位数字low，
     *      如：对于n=21034，当位数是十位时，cur=3，high=210，low=4。
     *
     * 　　我们从个位到最高位 依次计算每个位置出现1的次数：
     *
     * 　　1）当前位的数字等于0时，例如n=21034，在百位上的数字cur=0，百位上是1的情况有：00100~00199，01100~01199，……，20100~20199。一共有21*100种情况，即high*100;
     *
     * 　　2）当前位的数字等于1时，例如n=21034，在千位上的数字cur=1，千位上是1的情况有：01000~01999，11000~11999，21000~21034。一共有2*1000+（34+1）种情况，即high*1000+(low+1)。
     *
     * 　　3）当前位的数字大于1时，例如n=21034，在十位上的数字cur=3，十位上是1的情况有：00010~00019，……，21010~21019。一共有（210+1）*10种情况，即(high+1)*10。
     *
     * 　　这个方法只需要遍历每个位数，对于整数n，其位数一共有lgn个，所以时间复杂度为O(logn)。
     *
     */
    public  int numberOfOne1(int num){
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
    public  int numberOfOne2(int n){
        int total=0;
        for(int i=0;i<=n;i++){
            int num=i;
            while(num>0){
                if(num%10==1){
                    total++;
                }
                num = num/10;
            }
        }

        return total;
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
