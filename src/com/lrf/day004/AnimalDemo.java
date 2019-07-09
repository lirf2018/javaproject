package com.lrf.day004;

/**
 * 创建人: lirf
 * 创建时间:  2018-03-20 10:11
 * 功能介绍:  多态
 */
public class AnimalDemo {

    public static void main(String[] args) {
        //父类引用子类对象（向上转型）
        Animal dog = new Dog("狗");
        //向上转型是安全的,但是子类特有方法不能使用,只能调用父类中有方法或者子类重写的方法
        dog.eat();

        //父类引用子类对象（向上转型）
        Animal cat = new Cat("猫");
        cat.eat();

        //向下转型是不安全的
        Dog dog1 = (Dog) cat;
    }
}


class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("------>父类eat");
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("------>狗吃骨头");
    }

    public void sleep() {
        System.out.println("------>狗在睡觉");
    }
}


class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("------>猫吃鱼");
    }
}