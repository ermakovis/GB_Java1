package Lesson4;

public class Employee {
    private String fullName;
    private int age;
    private int salary;
    private int id;
    private static int currentId = 0;

    //this здесь не нужен, но не вижу причины не писать его везде.
    Employee () {
        this.fullName = "John Doe";
        this.age = 30;
        this.salary = 0;
        this.id = ++currentId;
    }

    Employee (String name, int age, int salary) {
        this.fullName = name;
        this.age = age;
        this.salary = salary;
        this.id = ++currentId;
    }

    Employee (String name, int salary) {
        this.fullName = name;
        this.age = 30;
        this.salary = salary;
        this.id = ++currentId;
    }


    public String getFullName (){
        return this.fullName;
    }

    public int getAge (){
        return this.age;
    }

    public int getSalary (){
        return this.salary;
    }

    public int getId(){
        return this.id;
    }

    public void setFullName (String newName) {
        this.fullName = newName;
    }

    public void setAge (short newAge) {
        this.age = newAge;
    }

    public void setSalary (int newSalary) {
        this.salary = newSalary;
    }


}
