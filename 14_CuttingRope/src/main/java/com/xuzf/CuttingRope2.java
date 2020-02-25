package com.xuzf;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/2
 * Time: 5:04 PM
 * Description: No Description
 *
 * 你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。
 * 已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
 * 例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。
 **/
public class CuttingRope2 {


    public static void main( String[] args ) {
        CuttingRope2 cuttingRope = new CuttingRope2();
        System.out.println("1="+cuttingRope.cut(1));
        System.out.println("2="+cuttingRope.cut(2));
        System.out.println("3="+cuttingRope.cut(3));
        System.out.println("4="+cuttingRope.cut(4));
        System.out.println("5="+cuttingRope.cut(5));
        System.out.println("6="+cuttingRope.cut(6));
        System.out.println("7="+cuttingRope.cut(7));
        System.out.println("8="+cuttingRope.cut(8));
        System.out.println("8="+cuttingRope.maxProductAfterCutting(8));
    }
    public  Integer cut(Integer n){
        //因为必须剪成两段
        if(n<2){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        //初始化一个数组，用于存放各种长度最大值（因为1、2、3不用剪就最大）
        Integer cut[]=new Integer[n+1];
        cut[0]=0;
        cut[1]=1;
        cut[2]=2;
        cut[3]=3;
        /***
         * 这边从4开始，是因为1，2，3都被前面的判断拦截掉了
         */
        for(int i=4;i<=n;i++){
            int max=0;
            //如果是一条初始长度为i的绳子,比如i分别为2，3，4
            for(int j=1;j<=i/2;j++){
                //当剪成一段j和i-j时候，它们的乘积
                int current=cut[j]*cut[i-j];
                //判断当前的乘积是否比之前的大，是的话，保存新的最大值
                max=Math.max(max,current);
            }
            cut[i]=max;
        }
        return cut[n];
    }


    public double maxProductAfterCutting(int length){
        if(length<2){
            return 0;
        }
        if(length==2){
            return 1;
        }
        if(length==3){
            return 2;
        }
        /***
         * 尽可能多的剪去长度为3的绳子段
         */
        int timesOf3=length/3;
        /**
         * 如果扣减后，剩下1，那么就把最后一个3和1拆成2*2
         */
        if(length-timesOf3*3==1){
            timesOf3-=1;
        }
        int timesOf2=(length-timesOf3*3)/2;

        return Math.pow(3,timesOf3)*Math.pow(2,timesOf2);
    }
}
