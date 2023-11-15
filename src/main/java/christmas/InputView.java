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
        HashMap<Menu, Integer> orderList = new HashMap<>();
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine().replace(" ", "").replaceAll(",$", "");
        try {
            validate.validOrder(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            return readOrder();
        }
        orderList = createOrderList(input);
        checkOrderable(orderList);
        return orderList;
    }

    private HashMap<Menu, Integer> createOrderList(String input) {
        HashMap<Menu, Integer> orderList = new HashMap<>();
        for (String pair : input.split(",")) {
            orderList.put(currentMenu(pair.split("-")[0]), Integer.parseInt(pair.split("-")[1]));
        }
        return orderList;
    }

    private Menu currentMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menuName.equals(menu.getName())) {
                return menu;
            }
        }
        return null;
    }

    private void checkOrderable(HashMap<Menu, Integer> orderList) {
        if (!orderable(orderList).isEmpty()) {
            System.out.println("[ERROR] " + orderable(orderList));
            readOrder();
        }
    }

    public String orderable(HashMap<Menu, Integer> orderList) {
        if (onlyDrink(orderList)) {
            return "음료만 주문 시, 주문할 수 없습니다.";
        } else if (exceed20(orderList)) {
            return "메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.";
        }
        return "";
    }

    public boolean onlyDrink(HashMap<Menu, Integer> orderList) {
        final int DRINK = 3;
        for (Menu menu : orderList.keySet()) {
            if (menu.getIndex() != DRINK) {
                return false;
            }
        }
        return true;
    }

    public boolean exceed20(HashMap<Menu, Integer> orderList) {
        int cnt = 0;
        for (Menu menu : orderList.keySet()) {
            cnt += orderList.get(menu);
        }
        return cnt > 20;
    }
}
