package com.metadevs.Mc;

import java.util.Scanner;

public class ClientAPI {

    static Scanner scanner = new Scanner(System.in);
    static int numberMenuPosition = 666;

    //вызов метода Client.авторизация

    public static void navigationMenu() {
        System.out.println("Приветствие");
        int userInput = scanner.nextInt();

        System.out.println("Введите номер операции:\n" +
                "1. Сделать заказ.\n" +
                "2. Позвать помощника.\n" +
                "3. Выйти.\n");
        switch (userInput) {
            case 1:
                makeOrder();
                break;
            case 2:
                callAnEmployee();
                break;
            case 3:

                break;
        }
    }

    public static void makeOrder() {
        Order order = new Order();

        while (!(numberMenuPosition == 0) && !(numberMenuPosition == 8)) {
            showRestaurantMenu();
            numberMenuPosition = scanner.nextInt();
            addPositionInOrder(numberMenuPosition);
        }
        switch (numberMenuPosition) {
            case 0:
                break;
            case 8:
                break;
            case 9:
                break;


                //должен быть вывод того что сейчас в заказе
            //также удалять из заказа позиции - выбор чего, и выбор сколько удалить
            // воткнуть метод првоерки заполенности заказа
        }
    }

    private static void addPositionInOrder(int numberMenuPosition) {
        System.out.println("Сколько позиций вы хотите добавить? :");
        int countSelectedPosition = scanner.nextInt();

        for (int i = 0; i < countSelectedPosition; i++) {
            switch (numberMenuPosition) {
                case 0:
                    break;
                case 1:
                    Order.addRusburger(order);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }
    }

    public static boolean isOrderFilledIn() {
        boolean isOrderFilledIn;
        if (numberMenuPosition == 8) {
            return isOrderFilledIn = false;
        } else {
            return isOrderFilledIn = true;
        }
    }

    public static void showRestaurantMenu() {
        System.out.println("Введите номер позиции, чтобы добавить её в заказ. " +
                "\nВведите 8 для потверждения заказа. Ведите 0, для выхода в главное меню: ");
        System.out.println("Меню:\n" +
                "1. Русбургер - 50р.\n" +
                "2. Сырбургер - 55р.\n" +
                "3. Картофель деревенский мал. - 50р.\n" +
                "4. Картофель деревенский ср. - 80р.\n" +
                "5.  Майонез ЕЖК порция - 30р.\n" +
                "6. Байкал 0.5 л. - 75р.\n" +
                "7. Буратино 0.5 л. - 75р.\n" +
                "8. Потвердить заказ.\n" +
                "0. Выход в главное меню.\n");

    }

    public static void callAnEmployee() {

    }

    public static void addRestaurantMenuPosition() {

    }

    public static void removeRestaurantMenuPosition() {

    }

    public static void confirmOrder() {

    }

}
