package booker.app.maroos.tables.application.create;

import java.util.Objects;

public class CreateTableRequest {

    private final String tableId;
    private final String branchId;
    private final String type;
    private final Integer chairQuantity;

    public CreateTableRequest(String tableId, String branchId, String type, Integer chairQuantity) {
        this.tableId = tableId;
        this.branchId = branchId;
        this.type = type;
        this.chairQuantity = chairQuantity;
    }

    public String tableId() {
        return tableId;
    }

    public String branchId() {
        return branchId;
    }

    public String type() {
        return type;
    }

    public Integer chairQuantity() {
        return chairQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateTableRequest)) return false;
        CreateTableRequest that = (CreateTableRequest) o;
        return Objects.equals(tableId, that.tableId) &&
                Objects.equals(branchId, that.branchId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(chairQuantity, that.chairQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, branchId, type, chairQuantity);
    }
}
