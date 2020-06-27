package domain;

import java.util.*;

public class Orders {

    private Map<Menu, Count> orders;

    private Orders(Map<Menu, Count> orders) {
        this.orders = new HashMap<>(orders);
    }

    public static Orders from(Map<Menu, Count> orders) {
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
            Count count = orders.get(menu);
            count.add(menuCount);
            return ;
        }
        orders.put(menu, Count.from(menuCount));
    }

    public Set<Menu> getMenus() {
        return Collections.unmodifiableSet(orders.keySet());
    }

    public Count getCount(Menu menu) {
        return orders.get(menu);
    }

    public int getPrice(Menu menu) {
        Count count = getCount(menu);
        return menu.getPrice() * count.getCount();
    }

    public int calculateTotalPrice() {
        return getMenus().stream()
                .map(this::getPrice)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}