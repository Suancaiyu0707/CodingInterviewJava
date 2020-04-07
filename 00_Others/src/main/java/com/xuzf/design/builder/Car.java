package com.xuzf.design.builder;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/7 7:58 上午
 * @Description
 */
public class Car {
    private String chassis; //汽车底盘
    private String tyre;  //汽车轮胎
    private String steeringWheel; //汽车方向盘
    public String getChassis() {
        return chassis;
    }
    public void setChassis(String chassis) {
        this.chassis = chassis;
    }
    public String getTyre() {
        return tyre;
    }
    public void setTyre(String tyre) {
        this.tyre = tyre;
    }
    public String getSteeringWheel() {
        return steeringWheel;
    }
    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "chassis='" + chassis + '\'' +
                ", tyre='" + tyre + '\'' +
                ", steeringWheel='" + steeringWheel + '\'' +
                '}';
    }
}
