package com.xuzf.design.Factory;

import java.util.Scanner;

public class OperateFactory {

    public static AbstractOperate operate(String o){
        AbstractOperate operate=null;
        switch (o){
            case "+":
                operate=new AddOperate();
                break;
            case "-":
                operate=new SubOperate();
                break;
            case "*":
                operate=new MulOperate();
                break;
            case "/":
                operate=new DivOperate();
                break;
        }
        return operate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A: ");
        String A = scanner.nextLine();
        System.out.println("请输入数字符号(支持* / + -): ");
        String B= scanner.nextLine();
        System.out.println("请输入数字C: ");
        String C= scanner.nextLine();
        AbstractOperate operate = operate(B);
        operate.firstNum=A;
        operate.secondNum=C;
        double result =operate.operate();

        System.out.print("result ="+result);
    }
}
