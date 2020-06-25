package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Order> orders;

    private Orders(List<Order> orders) {
        this.orders = new ArrayList<>(orders);
    }

    public static Orders from(List<Order> orders) {
        return new Orders(orders);
    }

    public Order findOrderByMenu(Menu menu) {
        return orders.stream()
                .filter(order -> order.isSameMenu(menu))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("찾으시는 메뉴가 없습니다."));
    }
}
