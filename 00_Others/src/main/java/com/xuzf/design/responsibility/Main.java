package com.xuzf.design.responsibility;
import java.util.Date;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 9:59 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test(){

        /***
         * 创建一个总经理
         */
        Leader generalManager =  new GeneralManager();
        /***
         * 创建一个总监
         */
        Leader majordomo = new Majordomo();
        majordomo.setLeader(generalManager);
        /***
         * 创建一个经理
         */
        Leader manager=new Manager();
        manager.setLeader(majordomo);

        System.out.println("===================小菜请2天假===================");
        Request request = new Request();
        request.setApplyer("小菜");
        request.setType("请假");
        request.setContent("面试请假！");
        request.setNumber(2);
        request.setDate(new Date());

        manager.handler(request);


        System.out.println("===================小菜请5天假===================");
        request = new Request();
        request.setApplyer("小菜");
        request.setType("请假");
        request.setContent("回家请假！");
        request.setNumber(5);
        request.setDate(new Date());
        manager.handler(request);
        System.out.println("===================小菜请7天假===================");

        request = new Request();
        request.setApplyer("小菜");
        request.setType("请假");
        request.setContent("旅游请假！");
        request.setNumber(7);
        request.setDate(new Date());
        manager.handler(request);

        System.out.println("===================小菜请求加薪1500===================");
        Request request2 = new Request();
        request2.setApplyer("小菜");
        request2.setType("加薪");
        request2.setContent("转正加薪！");
        request2.setNumber(1500);
        request2.setDate(new Date());
        manager.handler(request2);

    }
}
