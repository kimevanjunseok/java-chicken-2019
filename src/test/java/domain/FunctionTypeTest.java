package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"1:ONE", "2:TWO", "3:THREE"}, delimiter = ':')
    void find(int input, FunctionType type) {
        FunctionType functionType = FunctionType.find(input);
        assertThat(functionType).isEqualTo(type);
    }

    @Test
    void isNotThree_True() {
        FunctionType functionType = FunctionType.find(2);
        assertThat(functionType.isNotThree()).isTrue();
    }

    @Test
    void isNotThree_False() {
        FunctionType functionType = FunctionType.find(3);
        assertThat(functionType.isNotThree()).isFalse();
    }
}