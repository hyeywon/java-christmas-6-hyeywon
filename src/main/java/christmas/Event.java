package christmas;

public class Event {
    private static final int MAIN = 1;
    private static final int DESSERT = 2;

    private final Order order;
    private final boolean applicable;

    Event(Order order) {
        this.order = order;
        this.applicable = order.applyEvent();
    }

    public boolean isApplicable() {
        return applicable;
    }

    public int dDayEvent() {
        int date = order.getDate();
        if ((date >= 1) && (date <= 25)) {
            return 1000 + (date - 1) * 100;
        }
        return 0;
    }

    public int weekdayEvent() {
        int date = order.getDate();
        int cnt = 0;
        if ((date % 7 == 0) || (date % 7 >= 3)) {
            for (Menu menu : order.getOrder().keySet()) {
                if (menu.getIndex() == DESSERT) {
                    cnt++;
                }
            }
        }
        return cnt * 2023;
    }

    public int weekendEvent() {
        int date = order.getDate();
        int cnt = 0;
        if ((date % 7 == 1) || (date % 7 == 2)) {
            for (Menu menu : order.getOrder().keySet()) {
                if (menu.getIndex() == MAIN) {
                    cnt++;
                }
            }
        }
        return cnt * 2023;
    }

    public int specialEvent() {
        int date = order.getDate();
        if ((date % 7 == 3) || (date == 25)) {
            return 1000;
        }
        return 0;
    }

    public boolean giftEvent() {
        return order.totalPriceBeforeDiscount() >= 120000;
    }

    public int totalBenefits() {
        int total = dDayEvent() + weekdayEvent() + weekendEvent() + specialEvent();
        if (giftEvent()) {
            total += Menu.CHAMPAGNE.getPrice();
        }
        return total;
    }

    public String eventBadge() {
        if (totalBenefits() >= 20000) {
            return "산타";
        } else if (totalBenefits() >= 10000) {
            return "트리";
        } else if (totalBenefits() >= 5000) {
            return "별";
        }
        return "없음";
    }
}