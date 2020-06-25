package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void validateRange(int input) {
        assertThatThrownBy(() -> FunctionNumber.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isNotThree_True() {
        FunctionNumber functionNumber = FunctionNumber.from(1);
        assertThat(functionNumber.isNotThree()).isTrue();
    }

    @Test
    void isNotThree_False() {
        FunctionNumber functionNumber = FunctionNumber.from(3);
        assertThat(functionNumber.isNotThree()).isFalse();
    }
}