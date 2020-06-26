package domain;

import java.util.Arrays;

public enum PaymentType {
    CARD(1),
    CASH(2);

    private final int payment;

    PaymentType(int payment) {
        this.payment = payment;
    }

    public static PaymentType find(int payment) {
        return Arrays.stream(PaymentType.values())
                .filter(type -> type.payment == payment)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
