package com.metadevs.Mc;

import java.util.ArrayList;
import java.util.Arrays;

class Employee {
    String name;
    double speedCookingRatioInMinutes;
    Order cookingOrder;

    static Employee John = new Employee("John", 0.9);
    static Employee Sam = new Employee("Sam", 1);
    static Employee Alex = new Employee("Alex", 1.1);
    static Employee[] employeesArray = {John, Sam, Alex};
    static ArrayList<Employee> employeesList = new ArrayList<>(Arrays.asList(employeesArray));

    Employee(String name, double speedCookingRatioInMinutes) {
        this.name = name;
        this.speedCookingRatioInMinutes = speedCookingRatioInMinutes;
    }

    static void sortEmployeeList() {
        if (employeesList.size() > 1) {
            employeesList.sort((o1, o2) -> {
                if (o1.speedCookingRatioInMinutes == o2.speedCookingRatioInMinutes)
                    return 0;
                return o1.speedCookingRatioInMinutes < o2.speedCookingRatioInMinutes ? -1 : 1;
            });
        }
    }

    static int printCountEmployeeInList() {
        int countEmployeeInList = 0;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).speedCookingRatioInMinutes > 0)
                countEmployeeInList++;
        }
        return countEmployeeInList;
    }

    static boolean searchDoublesInEmployeeList(Employee employee) {

        for (int i = 0; i < employeesList.size(); i++) {
            if (employee.equals(employeesList.get(i)))
                return true;
        }
        return false;
    }
}