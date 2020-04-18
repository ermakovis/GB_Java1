package Lesson5.Animal;

import java.util.Random;

public abstract class Animal {
    protected double jumpLimit;
    protected double runLimit;
    protected double swimLimit;

    protected Animal (double runLimit, double jumpLimit, double swimLimit) {
        this.jumpLimit = addRandom(jumpLimit);
        this.runLimit = addRandom(runLimit);
        this.swimLimit = addRandom(swimLimit);
    }

    private double addRandom(double num) {
        Random random = new Random();
        return num + (random.nextDouble() - 0.5) * num;
    }

    protected void actionRun (double distance, String name) {
        if (this.runLimit >= distance) {
            System.out.println(name + " runs!");
        }  else
            System.out.printf("This %s can't run that far. Limit is %.3f m\n", name, this.runLimit);
    }

    protected void actionJump (double distance, String name) {
        if (this.jumpLimit >= distance) {
            System.out.println(name + " jumps!");
        }  else
            System.out.printf("This %s can't jump that high. Limit is %.3f m\n", name, this.jumpLimit);
    }

    protected void actionSwim (double distance, String name) {
        if (this.swimLimit >= distance) {
            System.out.println(name + " swims!");
        } else if (this.swimLimit == 0) {
            System.out.println(name + " can't swim");
        } else
            System.out.printf("This %s can't swim that far. Limit is %.3f m\n", name, this.jumpLimit);
    }

    public abstract void run(double distance);
    public abstract void jump(double height);
    public abstract void swim(double height);
}
