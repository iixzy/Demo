package main.com;

public class Spider extends Animal{

    public Spider(String name, int legs) {
        super(name, legs);
    }

    @Override
    public void eat() {

        System.out.println("我是子类 的eat方法");
    }

    public static void main(String[] args) {
        Animal animal = new Spider("大蜘蛛",8);

        animal.walk();
        animal.eat();
    }
}
