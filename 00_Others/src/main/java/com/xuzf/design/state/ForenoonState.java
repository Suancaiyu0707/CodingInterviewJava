package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:13 上午
 * @Description
 */
public class ForenoonState extends State {
    @Override
    public void handler(Work work) {
        if(work.hour<12){
            System.out.printf("当前时间: %d点 上午工作，精神百倍",work.hour );
            System.out.println();
        }else{
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
