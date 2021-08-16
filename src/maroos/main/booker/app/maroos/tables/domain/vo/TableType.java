package booker.app.maroos.tables.domain.vo;

import java.util.Objects;

enum tables{
    SMALL, TALL
}
public class TableType  {

    public String value;

    public TableType() {
        this.value = tables.TALL.toString();
    }
    public TableType(String table) {
        this.value = tables.valueOf(table).toString();
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TableType)) return false;
        TableType tableType = (TableType) o;
        return value.equals(tableType.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
