package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    private Table table;

    @BeforeEach
    void setUp() {
        table = new Table(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void isSameNumber(int number, boolean expect) {
        assertThat(table.isSameNumber(number)).isEqualTo(expect);
    }
}