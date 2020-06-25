package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTest {

    private Count count;

    @BeforeEach
    void setUp() {
        count = Count.from(0);
    }

    @Test
    void add() {
        Count expect = Count.from(3);
        count.add(3);

        assertThat(count).isEqualTo(expect);
    }
}