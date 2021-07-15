package booker.app.maroos.restaurants.domain;

import booker.app.maroos.restaurants.domain.vo.*;

import java.util.Objects;

public final class Restaurant {

    private final RestaurantId restaurantId;
    private final RestaurantName restaurantName;
    private final RestaurantAbstract restaurantAbstract;
    private final RestaurantSpecialities restaurantSpecialities;
    private final RestaurantSlogan restaurantSlogan;
    private final RestaurantLogo restaurantLogo;
    private final RestaurantWebSite restaurantWebSite;
    private final RestaurantPhone restaurantPhone;

    public Restaurant(
            RestaurantId restaurantId,
            RestaurantName restaurantName,
            RestaurantAbstract restaurantAbstract,
            RestaurantSpecialities restaurantSpecialities,
            RestaurantSlogan restaurantSlogan,
            RestaurantLogo restaurantLogo,
            RestaurantWebSite restaurantWebSite,
            RestaurantPhone restaurantPhone) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAbstract = restaurantAbstract;
        this.restaurantSpecialities = restaurantSpecialities;
        this.restaurantSlogan = restaurantSlogan;
        this.restaurantLogo = restaurantLogo;
        this.restaurantWebSite = restaurantWebSite;
        this.restaurantPhone = restaurantPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(restaurantId, that.restaurantId) &&
                Objects.equals(restaurantName, that.restaurantName) &&
                Objects.equals(restaurantAbstract, that.restaurantAbstract) &&
                Objects.equals(restaurantSpecialities, that.restaurantSpecialities) &&
                Objects.equals(restaurantSlogan, that.restaurantSlogan) &&
                Objects.equals(restaurantLogo, that.restaurantLogo) &&
                Objects.equals(restaurantWebSite, that.restaurantWebSite) &&
                Objects.equals(restaurantPhone, that.restaurantPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, restaurantName, restaurantAbstract, restaurantSpecialities, restaurantSlogan, restaurantLogo, restaurantWebSite, restaurantPhone);
    }
}
