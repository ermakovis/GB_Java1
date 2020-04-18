package Lesson5.Zoo;

import Lesson5.Animal.Animal;

public class Horse extends Animal {
    public Horse() {
        super(1500, 3, 100);
    }

    @Override
    public void run(double distance) {
        this.actionRun(distance, "Horse");
    }

    @Override
    public void jump(double distance) {
        this.actionJump(distance, "Horse");
    }

    @Override
    public void swim(double distance) {
        this.actionSwim(distance, "Horse");
    }
}
