package main.com.lol;

//同时能进行物理和魔法伤害的英雄
public class ADAPHero extends Hero implements AD,AP,Mortal{

    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    //操作符的多态
    //+ 可以作为算数运算，也可以作为字符串连接
    //
    //类的多态
    //父类引用指向子类对象
    @Override
    public void die() {
        System.out.println("ADAPHero die 了");
    }

    @Override
    public void attack() {

    }
}
