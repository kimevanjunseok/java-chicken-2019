package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableMenuFactory {

    public static Map<Table, MenuOrder> createTableOrder(List<Table> tables, List<Menu> menus) {
        Map<Table, MenuOrder> orders = new HashMap<>();
        for (Table table : tables) {
            Map<Menu, Count> menuCounts = createMenuOrder(menus);
            orders.put(table, MenuOrder.from(menuCounts));
        }
        return orders;
    }

    private static Map<Menu, Count> createMenuOrder(List<Menu> menus) {
        Map<Menu, Count> menuCounts = new HashMap<>();
        for (Menu menu : menus) {
            menuCounts.put(menu, Count.from(0));
        }
        return menuCounts;
    }
}
