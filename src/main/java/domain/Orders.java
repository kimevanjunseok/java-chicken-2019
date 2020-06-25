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
}
