package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:18 上午
 * @Description
 */
public class NoonState extends State{
    @Override
    public void handler(Work work) {
        if(work.hour<13){
            System.out.printf("当前时间: %d点 饿了，午饭；犯困，午休",work.hour );
            System.out.println();
        }else{
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}
