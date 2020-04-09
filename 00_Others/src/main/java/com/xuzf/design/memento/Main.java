package com.xuzf.design.memento;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:21 上午
 * @Description
 */
public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Role role = new Role(100,100,100);
        System.out.println("战斗前状态:"+role);
        RoleStateCaretaker caretaker = new RoleStateCaretaker();
        //先保存状态（备份存档）
        caretaker.setMemento(role.saveState());
        //开始战斗
        role.fight();
        System.out.println("战斗中状态:"+role);
        //恢复之前状态
        RoleStateMemento memento =caretaker.getMemento();
        role.recoveryState(memento);
        System.out.println("恢复后状态:"+role);
    }
}
