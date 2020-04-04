package com.xuzf.design.decorate;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/4 4:35 下午
 * @Description
 */
public class Finery extends Person{
    public Person person;

    /***
     * 创建一个呗包装的person
     * @param person
     */
    public Finery(Person person) {
        this.person=person;
    }

    @Override
    public void show() {
        if(person!=null){
            person.show();
        }
    }
}
