package com.xuzf.design.template;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/6 10:28 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test1();
    }
    public static  void test1(){
        System.out.println("=================学生A答卷=================");
        PaperTemplate studentA=new TestPaperA();
        studentA.question1();
        studentA.question2();
        studentA.question3();
        System.out.println();
        System.out.println("=================学生B答卷=================");
        PaperTemplate studentB=new TestPaperB();
        studentB.question1();
        studentB.question2();
        studentB.question3();
    }
}
