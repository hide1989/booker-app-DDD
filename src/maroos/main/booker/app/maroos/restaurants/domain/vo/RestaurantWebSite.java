package booker.app.maroos.restaurants.domain.vo;

import booker.app.shared.domain.StringValueObject;

public class RestaurantWebSite extends StringValueObject {
    public RestaurantWebSite(String value) {
        super(value);
    }

    private RestaurantWebSite() {
        super("");
    }
}
