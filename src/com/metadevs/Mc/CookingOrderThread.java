package com.metadevs.Mc;

import java.util.Timer;
import java.util.TimerTask;

class CookingOrderThread extends Thread {
    Order order;


    public CookingOrderThread(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        TimerTask timerTask = new CookingTimerTask(order);
        Timer timer = new Timer();
        timer.schedule(timerTask, 0);
    }
}