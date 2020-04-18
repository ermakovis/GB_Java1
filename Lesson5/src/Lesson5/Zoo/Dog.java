package Lesson5.Zoo;

import Lesson5.Animal.Animal;

public class Dog extends Animal {

    public Dog () {
        super(500, 0.5, 10);
    }

    @Override
    public void run (double distance) {
        this.actionRun(distance, "Dog");
    }

    @Override
    public void jump (double distance) {
        this.actionJump(distance, "Dog");
    }

    @Override
    public void swim (double distance) {
        this.actionSwim(distance, "Dog");
    }

}
