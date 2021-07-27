package booker.app.maroos.branches.application.create;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.branches.domain.vo.BranchLocation;
import booker.app.maroos.branches.domain.vo.BranchPhone;
import booker.app.maroos.branches.domain.vo.BranchPicture;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.BranchCreatedDomainEvent;
import booker.app.shared.domain.bus.event.EventBus;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BranchCreatorUseCaseTest {

    @Test
    void create_a_branch(){
        BranchRepository repository = mock(BranchRepository.class);
        EventBus eventBus = mock(EventBus.class);

        BranchCreatorUseCase useCase = new BranchCreatorUseCase(repository, eventBus);


        CreateBranchRequest request = new CreateBranchRequest(
                "1aab45ba-3c7a-4344-8936-78466eca77fa",
                "1aab45ba-3c7a-4344-8924-78466eca77ed",
                "cll 101 bb # 36-54",
                "3008985426",
                "http://imagen.jpg"
        );

        Branch branch = new Branch(
          new BranchId(request.branchId()),
          new RestaurantId(request.restaurantId()),
          new BranchLocation(request.branchLocation()),
          new BranchPhone(request.branchPhone()),
          new BranchPicture(request.branchPicture())
        );

        BranchCreatedDomainEvent domainEvent = new BranchCreatedDomainEvent(
                request.branchId(),
                request.restaurantId(),
                request.branchLocation(),
                request.branchPhone(),
                request.branchPicture()
        );

        useCase.create(request);

        verify(repository, atLeastOnce()).save(branch);
        verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));

    }


}