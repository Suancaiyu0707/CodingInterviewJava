package com.xuzf.design.builder;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 8:00 上午
 * @Description
 */
public class Main {

    public static void main(String[] args) {
        test();
    }
    public static void test(){

        CarBuilder builder = new CarBuilder();
        CarDirector director = new CarDirector(builder);
        builder.createChassis()
                .createTyre()
                .createsSteeringWheel();
        System.out.println(builder.car);

        Car car2=director.construct();
        System.out.println(car2);
    }
}
