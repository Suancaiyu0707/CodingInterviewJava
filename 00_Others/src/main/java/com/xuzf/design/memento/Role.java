package com.xuzf.design.memento;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:14 上午
 * @Description
 * 一个游戏角色类
 */
public class Role {
    /**
     * 生命力
     */
    private int vit;
    /**
     * 攻击力
     */
    private int atk;
    /***
     * 防御力
     */
    private int def;

    public Role(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

    /***
     * 保存角色状态，根据角色当前状态创建一个角色的备忘录
     * @return
     */
    public RoleStateMemento saveState(){
        return  new RoleStateMemento(vit,atk,def);
    }

    /**
     * 根据备忘录恢复一个角色状态
     * @param memento
     */
    public void recoveryState(RoleStateMemento memento){
        this.vit=memento.getVit();
        this.atk=memento.getAtk();
        this.def=memento.getDef();
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    /***
     * 开始战斗
     */
    public void fight(){
        this.vit=36;
        this.atk=120;
        this.def=80;
    }
    @Override
    public String toString() {
        return "Role{" +
                "vit=" + vit +
                ", atk=" + atk +
                ", def=" + def +
                '}';
    }
}
