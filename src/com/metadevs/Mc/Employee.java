package com.metadevs.Mc;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    double speedCookingRatio;
    static ArrayList<Employee> employees = new ArrayList<Employee>();
    static Employee John = new Employee("John", 0.8);
    static Employee Sam = new Employee("Sam", 1);
    static Employee Alex = new Employee("Alex", 1.3);

    public Employee(String name, double speedCookingRatio) {
        this.name = name;
        this.speedCookingRatio = speedCookingRatio;
    }

    public static void main(String[] args) {
        employees.add(John);
        employees.add(Sam);
        employees.add(Alex);
    }
}
