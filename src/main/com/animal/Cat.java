package main.com.animal;

/**
 *动物子类 猫类
 *
 * @author ixzy
 * @param
 * @return
 * @since 1.0.0 2020-11-25
 */
public class Cat extends Animal implements Pet{

    //子类构造方法会先调用父类构造方法
    public Cat(String name, int legs) {
        super(name, legs);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void eat() {

    }
}
