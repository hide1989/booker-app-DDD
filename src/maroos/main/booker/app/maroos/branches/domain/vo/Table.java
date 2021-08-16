package booker.app.maroos.branches.domain.vo;

import java.util.Objects;

public class Table {
    private final Integer tableNumber;
    private final Integer chairQuantity;

    public Table(Integer tableNumber, Integer chairQuantity) {
        this.tableNumber = tableNumber;
        this.chairQuantity = chairQuantity;
    }

    public Integer tableNumber() {
        return tableNumber;
    }

    public Integer chairQuantity() {
        return chairQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return Objects.equals(tableNumber, table.tableNumber) &&
                Objects.equals(chairQuantity, table.chairQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, chairQuantity);
    }
}
