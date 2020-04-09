package com.xuzf.design.adapter;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:05 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Player b =new Center("巴蒂尔");
        b.attack();
        b.defense();

        Player m = new Guards("麦迪");
        m.attack();
        m.defense();

        Player y = new Translator("姚明");
        y.attack();
        y.defense();
    }
}
