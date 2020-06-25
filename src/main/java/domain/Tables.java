package domain;

import java.util.List;

public class Tables {

    private final List<Table> tables;

    private Tables(List<Table> tables) {
        this.tables = tables;
    }

    public static Tables from(List<Table> tables) {
        return new Tables(tables);
    }

    public List<Table> getTables() {
        return tables;
    }

    public Table findTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isSameNumber(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
