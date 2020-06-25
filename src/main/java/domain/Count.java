package domain;

public class Count {

    private int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(int count) {
        return new Count(count);
    }
}
