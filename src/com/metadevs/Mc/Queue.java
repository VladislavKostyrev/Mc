package com.metadevs.Mc;

public class Queue {

    final static double rusburgerCookingTime = 2;
    final static double sirburgerCookingTime = 2;
    final static double potatoesSmallCookingTime = 1;
    final static double potatoesMediumCookingTime = 1;
    final static double mayoCookingTime = 0.5;
    final static double baikalCookingTime = 1.5;
    final static double buratinoCookingTime = 1.5;

    public static double calculationOfCookingTimeOrder(Employee employee, Order order) {
        return employee.speedCookingRatio * (rusburgerCookingTime * order.rusburger + sirburgerCookingTime * order.sirburger
                + potatoesSmallCookingTime * order.potatoesSmall + potatoesMediumCookingTime * order.potatoesMedium
                + mayoCookingTime * order.mayo + baikalCookingTime * order.baikal + buratinoCookingTime * order.buratino);
    }

    //TODO сделать метод проверки очереди, назначения сотрудника, проверки того тко свободен

}
