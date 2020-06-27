package domain.table.order;

public class Count {

    private static final int MAXIMUM_COUNT = 99;

    private int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(int count) {
        return new Count(count);
    }

    public void add(int menuCount) {
        if (count + menuCount > MAXIMUM_COUNT) {
            throw new IllegalArgumentException("한 메뉴의 최대 수량은 99개 입니다.");
        }
        count += menuCount;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return Integer.toString(count);
    }
}