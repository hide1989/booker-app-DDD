package booker.app.maroos.branches.domain;

import booker.app.maroos.branches.domain.vo.BranchId;
import booker.app.maroos.branches.domain.vo.BranchLocation;
import booker.app.maroos.branches.domain.vo.BranchPhone;
import booker.app.maroos.branches.domain.vo.BranchPicture;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.AggregateRoot;
import booker.app.shared.domain.BranchCreatedDomainEvent;

import java.util.Objects;

public class Branch extends AggregateRoot {

    private final BranchId branchId;
    private final RestaurantId restaurantId;
    private final BranchLocation branchLocation;
    private final BranchPhone branchPhone;
    private final BranchPicture branchPicture;

    public Branch(BranchId branchId, RestaurantId restaurantId, BranchLocation branchLocation, BranchPhone branchPhone, BranchPicture branchPicture) {
        this.branchId = branchId;
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
    }

    private Branch(){
        this.branchId = null;
        this.restaurantId = null;
        this.branchLocation = null;
        this.branchPhone = null;
        this.branchPicture = null;
    }

    public BranchId branchId() {
        return branchId;
    }

    public RestaurantId restaurantId() {
        return restaurantId;
    }

    public BranchLocation branchLocation() {
        return branchLocation;
    }

    public BranchPhone branchPhone() {
        return branchPhone;
    }

    public BranchPicture branchPicture() {
        return branchPicture;
    }

    public static Branch create(
            BranchId branchId,
            RestaurantId restaurantId,
            BranchLocation branchLocation,
            BranchPhone branchPhone,
            BranchPicture branchPicture
    ){
        Branch branch = new Branch(branchId, restaurantId, branchLocation, branchPhone, branchPicture);

        branch.record(new BranchCreatedDomainEvent(
                branchId.value(),
                restaurantId.value(),
                branchLocation.value(),
                branchPhone.value(),
                branchPicture.value()
        ));

        return branch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchId, branch.branchId) &&
                Objects.equals(restaurantId, branch.restaurantId) &&
                Objects.equals(branchLocation, branch.branchLocation) &&
                Objects.equals(branchPhone, branch.branchPhone) &&
                Objects.equals(branchPicture, branch.branchPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, restaurantId, branchLocation, branchPhone, branchPicture);
    }
}
