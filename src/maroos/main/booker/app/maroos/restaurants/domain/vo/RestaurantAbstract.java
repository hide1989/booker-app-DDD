package booker.app.maroos.restaurants.domain.vo;

import booker.app.shared.domain.StringValueObject;

public class RestaurantAbstract extends StringValueObject {
    public RestaurantAbstract(String value) {
        super(value);
    }

    private RestaurantAbstract() {
        super("");
    }
}
