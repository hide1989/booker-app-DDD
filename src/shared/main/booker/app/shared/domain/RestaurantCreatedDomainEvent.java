package booker.app.shared.domain;

import booker.app.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public final class RestaurantCreatedDomainEvent extends DomainEvent {

    private final String restaurantName;
    private final String restaurantAbstract;
    private final String restaurantSpecialities;
    private final String restaurantSlogan;
    private final String restaurantLogo;
    private final String restaurantWebSite;
    private final String restaurantPhone;

    public RestaurantCreatedDomainEvent(String aggregateId, String restaurantName, String restaurantAbstract, String restaurantSpecialities, String restaurantSlogan, String restaurantLogo, String restaurantWebSite, String restaurantPhone) {
        super(aggregateId);
        this.restaurantName = restaurantName;
        this.restaurantAbstract = restaurantAbstract;
        this.restaurantSpecialities = restaurantSpecialities;
        this.restaurantSlogan = restaurantSlogan;
        this.restaurantLogo = restaurantLogo;
        this.restaurantWebSite = restaurantWebSite;
        this.restaurantPhone = restaurantPhone;
    }

    public RestaurantCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String restaurantName, String restaurantAbstract, String restaurantSpecialities, String restaurantSlogan, String restaurantLogo, String restaurantWebSite, String restaurantPhone) {
        super(aggregateId, eventId, occurredOn);
        this.restaurantName = restaurantName;
        this.restaurantAbstract = restaurantAbstract;
        this.restaurantSpecialities = restaurantSpecialities;
        this.restaurantSlogan = restaurantSlogan;
        this.restaurantLogo = restaurantLogo;
        this.restaurantWebSite = restaurantWebSite;
        this.restaurantPhone = restaurantPhone;
    }

    @Override
    protected String eventName() {
        return "restaurant.created";
    }

    @Override
    protected HashMap<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>(){{
            put("restaurantName",restaurantName);
            put("restaurantAbstract",restaurantAbstract);
            put("restaurantSpecialities",restaurantSpecialities);
            put("restaurantSlogan",restaurantSlogan);
            put("restaurantLogo",restaurantLogo);
            put("restaurantWebSite",restaurantWebSite);
            put("restaurantPhone",restaurantPhone);
        }};
    }

    @Override
    protected DomainEvent<?> fromPrimitives(String aggregateId, HashMap body, String eventId, String occurredOn) {
        return new RestaurantCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("restaurantName"),
                (String) body.get("restaurantAbstract"),
                (String) body.get("restaurantSpecialities"),
                (String) body.get("restaurantSlogan"),
                (String) body.get("restaurantLogo"),
                (String) body.get("restaurantWebSite"),
                (String) body.get("restaurantPhone")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RestaurantCreatedDomainEvent)) return false;
        RestaurantCreatedDomainEvent that = (RestaurantCreatedDomainEvent) o;
        return Objects.equals(restaurantName, that.restaurantName) &&
                Objects.equals(restaurantAbstract, that.restaurantAbstract) &&
                Objects.equals(restaurantSpecialities, that.restaurantSpecialities) &&
                Objects.equals(restaurantSlogan, that.restaurantSlogan) &&
                Objects.equals(restaurantLogo, that.restaurantLogo) &&
                Objects.equals(restaurantWebSite, that.restaurantWebSite) &&
                Objects.equals(restaurantPhone, that.restaurantPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantName, restaurantAbstract, restaurantSpecialities, restaurantSlogan, restaurantLogo, restaurantWebSite, restaurantPhone);
    }
}
