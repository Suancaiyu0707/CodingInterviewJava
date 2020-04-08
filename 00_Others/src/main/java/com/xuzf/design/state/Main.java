package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:35 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Work work = new Work();
        work.hour=9;
        work.writeProgram();
        work.hour=10;
        work.writeProgram();
        work.hour=12;
        work.writeProgram();
        work.hour=13;
        work.writeProgram();
        work.hour=14;
        work.writeProgram();
        work.hour=17;
        work.setFinish(false);
        work.writeProgram();
        work.hour=19;
        work.writeProgram();
        work.hour=22;
        work.writeProgram();
    }
}
