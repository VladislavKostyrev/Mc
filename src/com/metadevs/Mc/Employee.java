package com.metadevs.Mc;

import java.util.ArrayList;
import java.util.Arrays;

public class Employee {
    String name;
    double speedCookingRatio;

    static Employee John = new Employee("John", 1.3);
    static Employee Sam = new Employee("Sam", 1);
    static Employee Alex = new Employee("Alex", 0.8);
    static Employee [] employeesArray = {John, Sam, Alex};
    static ArrayList<Employee> employeesList = new ArrayList<Employee>(Arrays.asList(employeesArray));

    public Employee(String name, double speedCookingRatio) {
        this.name = name;
        this.speedCookingRatio = speedCookingRatio;
    }
}