package domain;

import java.util.*;

public class Orders {

    private Map<Menu, Integer> orders;

    private Orders(Map<Menu, Integer> orders) {
        this.orders = new HashMap<>(orders);
    }

    public static Orders from(Map<Menu, Integer> orders) {
        return new Orders(orders);
    }

    public void reset() {
        this.orders = new HashMap<>();
    }

    public boolean hasOrder() {
        return !orders.isEmpty();
    }

    public void add(Menu menu, int menuCount) {
        if (orders.containsKey(menu)) {
            int count = orders.get(menu);
            orders.put(menu, count + menuCount);
            return ;
        }
        orders.put(menu, menuCount);
    }

    public Set<Menu> getMenus() {
        return Collections.unmodifiableSet(orders.keySet());
    }

    public int getCount(Menu menu) {
        return orders.get(menu);
    }

    public int getPrice(Menu menu) {
        int count = getCount(menu);
        return menu.calculatePrice(count);
    }

    public int calculateTotalPrice() {
        return getMenus().stream()
                .map(this::getPrice)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}