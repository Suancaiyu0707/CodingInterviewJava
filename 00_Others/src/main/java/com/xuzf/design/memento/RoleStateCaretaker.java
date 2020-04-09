package com.xuzf.design.memento;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:20 上午
 * @Description
 * 角色状态管理类
 */
public class RoleStateCaretaker {
    private RoleStateMemento memento;

    public RoleStateMemento getMemento() {
        return memento;
    }

    public void setMemento(RoleStateMemento memento) {
        this.memento = memento;
    }
}
