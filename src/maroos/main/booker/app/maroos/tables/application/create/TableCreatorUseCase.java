package booker.app.maroos.tables.application.create;

import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.tables.domain.Table;
import booker.app.maroos.tables.domain.TableRepository;
import booker.app.maroos.tables.domain.vo.ChairQuantity;
import booker.app.maroos.tables.domain.vo.TableId;
import booker.app.maroos.tables.domain.vo.TableType;
import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.EventBus;

import java.util.Objects;

@Service
public final class TableCreatorUseCase {

    private final TableRepository repository;
    private final EventBus eventBus;

    public TableCreatorUseCase(TableRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CreateTableRequest request) {

        TableId tableId = new TableId(request.tableId());
        BranchId branchId = new BranchId(request.branchId());
        TableType type = new TableType(request.type());
        ChairQuantity chairQuantity = new ChairQuantity(request.chairQuantity());

        Table table = Table.create(tableId, branchId, type, chairQuantity);

        repository.save(table);
        eventBus.publish(table.pullDomainEvents());
    }
}
