package booker.app.shared.domain;

import booker.app.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class BranchCreatedDomainEvent extends DomainEvent {

    private final String restaurantId;
    private final String branchLocation;
    private final String branchPhone;
    private final String branchPicture;
    private final String openDoors;
    private final String closeDoors;

    public BranchCreatedDomainEvent(String aggregateId, String restaurantId, String branchLocation, String branchPhone, String branchPicture, String openDoors, String closeDoors) {
        super(aggregateId);
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
        this.openDoors = openDoors;
        this.closeDoors = closeDoors;
    }

    public BranchCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String restaurantId, String branchLocation, String branchPhone, String branchPicture, String openDoors, String closeDoors) {
        super(aggregateId, eventId, occurredOn);
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
        this.openDoors = openDoors;
        this.closeDoors = closeDoors;
    }

    @Override
    protected String eventName() {
        return "Branch.created";
    }

    @Override
    protected HashMap<String, Serializable> toPrimitives() {
        return null;
    }

    @Override
    protected DomainEvent<?> fromPrimitives(String aggregateId, HashMap body, String eventId, String occurredOn) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BranchCreatedDomainEvent)) return false;
        BranchCreatedDomainEvent that = (BranchCreatedDomainEvent) o;
        return Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(branchLocation, that.branchLocation) &&
                Objects.equals(branchPhone, that.branchPhone) &&
                Objects.equals(branchPicture, that.branchPicture) &&
                Objects.equals(openDoors, that.openDoors) &&
                Objects.equals(closeDoors, that.closeDoors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, branchLocation, branchPhone, branchPicture, openDoors, closeDoors);
    }
}
