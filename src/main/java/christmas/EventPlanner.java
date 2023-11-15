package christmas;

public class EventPlanner {

    public void planner() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        InputView inputView = new InputView();

        Order order = new Order(inputView.readDate(), inputView.readOrder());

        System.out.println("12월 " + order.getDate() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
        Event event = new Event(order);
        OutputView outputView = new OutputView(event);
        outputView.print();
    }
}
