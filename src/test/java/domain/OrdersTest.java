package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class OrdersTest {

    private Orders orders;
    private Menu menu;

    @BeforeEach
    void setUp() {
        orders = Orders.from(new HashMap<>());
        menu = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
    }

    @Test
    void hasOrder_True() {
        orders.add(menu, 2);

        assertThat(orders.hasOrder()).isTrue();
    }

    @Test
    void hasOrder_False() {
        assertThat(orders.hasOrder()).isFalse();
    }

    @Test
    void reset() {
        orders.add(menu, 2);
        orders.reset();

        assertThat(orders.hasOrder()).isFalse();
    }
}