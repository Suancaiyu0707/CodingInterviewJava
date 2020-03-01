package com.xuzf;

import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: zhifang.xu
 * Date: 2020/2/19
 * Time: 9:37 PM
 * Description: No Description
 *
 */
public class DicesProbability {

    private static final int maxValue = 6;
    /**
     * 方法一：递归解法
     */
    public static void printProbability1(int number) {
        if(number<=0) {
            return;
        }
        //点数从number~maxValue*number，所以数组大小为maxValue*number-number+1
        int[] probabilities = new int[maxValue*number-number+1];
        //下标为i，对应的值代表点数之和为i+number总共出现的情况次数
        //点数从number~maxValue*number，所以数组大小为6*number-number+1
        for(int i=0;i<probabilities.length;i++) {
            probabilities[i] = 0;
        }
        //计算不同点数出现的次数
        for(int i=1;i<=maxValue;i++) {
            calP(probabilities, number, number - 1, i);  //第一次掷骰子，总点数只能是1~maxValue(即6)
        }
        int totalP = (int) Math.pow(maxValue, number);  //所有情况总共出现的次数
        for( int i=0;i<probabilities.length ;i++) {
            double ratio = (double)probabilities[i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(2);//设置保留几位小数
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }

    /**
     * 计算每种点数出现的次数
     * @param number:骰子总个数
     * @param curNumber:当前剩余骰子个数
     * @param sum:各个骰子加起来的总点数
     */
    private static void calP(int[] probabilities, int number, int curNumber, int sum) {
        if(curNumber==0) {
            probabilities[sum-number]++; //总数为sum的情况存放在sum-number下标中
            return;
        }
        for(int i=1;i<=maxValue;i++)
            calP(probabilities, number, curNumber-1, sum+i);  //相当于剩余的骰子少一个，总点数增加。
    }

    //===========================================
    /**
     * 方法二：基于循环求骰子点数，时间性能好
     */
    public static void printProbability2(int number) {
        if(number<=0)
            return;  //错误
        int[][] probabilities = new int[2][number*maxValue+1];
        //[2]代表用两个数组交替保存，[number*maxValue+1]是指点数为所在下标时，该点数出现的总次数。
        //probabilities[*][0]是没用的，只是为了让下标对应点数
        for(int i=0;i<2;i++) {
            for(int j=0;j<number*maxValue;j++) {
                probabilities[i][j]=0;
            }
        }

        for(int i=1;i<=6;i++)
            probabilities[0][i]=1;  //第一个骰子出现的情况

        int flag=0;
        for(int curNumber=2;curNumber<=number;curNumber++) {   //当前是第几个骰子
            for (int i = 0; i < curNumber; i++){
                probabilities[1 - flag][i] = 0;  //前面的数据清零
            }
            for(int i=curNumber;i<=curNumber*maxValue;i++) {
                for(int j=1;j<=6 && j<=i ;j++) {
                    probabilities[1-flag][i]+=probabilities[flag][i-j];
                }
            }
            flag=1-flag;

        }

        int totalP = (int) Math.pow(maxValue, number);  //所有情况总共出现的次数
        for( int i=number;i<= number*6;i++) {
            double ratio = (double)probabilities[flag][i]/totalP;
            NumberFormat format = NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(8);//设置保留几位小数
            System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
        }
    }


    public static void main(String[] args) {
        printProbability2(6);
        System.out.println("=========方法一============");
        for(int i=0;i<=3;i++) {
            System.out.println("-----骰子数为"+i+"时-----");
            printProbability1(i);
        }
        System.out.println("-----骰子数为"+11+"时-----");
        printProbability1(11);

        System.out.println("=========方法二============");
        for(int i=0;i<=3;i++) {
            System.out.println("-----骰子数为"+i+"时-----");
            printProbability2(i);
        }
        System.out.println("-----骰子数为"+11+"时-----");
        printProbability1(11);
    }
}
