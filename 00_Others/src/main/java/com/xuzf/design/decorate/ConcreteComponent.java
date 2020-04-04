package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:59 下午
 * @Description
 */
public class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("做点具体操作呗");
    }
}
