package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:false"}, delimiter = ':')
    void isSameNumber(int number, boolean expect) {
        assertThat(menu.isSameNumber(number)).isEqualTo(expect);
    }
}