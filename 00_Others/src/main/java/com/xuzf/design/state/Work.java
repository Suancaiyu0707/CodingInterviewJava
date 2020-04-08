package com.xuzf.design.state;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/8 10:49 上午
 * @Description
 */
public class Work {

    public int hour;

    private State state;

    private boolean finish;


    public Work(){
        this.state=new ForenoonState();
    }

    public void writeProgram(){
        state.handler(this);
    }
   public void request(){
        //对请求做处理，并设置下一状态
        state.handler(this);
   }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
