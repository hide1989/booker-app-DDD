package booker.app.maroos.branches.application.addTable;

import java.util.Objects;

public class CreateTableRequest {

    private final Integer tableNumber;
    private final Integer chairQuantity;
    private final String branchId;

    public CreateTableRequest(String branchId, Integer tableNumber, Integer chairQuantity) {
        this.tableNumber = tableNumber;
        this.chairQuantity = chairQuantity;
        this.branchId = branchId;
    }

    public String branchId() {
        return branchId;
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
        if (!(o instanceof CreateTableRequest)) return false;
        CreateTableRequest that = (CreateTableRequest) o;
        return Objects.equals(tableNumber, that.tableNumber) &&
                Objects.equals(chairQuantity, that.chairQuantity) &&
                Objects.equals(branchId, that.branchId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableNumber, chairQuantity, branchId);
    }
}
