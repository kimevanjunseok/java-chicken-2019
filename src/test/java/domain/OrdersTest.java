package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {

    private Orders orders;

    @BeforeEach
    void setUp() {
        orders = Orders.from(MenuRepository.menus().stream()
                .map(menu -> Order.of(menu, Count.from(0)))
                .collect(Collectors.toList()));
    }

    @Test
    void findOrderByMenu() {
        Menu menu = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
        Order expect = Order.of(menu, Count.from(0));
        Order actual = orders.findOrderByMenu(menu);

        assertThat(actual).isEqualTo(expect);
    }
}