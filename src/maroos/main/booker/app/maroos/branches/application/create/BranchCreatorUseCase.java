package booker.app.maroos.branches.application.create;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.*;
import booker.app.maroos.branches.infrastructure.persistence.InMemoryBranchRepository;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.EventBus;

import java.text.ParseException;

@Service
public class BranchCreatorUseCase {

    private final InMemoryBranchRepository repository;
    private final EventBus eventBus;

    public BranchCreatorUseCase(InMemoryBranchRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CreateBranchRequest request) throws ParseException {

        BranchId branchId = new BranchId(request.branchId());
        RestaurantId restaurantId = new RestaurantId(request.restaurantId());
        BranchLocation branchLocation = new BranchLocation(request.branchLocation());
        BranchPhone branchPhone = new BranchPhone(request.branchPhone());
        BranchPicture branchPicture = new BranchPicture(request.branchPicture());
        TimeRange timeRange = new TimeRange(request.openDoors(), request.closeDoors());

        Branch branch = Branch.create(
            branchId,
            restaurantId,
            branchLocation,
            branchPhone,
            branchPicture,
            timeRange
        );

        repository.save(branch);
        eventBus.publish(branch.pullDomainEvents());
    }
}
