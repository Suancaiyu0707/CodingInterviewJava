package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:20 上午
 * @Description
 */
public class AfternoonState extends State{
    @Override
    public void handler(Work work) {
        if(work.hour<17){
            System.out.printf("当前时间: %d点 下午状态还不错，继续努力",work.hour );
            System.out.println();
        }else{
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
