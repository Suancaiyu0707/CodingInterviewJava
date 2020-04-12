package com.xuzf.design.mediator;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/12 10:30 上午
 * @Description
 */
public class UnitedNationSecurityCouncil extends UnitedNations{

    private Country usa;

    private Country iraq;

    @Override
    public void declare(String msg, Country country) {
        if(country==usa){
            iraq.getMessage(msg);
        }else if(country==iraq){
            usa.getMessage(msg);
        }
    }

    public Country getUsa() {
        return usa;
    }

    public void setUsa(Country usa) {
        this.usa = usa;
    }

    public Country getIraq() {
        return iraq;
    }

    public void setIraq(Country iraq) {
        this.iraq = iraq;
    }
}
