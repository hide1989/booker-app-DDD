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

    public BranchCreatedDomainEvent(String aggregateId, String restaurantId, String branchLocation, String branchPhone, String branchPicture) {
        super(aggregateId);
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
    }

    public BranchCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String restaurantId, String branchLocation, String branchPhone, String branchPicture) {
        super(aggregateId, eventId, occurredOn);
        this.restaurantId = restaurantId;
        this.branchLocation = branchLocation;
        this.branchPhone = branchPhone;
        this.branchPicture = branchPicture;
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
                Objects.equals(branchPicture, that.branchPicture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, branchLocation, branchPhone, branchPicture);
    }
}
