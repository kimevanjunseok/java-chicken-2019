package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() {
        order = Order.of(new Menu(1, "후라이드", Category.CHICKEN, 16_000), Count.from(0));
    }

    @Test
    void isSameMenu_True() {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        assertThat(order.isSameMenu(menu)).isTrue();
    }

    @Test
    void isSameMenu_False() {
        Menu menu = new Menu(2, "양념치킨", Category.CHICKEN, 16_000);
        assertThat(order.isSameMenu(menu)).isFalse();
    }

    @Test
    void add() {
        order.add(3);
        Order expect = Order.of(new Menu(1, "후라이드", Category.CHICKEN, 16_000), Count.from(3));

        assertThat(order).isEqualTo(expect);
    }
}