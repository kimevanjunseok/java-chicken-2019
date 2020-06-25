package domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Table {
    private final int number;
    private OrderState orderState;
    private Orders orders;

    public Table(final int number) {
        this.number = number;
        resetOrders();
    }

    public void resetOrders() {
        this.orderState = OrderState.NOT_ORDER;
        this.orders = Orders.from(initOrders());
    }

    private List<Order> initOrders() {
        return MenuRepository.menus().stream()
                .map(menu -> Order.of(menu, Count.from(0)))
                .collect(Collectors.toList());
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }

    public void addOrder(Menu menu, int menuCount) {
        this.orderState = OrderState.ORDER;
        Order order = orders.findOrderByMenu(menu);
        order.add(menuCount);
    }

    public boolean hasOrder() {
        return orderState.hasOrder();
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
