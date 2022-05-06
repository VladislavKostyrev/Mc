package com.metadevs.Mc;

public class Order {
    int rusburger;
    int sirburger;
    int potatoesSmall;
    int potatoesMedium;
    int mayo;
    int baikal;
    int buratino;
    int numberOrder;
    static int countOrders = 0;

    {
        rusburger = 0;
        sirburger = 0;
        potatoesSmall = 0;
        potatoesMedium = 0;
        mayo = 0;
        baikal = 0;
        buratino = 0;
    }

    public Order(){
        countOrders++;
        this.numberOrder = countOrders;
    }

    public static void addRusburgerFromOrder(Order order) {
        order.rusburger++;
    }

    public static void addSirburgerFromOrder(Order order) {
        order.sirburger++;
    }

    public static void addPotatoesSmallFromOrder(Order order) {
        order.potatoesSmall++;
    }

    public static void addPotatoesMediumFromOrder(Order order) {
        order.potatoesMedium++;
    }

    public static void addMayoFromOrder(Order order) {
        order.mayo++;
    }

    public static void addBaikalFromOrder(Order order) {
        order.baikal++;
    }

    public static void addBuratinoFromOrder(Order order) {
        order.buratino++;
    }

    public static void removeRusburgerFromOrder(Order order) {
        if (order.rusburger > 0)
            order.rusburger--;
        else
            System.out.println("Эта позиция и так отсутсвует");
    }

    public static void removeSirburgerFromOrder(Order order) {
        if (order.sirburger > 0)
            order.sirburger--;
    }

    public static void removePotatoesSmallFromOrder(Order order) {
        if (order.potatoesSmall > 0)
            order.potatoesSmall--;
    }

    public static void removePotatoesMediumFromOrder(Order order) {
        if (order.potatoesMedium > 0)
            order.potatoesMedium--;
    }

    public static void removeMayoFromOrder(Order order) {
        if (order.mayo > 0)
            order.mayo--;
    }

    public static void removeBaikalFromOrder(Order order) {
        if (order.baikal > 0)
            order.baikal--;
    }

    public static void removeBuratinoFromOrder(Order order) {
        if (order.buratino > 0)
            order.buratino--;
    }

    public static void printAllSelectedPositionInOrder(Order order) {
        if (getSumOfOrderPositions(order) > 0)
            System.out.println("Сейчас в заказе: ");
        if (order.rusburger > 0)
            System.out.println("Русбургер - " + order.rusburger);
        if (order.sirburger > 0)
            System.out.println("Сырбургер - " + order.sirburger);
        if (order.potatoesSmall > 0)
            System.out.println("Картофель деревенский мал - " + order.potatoesSmall);
        if (order.potatoesMedium > 0)
            System.out.println("Картофель деревенский ср. - " + order.potatoesMedium);
        if (order.mayo > 0)
            System.out.println("Майонез ЕЖК порция - " + order.mayo);
        if (order.baikal > 0)
            System.out.println("Байкал 0.5 л. - " + order.baikal);
        if (order.buratino > 0)
            System.out.println("Буратино 0.5 л. - " + order.buratino);
    }

    public static int getSumOfOrderPositions(Order order) {
        return order.rusburger + order.sirburger + order.potatoesSmall
                + order.potatoesMedium + order.mayo + order.baikal + order.buratino;
    }

    public static boolean isOrderEmpty(Order order) {
        return getSumOfOrderPositions(order) <= 0;
    }

    //TODO придумать два метода, которые сокращают все методы выше

    public static void main(String[] args) {
        Order orrr = new Order();
        System.out.println(orrr.numberOrder);
        Order orrre = new Order();
        System.out.println(orrre.numberOrder);

    }
}