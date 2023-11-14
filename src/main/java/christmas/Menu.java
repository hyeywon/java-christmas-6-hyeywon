package christmas;

public enum Menu {
    MUSHROOM_SOUP("양송이수프", 0, 6_000),
    TAPAS("타파스", 0, 5_000),
    CAESAR_SALAD("시저샐러드", 0, 8_000),
    TBONE_STEAK("티본스테이크", 1, 55_000),
    BARBECUE_RIBS("바비큐립", 1, 54_000),
    SEAFOOD_PASTA("해산물파스타", 1, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", 1, 25_000),
    CHOCO_CAKE("초코케이크", 2, 15_000),
    ICE_CREAM("아이스크림", 2, 5_000),
    COKE_ZERO("제로콜라", 3, 3_000),
    RED_WINE("레드와인", 3, 60_000),
    CHAMPAGNE("샴페인", 3, 25_000);

    private String name;
    private int index, price;

    Menu(String name, int index, int price) {
        this.name = name;
        this.index = index;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public int getPrice() {
        return price;
    }
}
