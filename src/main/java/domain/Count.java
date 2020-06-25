package domain;

import java.util.Objects;

public class Count {

    private int count;

    private Count(int count) {
        this.count = count;
    }

    public static Count from(int count) {
        return new Count(count);
    }

    public void add(int menuCount) {
        count += menuCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count1 = (Count) o;
        return count == count1.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count);
    }
}
