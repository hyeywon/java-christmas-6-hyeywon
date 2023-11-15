package christmas;

import java.text.DecimalFormat;
import java.util.HashMap;

public class OutputView {
    private final Event event;
    private static final String LINE_SEPARATOR = System.lineSeparator();
    DecimalFormat df = new DecimalFormat("###,###");

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
        String str = "<주문 메뉴>" + LINE_SEPARATOR;
        HashMap<Menu, Integer> orderList = event.getOrder().getOrderList();
        for (Menu menu : orderList.keySet()) {
            str = str + menu.getName() + " " + orderList.get(menu) + "개" + LINE_SEPARATOR;
        }
        return str;
    }

    public String printTotalPriceBeforeDiscount() {
        return "<할인 전 총주문 금액>" + LINE_SEPARATOR + df.format(event.getOrder().totalPriceBeforeDiscount()) + "원" + LINE_SEPARATOR;
    }

    public String printGift() {
        String str = "<증정 메뉴>" + LINE_SEPARATOR;
        if (event.isApplicable()) {
            if (event.giftEvent()) {
                return str + Menu.CHAMPAGNE.getName() + " 1개" + LINE_SEPARATOR;
            }
        }
        return str + "없음" + LINE_SEPARATOR;
    }

    public String printBenefits() {
        String str = "<혜택 내역>" + LINE_SEPARATOR;
        if (event.isApplicable()) {
            str += getBenefit("크리스마스 디데이 할인", event.dDayEvent());
            str += getBenefit("평일 할인", event.weekdayEvent());
            str += getBenefit("주말 할인", event.weekendEvent());
            str += getBenefit("특별 할인", event.specialEvent());
            if (event.giftEvent()) {
                str += "증정 이벤트: -" + df.format(Menu.CHAMPAGNE.getPrice()) + "원" + LINE_SEPARATOR;
            }
            return str;
        }
        return str + "없음" + LINE_SEPARATOR;
    }

    private String getBenefit(String benefit, int amount) {
        if (amount > 0) {
            return benefit + ": -" + df.format(amount) + "원" + LINE_SEPARATOR;
        }
        return "";
    }

    public String printTotalBenefitAmount() {
        String str = "<총혜택 금액>" + LINE_SEPARATOR;
        if (event.isApplicable()) {
            if (event.giftEvent()) {
                return str + "-" + df.format(event.totalBenefitAmount() + Menu.CHAMPAGNE.getPrice()) + "원" + LINE_SEPARATOR;
            }
            return str + "-" + df.format(event.totalBenefitAmount()) + "원" + LINE_SEPARATOR;
        }
        return str + "0원" + LINE_SEPARATOR;
    }

    public String printExpectedPriceAfterDiscount() {
        String str = "<할인 후 예상 결제 금액>" + LINE_SEPARATOR;
        if (event.isApplicable()) {
            return str + df.format(event.getOrder().totalPriceBeforeDiscount() - event.totalBenefitAmount()) + "원" + LINE_SEPARATOR;
        }
        return str + df.format(event.getOrder().totalPriceBeforeDiscount()) + "원" + LINE_SEPARATOR;
    }

    public String printEventBadge() {
        return "<12월 이벤트 배지>" + LINE_SEPARATOR + event.eventBadge();
    }
}
