package christmas;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class InputView {
    Validate validate = new Validate();

    public int readDate() {
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
        String input = Console.readLine();
        try {
            validate.validDate(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return readDate();
        }
        return Integer.parseInt(input);
    }

    public HashMap<Menu, Integer> readOrder() {
        HashMap<Menu, Integer> order = new HashMap<>();

        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();
        input = input.replace(" ","");

        try {
            validate.validOrder(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return readOrder();
        }

        for (String pair : input.split(",")) {
            String[] splitPair = pair.split("-");
            order.put(Menu.valueOf(splitPair[0]), Integer.parseInt(splitPair[1]));
        }
        return order;
    }
}
