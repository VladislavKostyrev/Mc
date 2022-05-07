package com.metadevs.Mc;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static com.metadevs.Mc.Employee.*;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("Сотрудник " + employeesList.get(0) + " принял заказ НОМЕР ТАКОЙ ТО. НАПИСАТЬ ПРИВЯЗКУ К НОМЕРУ ЗАКАЗА Время приготовления " + Queue.calculationOfCookingTimeOrder(employeesList.get(0), Order.orders.get(0)) + " минут"); //TODO поменять ордер 0 на метод подставы числа
        employeesList.remove(0);

        Date date = new Date();

        completeTask();
        //TODO сделать метод проверки очереди, назначения сотрудника, проверки того тко свободен



    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            double waitingTimeInMinutes = Queue.calculationOfCookingTimeOrder(employeesList.get(0), Order.orders.get(0));
            double waitingTimeInMilliseconds = waitingTimeInMinutes * 60 *1000;
            Thread.sleep((long) waitingTimeInMilliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TimerTask timerTask = new MyTimerTask();
        Timer timer = new Timer();
        timer.schedule(timerTask, 0);
    }
}