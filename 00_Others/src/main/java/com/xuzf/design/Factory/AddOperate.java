package com.xuzf.design.Factory;

public class AddOperate extends AbstractOperate{
    @Override
    public double operate() {
        return Double.valueOf(firstNum)+Double.valueOf(secondNum);
    }
}
