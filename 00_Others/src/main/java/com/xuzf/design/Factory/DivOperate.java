package com.xuzf.design.Factory;

public class DivOperate extends AbstractOperate{
    @Override
    public double operate() {
        if(Double.valueOf(secondNum)==0) return 0;

        return Double.valueOf(firstNum)/Double.valueOf(secondNum);
    }
}
