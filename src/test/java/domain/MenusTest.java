package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MenusTest {

    @Test
    void find() {
        Menus menus = Menus.from(MenuRepository.menus());
        Menu menu = menus.findMenuByNumber(1);

        Menu expect = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        assertThat(menu).isEqualTo(expect);
    }
}