package com.xuzf.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/11 9:34 上午
 * @Description
 */
public class Waiter {

    public List<BarbecueCommand> commandList = new ArrayList<BarbecueCommand>();

    private Barbecuer barbecuer;

    public Waiter(Barbecuer barbecuer){
        this.barbecuer=barbecuer;
    }
    public void add(BarbecueCommand command){
        commandList.add(command);
    }

    public void notifyBarbecue(){
        if(commandList!=null){
            for(BarbecueCommand barbecueCommand:commandList){
                barbecuer.barbecue(barbecueCommand);
            }
        }
    }
}
