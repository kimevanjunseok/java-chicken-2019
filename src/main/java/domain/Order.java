package domain;

public class Order {

    private final Menu menu;
    private final Count count;

    private Order(Menu menu, Count count) {
        this.menu = menu;
        this.count = count;
    }

    public static Order of(Menu menu, Count count) {
        return new Order(menu, count);
    }
}
