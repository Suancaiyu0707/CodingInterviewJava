package com.xuzf.design.memento;

/**
 * @author Suancaiyu
 * @version 1.0
 * @Date 2020/4/9 8:15 上午
 * @Description
 * 角色备忘录
 */
public class RoleStateMemento {

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
    /***
     * 创建一个角色备忘录
     * @param vit
     * @param atk
     * @param def
     */
    public RoleStateMemento(int vit, int atk, int def) {
        this.vit=vit;
        this.atk=atk;
        this.def=def;
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
}
