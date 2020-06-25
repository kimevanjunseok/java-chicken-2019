package domain;

public class FunctionNumber {

    private final int number;

    private FunctionNumber(int number) {
        validateBetweenOneAndThree(number);
        this.number = number;
    }

    public static FunctionNumber from(int number) {
        return new FunctionNumber(number);
    }

    private void validateBetweenOneAndThree(int number) {
        if (number < 1 || number > 3) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isNotThree() {
        return number != 3;
    }
}
