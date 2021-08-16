package booker.app.maroos.branches.domain;

import booker.app.maroos.branches.domain.vo.*;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.AggregateRoot;
import booker.app.shared.domain.BranchCreatedDomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Branch extends AggregateRoot {

    private final BranchId branchId;
    private final RestaurantId restaurantId;
    private final BranchLocation branchLocation;
    private final BranchPhone branchPhone;
    private final BranchPicture branchPicture;
    private final TimeRange timeRange;
    private List<Table> tables;

    public Branch(BranchId branchId, RestaurantId restaurantId, BranchLocation branchLocation, BranchPhone branchPhone, BranchPicture branchPicture, TimeRange timeRange) {
        this.branchId = branchId;
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
        this.timeRange = timeRange;
        this.tables = new ArrayList<>();
    }

    private Branch(){
        this.branchId = null;
        this.restaurantId = null;
        this.branchLocation = null;
        this.branchPhone = null;
        this.branchPicture = null;
        this.timeRange = null;
        this.tables = null;
    }

    public List<Table> tables() {
        return tables;
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

    public TimeRange timeRange() {
        return timeRange;
    }

    public static Branch create(
            BranchId branchId,
            RestaurantId restaurantId,
            BranchLocation branchLocation,
            BranchPhone branchPhone,
            BranchPicture branchPicture,
            TimeRange timeRange
    ){
        Branch branch = new Branch(branchId, restaurantId, branchLocation, branchPhone, branchPicture, timeRange);

        branch.record(new BranchCreatedDomainEvent(
            branchId.value(),
            restaurantId.value(),
            branchLocation.value(),
            branchPhone.value(),
            branchPicture.value(),
            timeRange.openDoors(),
            timeRange.closeDoors()
            )
        );

        return branch;
    }

    public List<Table> addTable(Table table){

        this.tables.add(table);

        return tables;
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
                Objects.equals(branchPicture, branch.branchPicture) &&
                Objects.equals(timeRange, branch.timeRange) &&
                Objects.equals(tables, branch.tables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, restaurantId, branchLocation, branchPhone, branchPicture, timeRange, tables);
    }
}
