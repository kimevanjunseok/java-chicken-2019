package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    private Table table;
    private Menu menu;

    @BeforeEach
    void setUp() {
        table = new Table(1);
        menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void isSameNumber(int number, boolean expect) {
        assertThat(table.isSameNumber(number)).isEqualTo(expect);
    }

    @Test
    void addOrder() {
        table.addOrder(menu, 1);

        assertThat(table.hasOrder()).isTrue();
    }

    @Test
    void reset() {
        table.addOrder(menu, 1);
        table.resetOrders();

        assertThat(table.hasOrder()).isFalse();
    }

    @Test
    void calculate() {
        table.addOrder(menu, 10);
        assertThat(table.calculateTotalPrice()).isEqualTo(160_000);
    }
}