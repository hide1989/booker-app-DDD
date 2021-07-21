package booker.app.maroos.restaurants.domain.vo;

import booker.app.shared.domain.Identifier;

import java.util.UUID;

public class RestaurantId extends Identifier {

    public RestaurantId(String value) {
        super(value);
        ensureValidUuid(value);
    }

    private RestaurantId() {
        super("");
    }

    private void ensureValidUuid(String value) throws IllegalArgumentException {
        UUID.fromString(value);
    }
}
