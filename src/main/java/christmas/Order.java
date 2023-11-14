package christmas;

import java.util.HashMap;

public class Order {
    private final int date;
    private final HashMap<Menu, Integer> order;

    Order(int date, HashMap<Menu, Integer> order) {
        this.date = date;
        this.order = order;
    }

    public int getDate() {
        return date;
    }

    public HashMap<Menu, Integer> getOrder() {
        return order;
    }

    public int totalPriceBeforeDiscount() {
        int totalPrice = 0;
        for (Menu menu : order.keySet()) {
            totalPrice += menu.getPrice() * order.get(menu);
        }
        return totalPrice;
    }

    public boolean applyEvent() {
        return totalPriceBeforeDiscount() >= 10000;
    }

    public String orderable() {
        if (onlyDrink()) {
            return "음료만 주문 시, 주문할 수 없습니다.";
        } else if (exceed20()) {
            return "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
        }
        return "";
    }
    
    public boolean onlyDrink() {
        final int DRINK = 3;
        for (Menu menu : order.keySet()) {
            if (menu.getIndex() != DRINK) {
                return false;
            }
        }
        return true;
    }

    public boolean exceed20() {
        int cnt = 0;
        for (Menu menu : order.keySet()) {
            cnt += order.get(menu);
        }
        return cnt > 20;
    }
}