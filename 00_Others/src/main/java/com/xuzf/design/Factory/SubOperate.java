package com.xuzf.design.Factory;

public class SubOperate extends AbstractOperate{
    @Override
    public double operate() {
        return Double.valueOf(firstNum)-Double.valueOf(secondNum);
    }
}
