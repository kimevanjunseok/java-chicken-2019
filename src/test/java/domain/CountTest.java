package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CountTest {

    private Count count;

    @BeforeEach
    void setUp() {
        count = Count.from(0);
    }

    @Test
    void add_Exception() {
        assertThatThrownBy(() -> count.add(100))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void add() {
        count.add(10);
        assertThat(count.toString()).isEqualTo("10");
    }
}
