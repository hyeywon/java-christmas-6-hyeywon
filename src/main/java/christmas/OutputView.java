package christmas;

import java.util.HashMap;

public class OutputView {
    private final Event event;

    OutputView (Event event) {
        this.event = event;
    }

    public void print() {
        System.out.println(printOrder());
        System.out.println(printTotalPriceBeforeDiscount());
        System.out.println(printGift());
        System.out.println(printBenefits());
        System.out.println(printTotalBenefitAmount());
        System.out.println(printExpectedPriceAfterDiscount());
        System.out.println(printEventBadge());
    }

    public String printOrder() {
        String str = "<주문 메뉴>\n";
        HashMap<Menu, Integer> orderList = event.getOrder().getOrderList();
        for (Menu menu : orderList.keySet()) {
            str = str + menu.getName() + " " + orderList.get(menu) + "개\n";
        }
        return str;
    }

    public String printTotalPriceBeforeDiscount() {
        return "<할인 전 총주문 금액>\n" + event.getOrder().totalPriceBeforeDiscount() + "원\n";
    }

    public String printGift() {
        String str = "<증정 메뉴>\n";
        if (event.isApplicable()) {
            if (event.giftEvent()) {
                return str + Menu.CHAMPAGNE.getName() + " 1개\n";
            }
        }
        return str + "없음\n";
    }

    public String printBenefits() {
        String str="<혜택 내역>\n";
        if (event.isApplicable()) {
            str += getBenefit("크리스마스 디데이 할인", event.dDayEvent());
            str += getBenefit("평일 할인", event.weekdayEvent());
            str += getBenefit("주말 할인", event.weekendEvent());
            str += getBenefit("특별 할인", event.specialEvent());
            if (event.giftEvent()) {
                str += "증정 이벤트: " + Menu.CHAMPAGNE.getPrice() + "원\n";
            }
            return str;
        }
        return str + "없음\n";
    }

    private String getBenefit(String benefit, int amount) {
        if (amount > 0) {
            return benefit + ": -" + amount + "원\n";
        }
        return "";
    }

    public String printTotalBenefitAmount() {
        String str = "<총혜택 금액>\n";
        if (event.isApplicable()) {
            if (event.giftEvent()) {
                return str + "-" + (event.totalBenefitAmount() + Menu.CHAMPAGNE.getPrice()) + "원\n";
            }
            return str + "-" + event.totalBenefitAmount() + "원\n";
        }
        return str + "0원\n";
    }

    public String printExpectedPriceAfterDiscount() {
        String str = "<할인 후 예상 결제 금액>\n";
        if (event.isApplicable()) {
            return str + (event.getOrder().totalPriceBeforeDiscount() - event.totalBenefitAmount()) + "원\n";
        }
        return str + event.getOrder().totalPriceBeforeDiscount() + "원\n";
    }

    public String printEventBadge() {
        return "<12월 이벤트 배지>\n" + event.eventBadge();
    }
}
