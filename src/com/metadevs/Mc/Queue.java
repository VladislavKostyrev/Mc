package com.metadevs.Mc;

public class Queue {

    static double rusburgerCookingTime = 2;
    static double sirburgerCookingTime = 2;
    static double potatoesSmallCookingTime = 1;
    static double potatoesMediumCookingTime = 1;
    static double mayoCookingTime = 0.5;
    static double baikalCookingTime = 1.5;
    static double buratinoCookingTime = 1.5;

    public static double calculationOfCookingTimeOrder(Order order) {
        return rusburgerCookingTime * order.rusburger + sirburgerCookingTime * order.sirburger
                + potatoesSmallCookingTime * order.potatoesSmall + potatoesMediumCookingTime * order.potatoesMedium
                + mayoCookingTime * order.mayo + baikalCookingTime * order.baikal + buratinoCookingTime * order.buratino;
    }

//    public static void
}
