package com.metadevs.Mc;

import java.util.Scanner;
import static com.metadevs.Mc.Order.*;

abstract public class ClientTerminal {
    static Scanner scanner = new Scanner(System.in);
    public static void placeNewOrder() {
        enterZForBegin();
        Order order = new Order();
        activeOrdersList.add(order);                             /////
        makeOrder(order);
    }

    private static void enterZForBegin() {
        System.out.println("Нажмите \"Z\" чтобы сделать заказ:  ");
        String inputEnter = scanner.next();
        if (!"Z".equals(inputEnter)) {
            enterZForBegin();
        }
    }

    static void makeOrder(Order order) {
        order.printAllSelectedPositionInOrder();
        showOrderNavigationMenu();

        int NavigationMenuActionNumber = scanner.nextInt();
        switch (NavigationMenuActionNumber) {                                  //TODO проверка ввода
            case 1 -> order.addPositionsInOrder();
            case 2 -> order.removePositionsFromOrder();
            case 3 -> order.clearOrder();
            case 4 -> confirmOrder(order);
            default -> System.out.println("Некорректный ввод. Пожалуйста повторите.");
        }
        makeOrder(order);
    }

    private static void showOrderNavigationMenu() {
        System.out.println("""

                Меню:
                1. Добавить позицию
                2. Убрать позицию
                3. Очистить заказ
                4. Оформить заказ
                """);                                            //TODO сделать выход на стартМеню через 3 минуты бездействия?
        System.out.print("Введите номер операции:   ");
    }

    static void showRestaurantMenu() {
        System.out.println("""
                Меню:
                1. Русбургер - 50р.
                2. Сырбургер - 55р.
                3. Картофель деревенский мал. - 50р.
                4. Картофель деревенский ср. - 80р.
                5. Майонез ЕЖК порция - 30р.
                6. Байкал 0.5 л. - 75р.
                7. Буратино 0.5 л. - 75р.
                """);
        System.out.print("Введите номер позиции:   ");
    }
}