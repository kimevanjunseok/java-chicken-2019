package domain;

import java.util.HashMap;
import java.util.Map;

public class MenuOrder {

    private final Map<Menu, Count> menuCounts;

    private MenuOrder(Map<Menu, Count> menuCounts) {
        this.menuCounts = new HashMap<>(menuCounts);
    }

    public static MenuOrder from(Map<Menu, Count> menuCounts) {
        return new MenuOrder(menuCounts);
    }
}
