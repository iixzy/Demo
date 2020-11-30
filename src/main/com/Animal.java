package main.com;

public abstract class Animal {
    private String name;
    private int legs;
    public Animal (String name,int legs) {
        this.name = name;
        this.legs = legs;
    }
    public abstract void eat();

    public void walk() {
        System.out.println(name + "是用" + legs + "条腿走路");
    }


}
