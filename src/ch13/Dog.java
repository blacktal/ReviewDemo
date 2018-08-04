package ch13;

import ch13Test.Animal;

public class Dog extends Animal{
    public void show() {
        Cat cat = new Cat();
        // 无法通过其他子类对象访问父类的protected成员
//        cat.i = 9;
//        cat.eat();
    }
}
