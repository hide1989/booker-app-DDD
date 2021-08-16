package booker.app.maroos.tables.domain;

import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.tables.domain.vo.ChairQuantity;
import booker.app.maroos.tables.domain.vo.TableId;
import booker.app.maroos.tables.domain.vo.TableType;
import booker.app.shared.domain.AggregateRoot;
import booker.app.shared.domain.bus.event.TableCreatedDomainEvent;

import java.util.Objects;

public class Table extends AggregateRoot {

    private final TableId tableId;
    private final BranchId branchId;
    private final TableType type;
    private final ChairQuantity chairQuantity;

    public Table(TableId tableId, BranchId branchId, TableType type, ChairQuantity chairQuantity) {
        this.tableId = tableId;
        this.branchId = branchId;
        this.type = type;
        this.chairQuantity = chairQuantity;
    }

    private Table() {
        this.tableId = null;
        this.branchId = null;
        this.type = null;
        this.chairQuantity = null;
    }

    public TableId tableId() {
        return tableId;
    }

    public BranchId branchId() {
        return branchId;
    }

    public TableType type() {
        return type;
    }

    public ChairQuantity chairQuantity() {
        return chairQuantity;
    }

    public static Table create(
            TableId tableId,
            BranchId branchId,
            TableType type,
            ChairQuantity chairQuantity
    ){
        Table table = new Table(tableId, branchId, type, chairQuantity);

        table.record( new TableCreatedDomainEvent(
                tableId.value(),
                branchId.value(),
                type.value(),
                chairQuantity.value()
        ));

        return table;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;
        Table table = (Table) o;
        return Objects.equals(tableId, table.tableId) &&
                Objects.equals(branchId, table.branchId) &&
                Objects.equals(type, table.type) &&
                Objects.equals(chairQuantity, table.chairQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableId, branchId, type, chairQuantity);
    }
}
