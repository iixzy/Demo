package main.com;

/**
 * AD 英雄
 */
public class ADHero extends Hero implements AD{
    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }

    //instanceof关键字
    public static void main(String[] args) {
        ADHero ad = new ADHero();
        APHero ap = new APHero();

        Hero h1= ad;
        Hero h2= ap;

        //判断引用h1指向的对象，是否是ADHero类型
        System.out.println(h1 instanceof ADHero);

        //判断引用h2指向的对象，是否是APHero类型
        System.out.println(h2 instanceof APHero);

        //判断引用h1指向的对象，是否是Hero的子类型
        System.out.println(h1 instanceof Hero);
    }
}
