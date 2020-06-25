package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TablesTest {
    @Test
    void find() {
        Tables tables = Tables.from(TableRepository.tables());
        Table expect = new Table(1);

        assertThat(tables.findTableByNumber(1)).isEqualTo(expect);
    }
}