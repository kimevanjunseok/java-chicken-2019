package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Table {
    private final int number;
    private Orders orders;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void resetOrders() {
        this.orders = Orders.from(initOrders());
    }

    private List<Order> initOrders() {
        return MenuRepository.menus().stream()
                .map(menu -> Order.of(menu, Count.from(0)))
                .collect(Collectors.toList());
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
