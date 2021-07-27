package booker.app.maroos.branches.application.create;

import booker.app.maroos.branches.domain.Branch;
import booker.app.maroos.branches.domain.BranchRepository;
import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.branches.domain.vo.BranchLocation;
import booker.app.maroos.branches.domain.vo.BranchPhone;
import booker.app.maroos.branches.domain.vo.BranchPicture;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.EventBus;

@Service
public class BranchCreatorUseCase {

    private final BranchRepository repository;
    private final EventBus eventBus;

    public BranchCreatorUseCase(BranchRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void create(CreateBranchRequest request){

        BranchId branchId = new BranchId(request.branchId());
        RestaurantId restaurantId = new RestaurantId(request.restaurantId());
        BranchLocation branchLocation = new BranchLocation(request.branchLocation());
        BranchPhone branchPhone = new BranchPhone(request.branchPhone());
        BranchPicture branchPicture = new BranchPicture(request.branchPicture());

        Branch branch = Branch.create(
            branchId,
            restaurantId,
            branchLocation,
            branchPhone,
            branchPicture
        );

        repository.save(branch);
        eventBus.publish(branch.pullDomainEvents());
    }
}
