package domain;

import java.util.Arrays;

public enum FunctionType {

    ONE(1),
    TWO(2),
    THREE(3);

    private final int number;

    FunctionType(int number) {
        this.number = number;
    }

    public static FunctionType find(int inputNumber) {
        return Arrays.stream(FunctionType.values())
                .filter(type -> type.isSameNumber(inputNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1 ~ 3사이의 숫자만 가능합니다. 입력 값: " + inputNumber));
    }

    private boolean isSameNumber(int inputNumber) {
        return number == inputNumber;
    }

    public boolean isNotThree() {
        return number != FunctionType.THREE.number;
    }
}
