package christmas;

import java.util.HashMap;

public class Validate {
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

    public void validOrder(String input) {          // todo: 형식 검사...근데 밑에서 다 걸리는 거 아닌가
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

            Menu menu = Menu.valueOf(splitPair[0]);         // 일치하는 메뉴가 없을 경우 IllegalArgumentException 발생

            if (order.containsKey(menu) ||                  // 중복 메뉴 입력
                    (quantity < 1)) {                       // 메뉴의 개수가 1 미만
                throw new IllegalArgumentException();
            }

            order.put(menu, Integer.parseInt(splitPair[1]));
        }
    }
}
