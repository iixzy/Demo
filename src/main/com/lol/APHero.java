package main.com.lol;

public class APHero extends Hero implements AP{
    public APHero() {
        super();
    }

    public APHero(String name) {
        super(name);
    }


    @Override
    public void attack() {

    }

    @Override
    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

}
