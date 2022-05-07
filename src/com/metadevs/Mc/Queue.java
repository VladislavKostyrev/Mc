package com.metadevs.Mc;

import java.util.Date;

import static com.metadevs.Mc.Employee.employeesList;
import static com.metadevs.Mc.Employee.sortEmployeeList;
import static com.metadevs.Mc.Order.activeOrdersList;

abstract class Queue {
    final static double rusburgerCookingTimeInMinutes = 2;
    final static double sirburgerCookingTimeInMinutes = 2;
    final static double potatoesSmallCookingTimeInMinutes = 1;
    final static double potatoesMediumCookingTimeInMinutes = 1;
    final static double mayoCookingTimeInMinutes = 0.5;
    final static double baikalCookingTimeInMinutes = 1.5;
    final static double buratinoCookingTimeInMinutes = 1.5;
    static Date dateOfBeginProgramme = new Date();

    static double calculationOfOrderCookingTimeInMinutes(Employee employee, Order order) {
        return employee.speedCookingRatioInMinutes * (rusburgerCookingTimeInMinutes * order.rusburger + sirburgerCookingTimeInMinutes * order.sirburger
                + potatoesSmallCookingTimeInMinutes * order.potatoesSmall + potatoesMediumCookingTimeInMinutes * order.potatoesMedium
                + mayoCookingTimeInMinutes * order.mayo + baikalCookingTimeInMinutes * order.baikal + buratinoCookingTimeInMinutes * order.buratino);
    }

    static double calculationOfCookingTimeOrderInSeconds(double cookingTimeOrderInSeconds) {
        return cookingTimeOrderInSeconds * 60;
    }

    static void sortActiveOrdersList() {
        activeOrdersList.sort((o1, o2) -> {
            if (o1.dateOfCookingInSeconds == o2.dateOfCookingInSeconds)
                return 0;
            return o1.dateOfCookingInSeconds < o2.dateOfCookingInSeconds ? 1 : -1;
        });
    }

    static Order getFirstFreeOrderInQueue(){
        sortActiveOrdersList();
        return activeOrdersList.get(0);
    }

    static Employee getFirstFreeEmployeeInQueue(){
        return getFirstFreeOrderInQueue().cookingEmployee;
    }

    static Employee getMostSpeedFreeEmployee() {
        sortEmployeeList();
        if (employeesList.size() > 0) {
            return employeesList.get(0);
        }
        return getFirstFreeEmployeeInQueue();
    }
}