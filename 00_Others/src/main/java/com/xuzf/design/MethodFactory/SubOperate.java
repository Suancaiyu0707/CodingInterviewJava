package com.xuzf.design.MethodFactory;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/5 9:17 上午
 * @Description
 */
public class SubOperate extends AbstractOperate{
    private double firstArg;
    private double secondArg;

    public SubOperate(double firstArg, double secondArg) {
        this.firstArg = firstArg;
        this.secondArg = secondArg;
    }
    @Override
    public double operate() {
        return firstArg-secondArg;
    }
}
