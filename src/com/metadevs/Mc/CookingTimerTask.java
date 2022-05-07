package com.metadevs.Mc;

import java.util.*;

import static com.metadevs.Mc.Employee.*;
import static com.metadevs.Mc.Order.*;
import static com.metadevs.Mc.Queue.*;

class CookingTimerTask extends TimerTask {
    Employee employee;
    Order order;

    CookingTimerTask(Order order){
        this.order = order;
    }

    @Override
    public void run() {
        employee = getMostSpeedFreeEmployee();

        if (employeesList.size() > 0)
            order.cookingEmployee = employee;
        else
            order.cookingEmployee = getFirstFreeEmployeeInQueue();

        order.setDateOfCookingOrder(employee, order);
        order.setDateOfCookingInSeconds();

        System.out.println("\n************************************************************************************************************");
        System.out.println(printCountEmployeeInList() + " - количество свободных сотрудников");
        System.out.println("Мы начали готовить ваш заказ");
        System.out.println("Сотрудник " + employee.name + " принял заказ номер " + order.numberOrder + " . Время приготовления " + calculationOfOrderCookingTimeInMinutes(employee, order) + " минут");
        System.out.println("Будет готово к " + order.dateOfCooking);
        employeesList.remove(employee);
        System.out.println(printCountEmployeeInList() + " - количество свободных сотрудников");
        System.out.println("************************************************************************************************************");

        completeTask(employee, order);
    }

    private static void completeTask(Employee employee, Order order) {
        try {
            double waitingTimeInMilliseconds = calculationOfOrderCookingTimeInMinutes(employee, order) * 60 * 1000;
            Thread.sleep((long) waitingTimeInMilliseconds);

            if (!searchDoublesInEmployeeList(employee))
                employeesList.add(employee);
            activeOrdersList.remove(order);
            System.out.println("************************************************************************************************************");
            System.out.println("Заказ номер " + order.numberOrder + " готов.");
            System.out.println(printCountEmployeeInList() + " - количество свободных сотрудников");
            System.out.println("************************************************************************************************************\n\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}