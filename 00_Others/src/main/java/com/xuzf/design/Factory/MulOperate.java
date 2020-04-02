package com.xuzf.design.Factory;

public class MulOperate extends AbstractOperate{
    @Override
    public double operate() {
        return Double.valueOf(firstNum)*Double.valueOf(secondNum);
    }
}
