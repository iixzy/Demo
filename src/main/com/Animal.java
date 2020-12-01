package main.com;

/**
 *动物抽象类(超类)
 *
 * @author ixzy
 * @since 1.0.0 2020-11-25
 */
public abstract class Animal {

    private String name;

    private int legs;

    //显式有参构造方法
    //系统默认提供无参构造方法(类中无显式构造方法)
    //如果类中有显式构造方法,系统收回默认提供的无参构造方法
    public Animal (String name,int legs) {
        this.name = name;
        this.legs = legs;
    }

    //显式无参构造方法
    public Animal () {

    }


    //抽象方法
    public abstract void eat();

    //正常方法
    public void walk() {
        System.out.println(name + "是用" + legs + "条腿走路");
    }


    //set/get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    /**
     *  抽象类不能直接通过new去实例化一个对象，那它就是不能实例化，
     *  1. 要获取抽象类的对象， 需要先用一个类继承抽象类，  然后去实例化子类。
     *  2. 也可以用匿名内部类，在抽象类中创建一个匿名的子类，继承抽象类，
     *  3. 通过特殊的语法实例化子类的对象 。--- 上转型
     *
     * @param args
     */
    public static void main(String[] args) {
        Animal animal = new Animal() {
            @Override
            public void eat() {
                System.out.println(11111);
            }
        };
    }


}
