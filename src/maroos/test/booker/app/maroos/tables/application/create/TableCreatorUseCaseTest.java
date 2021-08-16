package booker.app.maroos.tables.application.create;

import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.tables.domain.Table;
import booker.app.maroos.tables.domain.TableRepository;
import booker.app.maroos.tables.domain.vo.ChairQuantity;
import booker.app.maroos.tables.domain.vo.TableId;
import booker.app.maroos.tables.domain.vo.TableType;
import booker.app.shared.domain.bus.event.EventBus;
import booker.app.shared.domain.bus.event.TableCreatedDomainEvent;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TableCreatorUseCaseTest {

    @Test
    void create_table(){
        TableRepository repository = mock(TableRepository.class);
        EventBus eventBus = mock(EventBus.class);

        TableCreatorUseCase useCase = new TableCreatorUseCase(repository, eventBus);

        CreateTableRequest request = new CreateTableRequest(
          "1aab45ba-3c7a-4344-8936-78466eca77cc",
          "1aab45ba-3c7a-4344-8936-78466eca77fa",
          "SMALL",
         4
        );

        Table table = new Table(
          new TableId(request.tableId()),
          new BranchId(request.branchId()),
          new TableType(request.type()),
          new ChairQuantity(request.chairQuantity())
        );

        TableCreatedDomainEvent domainEvent = new TableCreatedDomainEvent(
                request.tableId(),
                request.branchId(),
                request.type(),
                request.chairQuantity()
        );
        useCase.create(request);

        verify(repository, atLeastOnce()).save(table);
        verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));
    }




}