package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 5:04 PM
 * Description: No Description
 */
public class CuttingRope {


    public static void main( String[] args ) {
        System.out.println("1="+dp(1));
        System.out.println("2="+dp(2));
        System.out.println("3="+dp(3));
        System.out.println("4="+dp(4));
        System.out.println("5="+dp(5));
        System.out.println("6="+dp(6));
        System.out.println("7="+dp(7));
        System.out.println("8="+dp(8));
    }
    public static Integer dp(Integer n){
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        Integer[] products = new Integer[n+1];
        products[0]=0;
        products[1]=1;//当长度为1的时候，我不继续剪段，它本身1就是最大值
        products[2]=2;//当长度为2的时候，我不继续剪段，它本身2就是最大值，如果要剪段的话，只会被剪段成1*1
        products[3]=3;//当长度为3的时候，我不继续剪段，它本身3就是最大值，如果要剪段的话，只会被剪段成1*2或1*1*1
        for(int i=4;i<=n;i++){
            int max =0;
            for(int j=1;j<=i/2;j++){
                //从(1,i-1)一直尝试到(i/2,i-i/2)，看哪种乘值最大了
                int product =products[j]*products[i-j];
                if(product>max){
                    max=product;
                }
                //找出最大的值后，保存到products对应的下标i里
                products[i]=max;
            }

        }
        return products[n];
    }
}
