package booker.app.maroos.restaurants.domain.vo;

import booker.app.shared.domain.Identifier;

public class RestaurantId extends Identifier {

    public RestaurantId(String value) {
        super(value);
    }

    private RestaurantId() {
        super("");
    }
}
