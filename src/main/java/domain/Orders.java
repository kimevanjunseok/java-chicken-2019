package domain;

import java.util.*;

public class Orders {

    private static final int DISCOUNT_UNIT = 10000;
    private static final int COUNT_UNIT = 10;

    private Map<Menu, Count> orders;

    private Orders(Map<Menu, Count> orders) {
        Objects.requireNonNull(orders, "Orders에서 Null 발생!");
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
        int totalPrice = getMenus().stream()
                .map(this::getPrice)
                .reduce(Integer::sum)
                .orElse(0);

        int discount = calculateDisCount();
        return totalPrice - discount;
    }

    private int calculateDisCount() {
        int chickenCount = getMenus().stream()
                .filter(Menu::isChicken)
                .map(menu -> getCount(menu).getCount())
                .reduce(Integer::sum)
                .orElse(0);
        return (chickenCount / COUNT_UNIT) * DISCOUNT_UNIT;
    }
}