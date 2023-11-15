package christmas;

import java.util.HashMap;

public class Order {
    private final int date;
    private final HashMap<Menu, Integer> orderList;

    Order(int date, HashMap<Menu, Integer> order) {
        this.date = date;
        this.orderList = order;
    }

    public int getDate() {
        return date;
    }

    public HashMap<Menu, Integer> getOrderList() {
        return orderList;
    }

    public int totalPriceBeforeDiscount() {
        int totalPrice = 0;
        for (Menu menu : orderList.keySet()) {
            totalPrice += menu.getPrice() * orderList.get(menu);
        }
        return totalPrice;
    }

    public boolean applyEvent() {
        return totalPriceBeforeDiscount() >= 10000;
    }
}
