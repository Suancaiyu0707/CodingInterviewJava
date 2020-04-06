package com.xuzf.design.template;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/6 10:25 上午
 * @Description
 */
public abstract class PaperTemplate {

    public void question1(){
        answer1();
    }
    public void question2(){
        answer2();
    }
    public void question3(){
        answer3();
    }

    public abstract void answer1();
    public abstract void answer2();
    public abstract void answer3();
}
