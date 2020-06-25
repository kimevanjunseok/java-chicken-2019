package domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TableMenuFactoryTest {
    @Test
    void create() {
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        Map<Table, Orders> cache = TableMenuFactory.createTableOrder(tables, menus);

        assertThat(cache).isNotEmpty();
        assertThat(cache.entrySet()).hasSize(6);
    }
}