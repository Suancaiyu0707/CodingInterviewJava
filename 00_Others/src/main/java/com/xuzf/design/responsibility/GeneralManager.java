package com.xuzf.design.responsibility;

import lombok.Data;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:42 上午
 * @Description
 * 总经理实现类
 */
@Data
public class GeneralManager extends Leader{

    @Override
    public void handler(Request request) {
        if("请假".equals(request.getType())){
            System.out.printf("总经理签字：%s:%s 数量%d 被批准\n",request.getApplyer(),request.getContent(),request.getNumber() );
        }else if("加薪".equals(request.getType())&&request.getNumber()<=500){
            System.out.printf("总经理签字：%s:%s 数量%d 被批准\n",request.getApplyer(),request.getContent(),request.getNumber() );
        }else if("加薪".equals(request.getType())&&request.getNumber()>500){
            System.out.printf("总经理签字：%s:%s 数量%d 再说吧\n",request.getApplyer(),request.getContent(),request.getNumber() );
        }
    }

    @Override
    public void next(Request request) {
        if(this.getLeader()==null){
            return ;
        }
        this.getLeader().handler(request);
    }

}
