package com.xuzf.design.Factory;

import java.io.Console;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program {

    public static void mainToString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字A: ");
        String A = scanner.nextLine();
        System.out.println("请输入数字符号(支持* / + -): ");
        String B= scanner.nextLine();
        System.out.println("请输入数字C: ");
        String C= scanner.nextLine();
        Integer D=0;
        switch (B)
        {
            case "+":
                D=Integer.valueOf(A)+Integer.valueOf(C);
                break;
            case "-":
                D=Integer.valueOf(A)-Integer.valueOf(C);
                break;
            case "*":
                D=Integer.valueOf(A)*Integer.valueOf(C);
                break;
            case "/":
                D=Integer.valueOf(A)/Integer.valueOf(C);
                break;
        }
        System.out.printf("result is %d",D);
    }

    public static void main(String[] args) {
        mainToString();
    }
}
