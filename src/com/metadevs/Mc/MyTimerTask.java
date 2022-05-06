package com.metadevs.Mc;

import java.util.Timer;
import java.util.TimerTask;

import static com.metadevs.Mc.Employee.*;

public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        System.out.println(Employee.employees.get(0));
        System.out.println(employees.size());
        employees.remove(0);
        System.out.println("Удаляю из Емплойе листа первого челика");
        completeTask();
        System.out.println("Закончил");
        System.out.println(Employee.employees.get(0));
        System.out.println(employees.size());
    }

    private void completeTask() {
        try {
            // допустим, выполнение займет 20 секунд
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        employees.add(John);
//        employees.add(Sam);
//        employees.add(Alex);

        TimerTask timerTask = new MyTimerTask();
        // стартуем TimerTask в виде демона

        Timer timer = new Timer();
        timer.schedule(timerTask, 4000, 10000);
    }
}