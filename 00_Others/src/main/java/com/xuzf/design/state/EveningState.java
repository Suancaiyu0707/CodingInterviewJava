package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 11:24 上午
 * @Description
 */
public class EveningState extends State{
    @Override
    public void handler(Work work) {
        if(work.isFinish()){//如果完成任务了，直接下班
            work.setState(new RestState());
            work.writeProgram();
        }else {
            if(work.hour<12){
                System.out.printf("当前时间: %d点 加班哦，疲累之极",work.hour);
                System.out.println();
            }else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
        }
}
