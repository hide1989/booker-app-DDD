package booker.app.maroos.branches.application.addTable;

import booker.app.maroos.branches.application.create.BranchCreatorUseCase;
import booker.app.maroos.branches.application.create.CreateBranchRequest;
import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.*;
import booker.app.maroos.branches.infrastructure.persistence.InMemoryBranchRepository;
import booker.app.shared.domain.bus.event.EventBus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.Mockito.*;

class AddTableToBranchUseCaseTest{

    @Test
    void Search_a_non_existent_branch(){
        BranchRepository repository = mock(BranchRepository.class);

        AddTableToBranchUseCase useCase = new AddTableToBranchUseCase(repository);

        CreateTableRequest request = new CreateTableRequest(
                "085a946a-f098-4f83-bb81",
                1,
                4
        );

        BranchId branchId = new BranchId(request.branchId());

        try{
            useCase.addTableBranch(request);
            Assert.assertTrue(false);
        }catch (Exception e){
            verify(repository, atLeastOnce()).search(branchId);
            Assert.assertEquals(e.getMessage(), "there is not branches with aggregateId "+ request.branchId());
        }
    }

    @Test
    void Add_a_table_to_existing_branch() throws Exception {

        InMemoryBranchRepository repository = new InMemoryBranchRepository();
        EventBus eventBus = mock(EventBus.class);

        BranchCreatorUseCase branchCreatorUseCase = new BranchCreatorUseCase(repository, eventBus);

        CreateBranchRequest createBranchRequest = new CreateBranchRequest(
            "1aab45ba-3c7a-4344-8936-78466eca77fa",
            "1aab45ba-3c7a-4344-8924-78466eca77ed",
            "cll 101 bb # 36-54",
            "3008985426",
            "http://imagen.jpg",
            "08:00",
            "22:00"
        );

        BranchId branchId = new BranchId(createBranchRequest.branchId());

        branchCreatorUseCase.create(createBranchRequest);

        CreateTableRequest createTableRequest = new CreateTableRequest(createBranchRequest.branchId(), 1, 4);

        AddTableToBranchUseCase addTableToBranchUseCase = new AddTableToBranchUseCase(repository);
        addTableToBranchUseCase.addTableBranch(createTableRequest);
        Optional<Branch> branchFounded = repository.search(branchId);
        Assert.assertEquals(branchFounded.get().tables().size(), 1);
    }

    @Test
    void Add_three_tables_to_existing_branch() throws Exception {

        InMemoryBranchRepository repository = new InMemoryBranchRepository();
        EventBus eventBus = mock(EventBus.class);

        BranchCreatorUseCase branchCreatorUseCase = new BranchCreatorUseCase(repository, eventBus);

        CreateBranchRequest createBranchRequest = new CreateBranchRequest(
            "1aab45ba-3c7a-4344-8936-78466eca77fa",
            "1aab45ba-3c7a-4344-8924-78466eca77ed",
            "cll 101 bb # 36-54",
            "3008985426",
            "http://imagen.jpg",
            "08:00",
            "22:00"
        );

        BranchId branchId = new BranchId(createBranchRequest.branchId());

        branchCreatorUseCase.create(createBranchRequest);

        CreateTableRequest createTableRequest1 = new CreateTableRequest(createBranchRequest.branchId(), 1, 4);
        CreateTableRequest createTableRequest2 = new CreateTableRequest(createBranchRequest.branchId(), 2, 8);
        CreateTableRequest createTableRequest3 = new CreateTableRequest(createBranchRequest.branchId(), 3, 12);

        AddTableToBranchUseCase addTableToBranchUseCase = new AddTableToBranchUseCase(repository);
        addTableToBranchUseCase.addTableBranch(createTableRequest1);
        addTableToBranchUseCase.addTableBranch(createTableRequest2);
        addTableToBranchUseCase.addTableBranch(createTableRequest3);
        Optional<Branch> branchFounded = repository.search(branchId);
        Assert.assertEquals(branchFounded.get().tables().size(), 3 );
    }
}