package booker.app.shared.domain.bus.event;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TableCreatedDomainEvent extends DomainEvent {

    private String branchId;
    private String type;
    private Integer chairQuantity;

    public TableCreatedDomainEvent(String aggregateId, String branchId, String type, Integer chairQuantity) {
        super(aggregateId);
        this.branchId = branchId;
        this.type = type;
        this.chairQuantity = chairQuantity;
    }

    public TableCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String branchId, String type, Integer chairQuantity) {
        super(aggregateId, eventId, occurredOn);
        this.branchId = branchId;
        this.type = type;
        this.chairQuantity = chairQuantity;
    }

    @Override
    protected String eventName() {
        return null;
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
        if (!(o instanceof TableCreatedDomainEvent)) return false;
        TableCreatedDomainEvent that = (TableCreatedDomainEvent) o;
        return Objects.equals(branchId, that.branchId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(chairQuantity, that.chairQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchId, type, chairQuantity);
    }
}
