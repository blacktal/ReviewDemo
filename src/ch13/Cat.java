package ch13;

import ch13Test.Animal;

public class Cat extends Animal{
    public void show() {
        Animal animal = new Animal();
        // 无法通过父类对象访问父类的protected成员
//        animal.i = 9;
//        animal.eat();
//        System.out.println("Cat is eating" + animal.i);
    }
}
