package domain;

import java.util.HashMap;
import java.util.Objects;

public class Table {
    private final int number;
    private Orders orders;

    public Table(final int number) {
        this.number = number;
        this.orders = Orders.from(new HashMap<>());
    }

    public void resetOrders() {
        this.orders.reset();
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Menu menu, int menuCount) {
        orders.add(menu, menuCount);
    }

    public boolean hasOrder() {
        return orders.hasOrder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return number == table.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}