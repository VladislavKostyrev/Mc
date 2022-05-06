package com.metadevs.Mc;

import java.util.Scanner;

public class ClientAPI {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        Order order = new Order();
        System.out.println("Нажмите Enter чтобы сделать заказ");       //TODO сделать нажатие ентера
        makeOrder(order);
    }

    public static void makeOrder(Order order) {
        Order.printAllSelectedPositionInOrder(order);
        showOrderNavigationMenu();
        int numberMenuPosition = scanner.nextInt();
        switch (numberMenuPosition) {                                  //TODO проверка ввода, дефолт свитч?
            case 1 -> addPositionInOrder(order);                      //TODO подумать, к какому классу должны принадлежать эти методы
            case 2 -> removePositionInOrder(order);
            case 3 -> clearOrder(order);
            case 4 -> confirmOrder(order);
        }
    }

    private static void addPositionInOrder(Order order) {
        showRestaurantMenu();
        int numberMenuPosition = scanner.nextInt();                                //TODO проверка ввода, дефолт свитч?
        System.out.println("Сколько позиций вы хотите добавить?:");
        int countSelectedPosition = scanner.nextInt();                          //TODO проверка ввода, дефолт свитч?

        for (int i = 0; i < countSelectedPosition; i++) {
            switch (numberMenuPosition) {
                case 1 -> Order.addRusburgerFromOrder(order);
                case 2 -> Order.addSirburgerFromOrder(order);
                case 3 -> Order.addPotatoesSmallFromOrder(order);
                case 4 -> Order.addPotatoesMediumFromOrder(order);
                case 5 -> Order.addMayoFromOrder(order);
                case 6 -> Order.addBaikalFromOrder(order);
                case 7 -> Order.addBuratinoFromOrder(order);
            }
        }
        makeOrder(order);
    }

//    public static void checkAvailabilityPositionInOrder(Order order, int numberMenuPosition) {
//        switch (numberMenuPosition) {
//            case 1:
//                if (order.rusburger <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 2:
//                if (order.sirburger <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 3:
//                if (order.potatoesSmall <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 4:
//                if (order.potatoesMedium <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 5:
//                if (order.mayo <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 6:
//                if (order.baikal <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//            case 7:
//                if (order.buratino <= 0){
//                    System.out.println("Этой позиции нет в заказе");
//                    makeOrder(order);
//                }
//        }
//    }

    public static void removePositionInOrder(Order order) {
        if (Order.isOrderEmpty(order)) {
            System.out.println("Заказ пуст");
            makeOrder(order);
        }

        System.out.println("Какую позицию вы хотите убрать?");
        showRestaurantMenu();                                                         //TODO проверка, есть ли эта позиция вообще в заказе?
        int numberMenuPosition = scanner.nextInt();                                //TODO проверка ввода, дефолт свитч?

//        checkAvailabilityPositionInOrder(order, numberMenuPosition);
        System.out.println("Сколько позиций вы хотите убрать?: ");
        int countSelectedPosition = scanner.nextInt();                          //TODO проверка ввода, дефолт свитч?

        for (int i = 0; i < countSelectedPosition; i++) {
            switch (numberMenuPosition) {
                case 1 -> Order.removeRusburgerFromOrder(order);
                case 2 -> Order.removeSirburgerFromOrder(order);
                case 3 -> Order.removePotatoesSmallFromOrder(order);
                case 4 -> Order.removePotatoesMediumFromOrder(order);
                case 5 -> Order.removeMayoFromOrder(order);
                case 6 -> Order.removeBaikalFromOrder(order);
                case 7 -> Order.removeBuratinoFromOrder(order);
            }
        }
        makeOrder(order);
    }

    public static void clearOrder(Order order) {
        if (Order.isOrderEmpty(order)) {
            System.out.println("Заказ пуст");
            makeOrder(order);
        }
        order.rusburger = 0;
        order.sirburger = 0;
        order.potatoesSmall = 0;
        order.potatoesMedium = 0;
        order.mayo = 0;
        order.baikal = 0;
        order.buratino = 0;
    }

    public static void confirmOrder(Order order) {

    }

    public static void showOrderNavigationMenu() {
        System.out.println("""

                Меню:
                1. Добавить позицию
                2. Убрать позицию
                3. Очистить заказ
                4. Оформить заказ
                """);                                            //TODO сделать выход на стартМеню через 3 минуты бездейсвтия?
        System.out.println("Введите номер операции:");
    }

    public static void showRestaurantMenu() {
        System.out.println("""
                Меню:
                1. Русбургер - 50р.
                2. Сырбургер - 55р.
                3. Картофель деревенский мал. - 50р.
                4. Картофель деревенский ср. - 80р.
                5.  Майонез ЕЖК порция - 30р.
                6. Байкал 0.5 л. - 75р.
                7. Буратино 0.5 л. - 75р.
                """);
        System.out.println("Введите номер позиции:");
    }

    public static void main(String[] args) {
        Order order = new Order();                                     //TODO сделать кнопку "начать" и там создается новый заказ, возврат туда только после конфирм ордер
        startMenu();                                                    //TODO заказу каждый раз будет присваиваться уникальное имя
        System.out.printf(String.valueOf(order.rusburger));
    }
}