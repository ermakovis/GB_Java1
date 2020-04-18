package Lesson5;

import Lesson5.Zoo.*;

public class Main {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(),
                new Dog(),
                new Dog()
        };
        for (int i = 0; i < dogs.length; i++) {
            dogs[i].run(400);
            dogs[i].run(600);
            dogs[i].jump(0.2);
            dogs[i].jump(2);
            dogs[i].swim(10);
            dogs[i].swim(30);
            System.out.println("-------------------------");
        }
        Cat cat = new Cat();
        cat.swim(10);
    }
}
