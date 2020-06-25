package domain;

public enum OrderState {
    ORDER(true),
    NOT_ORDER(false);

    private final boolean hasOrder;

    OrderState(boolean hasOrder) {
        this.hasOrder = hasOrder;
    }

    public boolean hasOrder() {
        return hasOrder;
    }
}
