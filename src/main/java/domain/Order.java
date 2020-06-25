package domain;

import java.util.Objects;

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

    public boolean isSameMenu(Menu menu) {
        return this.menu.equals(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(menu, order.menu) &&
                Objects.equals(count, order.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menu, count);
    }
}
