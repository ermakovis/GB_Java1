package Lesson5.Zoo;

import Lesson5.Animal.Animal;

public class Bird extends Animal {
    public Bird () {
        super(5, 0.2, 0);
    }

    @Override
    public void run (double distance) {
        this.actionRun(distance, "Bird");
    }

    @Override
    public void jump (double distance) {
        this.actionJump(distance, "Bird");
    }

    @Override
    public void swim (double distance) {
        this.actionSwim(distance, "Bird");
    }
}
