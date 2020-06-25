package domain;

import java.util.*;
import java.util.stream.Collectors;

public class TableMenuFactory {

    private static final int INITIAL_COUNT = 0;

    public static Map<Table, Orders> createTableOrder(List<Table> tables, List<Menu> menus) {
        Map<Table, Orders> tableOrder = new HashMap<>();
        for (Table table : tables) {
            tableOrder.put(table, Orders.from(createOrders(menus)));
        }
        return tableOrder;
    }

    private static List<Order> createOrders(List<Menu> menus) {
        return Collections.unmodifiableList(menus.stream()
                .map(menu -> Order.of(menu, Count.from(INITIAL_COUNT)))
                .collect(Collectors.toList()));
    }
}
