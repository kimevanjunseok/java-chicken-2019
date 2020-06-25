package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableOrder {

    private final Map<Table, Orders> tableOrders;

    private TableOrder(Map<Table, Orders> tableOrders) {
        this.tableOrders = new HashMap<>(tableOrders);
    }

    public static TableOrder from(Map<Table, Orders> tableOrders) {
        return new TableOrder(tableOrders);
    }

    public Table findTableByNumber(int tableNumber) {
        return tableOrders.keySet().stream()
                .filter(table -> table.isSameNumber(tableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 테이블 번호는 없습니다. 입력 값: " + tableNumber));
    }

    public List<Table> getTables() {
        return new ArrayList<>(tableOrders.keySet());
    }
}
