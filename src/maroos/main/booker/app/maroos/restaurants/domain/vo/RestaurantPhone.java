package booker.app.maroos.restaurants.domain.vo;

import booker.app.shared.domain.StringValueObject;

public class RestaurantPhone extends StringValueObject {
    public RestaurantPhone(String value) {
        super(value);
    }

    private RestaurantPhone() {
        super("");
    }
}
