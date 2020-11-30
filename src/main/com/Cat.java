package main.com;

public class Cat extends Animal implements Pet{
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
