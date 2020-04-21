package Lesson5.Animal;

import java.util.Random;

// Третья версия, убрано переопредление методов, добавлен метод возвращаюй имя класса.
// Самая короткая версия, но немного не соответствует духу урока.
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

    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    public void run (double distance) {
        if (this.runLimit >= distance) {
            System.out.println(this.getClassName() + " runs!");
        } else if (this.runLimit == 0) {
            System.out.println(this.getClassName() + " can't run");
        }  else
            System.out.printf("This %s can't run that far. Limit is %.3f m\n", this.getClassName(), this.runLimit);
    }

    public void jump (double distance) {
        if (this.jumpLimit >= distance) {
            System.out.println(this.getClassName() + " jumps!");
        } else if (this.jumpLimit == 0) {
            System.out.println(this.getClassName() + " can't jump");
        }  else
            System.out.printf("This %s can't jump that high. Limit is %.3f m\n", this.getClassName(), this.jumpLimit);
    }

    public void swim (double distance) {
        if (this.swimLimit >= distance) {
            System.out.println(this.getClassName() + " swims!");
        } else if (this.swimLimit == 0) {
            System.out.println(this.getClassName() + " can't swim");
        } else
            System.out.printf("This %s can't swim that far. Limit is %.3f m\n", this.getClassName(), this.swimLimit);
    }
}
