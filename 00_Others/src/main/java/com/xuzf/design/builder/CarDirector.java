package com.xuzf.design.builder;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 7:59 上午
 * @Description
 */
public class CarDirector {

    private CarBuilder carBuilder;

    public CarDirector(CarBuilder carBuilder){
        this.carBuilder = carBuilder;
    }

    public Car construct(){
        carBuilder.createChassis();
        carBuilder.createTyre();
        carBuilder.createsSteeringWheel();
        return carBuilder.builder();
    }

}
