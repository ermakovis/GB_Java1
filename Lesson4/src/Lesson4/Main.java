package Lesson4;

public class Main {
    private static void printEmployee(final Employee employee) {
        System.out.printf("ID - %d | Name - %-15s | Age - %d | Salary - %d\n",
                employee.getId(), employee.getFullName(), employee.getAge(), employee.getSalary());
    }

    private static void printStaff(final Employee staff[]) {
        for (int i = 0; i < staff.length; i++) {
            printEmployee(staff[i]);
        }
    }

    private static void printOverForty(final Employee staff[]) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40) printEmployee(staff[i]);
        }
    }

    private static void raiseOverFortyFive(final Employee staff[]) {
        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 45) staff[i].setSalary(staff[i].getSalary() + 5000);
        }
    }

    private static int getAverageAge(final Employee staff[]){
        int ret = 0;
        for (int i = 0; i < staff.length; i++) {
            ret += staff[i].getAge();
        }
        return ret /= staff.length;
    }

    private static int getAverageSalary(final Employee staff[]){
        int ret = 0;
        for (int i = 0; i < staff.length; i++) {
            ret += staff[i].getSalary();
        }
        return ret /= staff.length;
    }

    public static void main (String args[]) {
        Employee staff[] = new Employee[5];

        staff[0] = new Employee();
        staff[1] = new Employee("IVAN IVANOV", 80000);
        staff[2] = new Employee("PETER PETROV", 40, 100000);
        staff[3] = new Employee("LEV LVOV", 50, 120000);
        staff[4] = new Employee("MARK MARKOV", 60, 140000);

        printStaff(staff);
        System.out.println("Over 40:");
        printOverForty(staff);
        raiseOverFortyFive(staff);
        System.out.println("After raise: ");
        printStaff(staff);
        System.out.printf("\nAverage Salary - %d | Average Age - %d\n",
                getAverageSalary(staff), getAverageAge(staff));
    }
}
