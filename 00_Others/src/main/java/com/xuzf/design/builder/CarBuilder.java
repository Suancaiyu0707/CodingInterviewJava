package com.xuzf.design.builder;

import java.awt.*;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 7:54 上午
 * @Description
 */
public class CarBuilder {
   public Car car=new Car();

   public CarBuilder createChassis() {
      car.setChassis("速腾的底盘，嗷嗷叫，断轴很牛逼！");
      return this;
   }
   public CarBuilder createTyre() {
      car.setTyre("固特异的轮胎，还可以");
      return this;
   }
   public CarBuilder createsSteeringWheel() {
      car.setSteeringWheel("真皮方向盘！就问你牛逼不？");
      return this;
   }
   public Car builder() {
      return car;
   }
}
