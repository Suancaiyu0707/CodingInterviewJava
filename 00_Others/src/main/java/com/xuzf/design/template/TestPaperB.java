package com.xuzf.design.template;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/6 10:26 上午
 * @Description
 */
public class TestPaperB extends PaperTemplate{
    @Override
    public void answer1() {
        System.out.printf("第一道题：%s","C ");
    }

    @Override
    public void answer2() {
        System.out.printf("第二道题：%s","D ");
    }

    @Override
    public void answer3() {
        System.out.printf("第三道题：%s","B ");
    }
}
