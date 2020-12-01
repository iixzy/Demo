package main.com.animal;

public class Spider extends Animal {

    public Spider(String name, int legs) {
        super(name, legs);
    }

    //当父类有set/get方法的时候可以用this调用父类的方法获取属性
    //子类继承父类,重写父类抽象方法 --- 覆盖
    @Override
    public void eat() {

        System.out.println("我是" + this.getName() + "子类 的eat方法");
    }

    public static void main(String[] args) {
        Animal animal = new Spider("大蜘蛛",8);

        animal.walk();
        animal.eat();
    }
}
