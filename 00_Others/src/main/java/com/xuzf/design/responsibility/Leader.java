package com.xuzf.design.responsibility;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:36 上午
 * @Description
 * 领导抽象类
 */
public abstract class Leader {
    /***
     * 领导的领导
     */
    private Leader leader;
    /***
     * 领导处理申请请求
     * @param request
     */
    public abstract void handler(Request request);

    /**
     * 交给下一个人处理
     */
    public abstract void next(Request request);


    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
