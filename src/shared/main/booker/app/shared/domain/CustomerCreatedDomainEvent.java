package booker.app.shared.domain;

import booker.app.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CustomerCreatedDomainEvent extends DomainEvent {

    private final String customerName;
    private final String customerPhone;
    private final String customerEmail;
    private final String customerPassword;
    private final String customerBirthDay;

    public CustomerCreatedDomainEvent(String aggregateId, String customerName, String customerPhone, String customerEmail, String customerPassword, String customerBirthDay) {
        super(aggregateId);
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerBirthDay = customerBirthDay;
    }

    public CustomerCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String customerName, String customerPhone, String customerEmail, String customerPassword, String customerBirthDay) {
        super(aggregateId, eventId, occurredOn);
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerBirthDay = customerBirthDay;
    }

    @Override
    protected String eventName() {
        return "Customer.Created";
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
        if (!(o instanceof CustomerCreatedDomainEvent)) return false;
        CustomerCreatedDomainEvent that = (CustomerCreatedDomainEvent) o;
        return Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerPhone, that.customerPhone) &&
                Objects.equals(customerEmail, that.customerEmail) &&
                Objects.equals(customerPassword, that.customerPassword) &&
                Objects.equals(customerBirthDay, that.customerBirthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName, customerPhone, customerEmail, customerPassword, customerBirthDay);
    }
}
