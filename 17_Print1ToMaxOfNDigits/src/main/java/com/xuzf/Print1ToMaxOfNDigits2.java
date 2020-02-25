package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/3
 * Time: 3:26 PM
 * Description: No Description
 *  输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数即999
 *
 *  注意，n位所有的十进制其实都是n个从0到9的全排列，只要把每一位都从0-9排列一遍即可
 */
public class Print1ToMaxOfNDigits2 {


    public static boolean flag =true;
    public static void main( String[] args ) {
        Print1ToMaxOfNDigits2 print1ToMaxOfNDigits = new Print1ToMaxOfNDigits2();
        print1ToMaxOfNDigits.print(1);
    }

    public void print(int n){
        if(n<=0){
            return;
        }
        char [] numbers=new char[n];
        for(int i=0;i<n;i++){
            numbers[i]='0';
        }
        printCore(numbers,0,n);

    }

    /***
     * 当前遍历的字符
     * @param numbers
     * @param index
     * @param n
     */
    public void printCore(char [] numbers,int index,int n){
        //如果当前递归到个位，则可以直接从0，9打印了
        if(index==n-1){
            for(int i=0;i<=9;i++){
                numbers[index]=(char)(i+'0');
                System.out.println(new String(numbers));
            }
        }else{//如果还没到个位，则继续递归下一位
            for(int i=0;i<=9;i++){
                numbers[index]=(char)(i+'0');
                printCore(numbers,index+1,n);
            }

        }

    }

}
