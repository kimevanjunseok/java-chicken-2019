package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum PaymentType {
    CARD(1, Double::valueOf),
    CASH(2, (price) -> price * 0.95);

    private final int payment;
    private final Function<Integer, Double> finalAmount;

    PaymentType(int payment, Function<Integer, Double> finalAmount) {
        this.payment = payment;
        this.finalAmount = finalAmount;
    }

    public static PaymentType find(int payment) {
        return Arrays.stream(PaymentType.values())
                .filter(type -> type.payment == payment)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public double payment(int price) {
        return finalAmount.apply(price);
    }
}
