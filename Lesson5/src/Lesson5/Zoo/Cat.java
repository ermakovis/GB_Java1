package Lesson5.Zoo;

import Lesson5.Animal.Animal;

public class Cat extends Animal {
    public Cat () {
        super(200, 2, 0);
    }

    @Override
    public void run (double distance) {
        this.actionRun(distance, "Сat");
    }

    @Override
    public void jump (double distance) {
        this.actionJump(distance, "Cat");
    }

    @Override
    public void swim (double distance) {
        this.actionSwim(distance, "Cat");
    }
}
