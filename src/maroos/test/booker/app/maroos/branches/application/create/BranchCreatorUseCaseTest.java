package booker.app.maroos.branches.application.create;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.vo.*;
import booker.app.maroos.branches.infrastructure.persistence.InMemoryBranchRepository;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.BranchCreatedDomainEvent;
import booker.app.shared.domain.bus.event.EventBus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Optional;

import static org.mockito.Mockito.*;

class BranchCreatorUseCaseTest {

    @Test
    void create_a_branch() throws ParseException {
        InMemoryBranchRepository repository = mock(InMemoryBranchRepository.class);
        EventBus eventBus = mock(EventBus.class);

        BranchCreatorUseCase useCase = new BranchCreatorUseCase(repository, eventBus);


        CreateBranchRequest request = new CreateBranchRequest(
            "1aab45ba-3c7a-4344-8936-78466eca77fa",
            "1aab45ba-3c7a-4344-8924-78466eca77ed",
            "cll 101 bb # 36-54",
            "3008985426",
            "http://imagen.jpg",
            "08:00",
            "22:00"
        );

        Branch branch = new Branch(
          new BranchId(request.branchId()),
          new RestaurantId(request.restaurantId()),
          new BranchLocation(request.branchLocation()),
          new BranchPhone(request.branchPhone()),
          new BranchPicture(request.branchPicture()),
          new TimeRange(request.openDoors(), request.closeDoors())
        );

        BranchCreatedDomainEvent domainEvent = new BranchCreatedDomainEvent(
            request.branchId(),
            request.restaurantId(),
            request.branchLocation(),
            request.branchPhone(),
            request.branchPicture(),
            request.openDoors(),
            request.closeDoors()
        );

        useCase.create(request);

        verify(repository, atLeastOnce()).save(branch);
        //verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));
    }

    @Test
    void search_a_existing_branch() throws ParseException {

        InMemoryBranchRepository repository = new InMemoryBranchRepository();
        EventBus eventBus = mock(EventBus.class);

        BranchCreatorUseCase useCase = new BranchCreatorUseCase(repository, eventBus);


        CreateBranchRequest request = new CreateBranchRequest(
                "1aab45ba-3c7a-4344-8936-78466eca77fa",
                "1aab45ba-3c7a-4344-8924-78466eca77ed",
                "cll 101 bb # 36-54",
                "3008985426",
                "http://imagen.jpg",
                "08:00",
                "22:00"
        );

        Branch branch = new Branch(
                new BranchId(request.branchId()),
                new RestaurantId(request.restaurantId()),
                new BranchLocation(request.branchLocation()),
                new BranchPhone(request.branchPhone()),
                new BranchPicture(request.branchPicture()),
                new TimeRange(request.openDoors(), request.closeDoors())
        );

        useCase.create(request);
        Optional<Branch> branchFounded = repository.search(branch.branchId());
        Assert.assertEquals(branchFounded.get(), branch);
    }


}