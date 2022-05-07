package com.metadevs.Mc;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.metadevs.Mc.ClientTerminal.*;
import static com.metadevs.Mc.Queue.calculationOfOrderCookingTimeInMinutes;
import static com.metadevs.Mc.Queue.dateOfBeginProgramme;

class Order {
    int rusburger = 0;
    int sirburger = 0;
    int potatoesSmall = 0;
    int potatoesMedium = 0;
    int mayo = 0;
    int baikal = 0;
    int buratino = 0;
    int numberOrder;
    static int countOrders = 0;
    static ArrayList<Order> activeOrdersList = new ArrayList<>();                  //TODO убрать в Queue???
    Employee cookingEmployee;
    Date dateOfCooking;
    int dateOfCookingInSeconds;

    Order() {
        countOrders++;
        this.numberOrder = countOrders;
    }

    void addPositionsInOrder() {                                    //TODO проверка ввода
        showRestaurantMenu();
        int numberMenuPosition = scanner.nextInt();
        System.out.print("Сколько позиций вы хотите добавить?:   ");
        int countSelectedPosition = scanner.nextInt();

        for (int i = 0; i < countSelectedPosition; i++) {
            switch (numberMenuPosition) {
                case 1 -> rusburger++;
                case 2 -> sirburger++;
                case 3 -> potatoesSmall++;
                case 4 -> potatoesMedium++;
                case 5 -> mayo++;
                case 6 -> baikal++;
                case 7 -> buratino++;
                default -> {
                    System.out.println("Некорректный ввод. Пожалуйста повторите.");
                    addPositionsInOrder();
                }
            }
        }
    }

    void removePositionsFromOrder() {                              //TODO проверка ввода
        if (isOrderEmpty()) {
            System.out.println("Заказ и так пуст");
            return;
        }

        System.out.print("Какую позицию вы хотите убрать?:   ");
        showRestaurantMenu();
        int numberMenuPosition = scanner.nextInt();
        System.out.print("Сколько позиций вы хотите убрать?:   ");
        int countSelectedPosition = scanner.nextInt();

        for (int i = 0; i < countSelectedPosition; i++) {
            switch (numberMenuPosition) {
                case 1 -> rusburger = removePositionIfItGreaterThanZero(rusburger);
                case 2 -> sirburger = removePositionIfItGreaterThanZero(sirburger);
                case 3 -> potatoesSmall = removePositionIfItGreaterThanZero(potatoesSmall);
                case 4 -> potatoesMedium = removePositionIfItGreaterThanZero(potatoesMedium);
                case 5 -> mayo = removePositionIfItGreaterThanZero(mayo);
                case 6 -> baikal = removePositionIfItGreaterThanZero(baikal);
                case 7 -> buratino = removePositionIfItGreaterThanZero(buratino);
            }
        }
    }

    private int removePositionIfItGreaterThanZero(int positionInOrder) {
        if (positionInOrder <= 0) {
            System.out.println("Эта позиция и так отсутствует");
            return positionInOrder;
        }
        positionInOrder--;
        return positionInOrder;
    }

    void clearOrder() {
        if (isOrderEmpty()) {
            System.out.println("Заказ и так пуст");
            return;
        }

        rusburger = 0;
        sirburger = 0;
        potatoesSmall = 0;
        potatoesMedium = 0;
        mayo = 0;
        baikal = 0;
        buratino = 0;
    }

    static void confirmOrder(Order order) {
        //TODO нужен метод проверки что нельзя сделать пустой заказ
        new CookingOrderThread(order).start();
        placeNewOrder();
    }


    void printAllSelectedPositionInOrder() {
        if (!isOrderEmpty())
            System.out.println("Сейчас в заказе: ");
        else
            System.out.println("Заказ пуст. Добавьте нужные позиции в заказ.");
        if (rusburger > 0)
            System.out.println("Русбургер - " + rusburger);
        if (sirburger > 0)
            System.out.println("Сырбургер - " + sirburger);
        if (potatoesSmall > 0)
            System.out.println("Картофель деревенский мал - " + potatoesSmall);
        if (potatoesMedium > 0)
            System.out.println("Картофель деревенский ср. - " + potatoesMedium);
        if (mayo > 0)
            System.out.println("Майонез ЕЖК порция - " + mayo);
        if (baikal > 0)
            System.out.println("Байкал 0.5 л. - " + baikal);
        if (buratino > 0)
            System.out.println("Буратино 0.5 л. - " + buratino);
    }

    private boolean isOrderEmpty() {
        return (rusburger + sirburger + potatoesSmall
                + potatoesMedium + mayo + baikal + buratino) <= 0;
    }

    static Order getLastOrder() {                                                       //////
        return activeOrdersList.get(activeOrdersList.size() - 1);
    }

    void setDateOfCookingOrder(Employee employee, Order order) {
        Calendar cal = Calendar.getInstance();
        double OrderCookingTimeInMinutes = calculationOfOrderCookingTimeInMinutes(employee, order);
        cal.add(Calendar.SECOND, (int) Queue.calculationOfCookingTimeOrderInSeconds(OrderCookingTimeInMinutes));
        dateOfCooking = cal.getTime();
    }

    void setDateOfCookingInSeconds(){
        dateOfCookingInSeconds = (int) ((dateOfCooking.getTime() - dateOfBeginProgramme.getTime()) / 1000.0);
    }
}