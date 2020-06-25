package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableOrderTest {

    private TableOrder tableOrder;

    @BeforeEach
    void setUp() {
        tableOrder = TableOrder.from(
            TableMenuFactory.createTableOrder(
                TableRepository.tables(),
                MenuRepository.menus()
            )
        );
    }

    @Test
    void findTable() {
        Table table = new Table(3);
        assertThat(tableOrder.findTableByNumber(3)).isEqualTo(table);
    }
}