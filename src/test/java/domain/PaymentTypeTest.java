package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PaymentTypeTest {

    @ParameterizedTest
    @CsvSource(value = {"1:CARD", "2:CASH"}, delimiter = ':')
    void find(int number, PaymentType type) {
        assertThat(PaymentType.find(number)).isEqualTo(type);
    }
}