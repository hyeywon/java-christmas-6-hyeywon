package christmas;

import java.util.HashMap;

public class Validate {
    private Menu currentMenu;

    public void validDate(String input) {
        int date;

        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if ((date < 1) || (date > 31)) {
            throw new IllegalArgumentException();
        }
    }

    public void validOrder(String input) {
        HashMap<Menu, Integer> order = new HashMap<>();
        String[] splitOrder = input.split(",");

        for (String pair : splitOrder) {
            String[] splitPair = pair.split("-");
            int quantity;

            try {
                quantity = Integer.parseInt(splitPair[1]);  // 메뉴 개수가 정수가 아닌 경우
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if ((quantity < 1) ||                           // 메뉴의 개수가 1 미만
                    noMatching(splitPair[0]) ||             // 일치하는 메뉴가 없는 경우
                    (order.containsKey(currentMenu))) {     // 중복 메뉴 입력
                throw new IllegalArgumentException();
            }

            order.put(currentMenu, Integer.parseInt(splitPair[1]));
        }
    }

    private boolean noMatching(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menuName.equals(menu.getName())) {
                currentMenu = menu;
                return false;
            }
        }
        return true;
    }
}
