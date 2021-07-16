package booker.app.maroos.restaurants.application.create;

import java.util.Objects;

public class CreateRestaurantRequest {

    private final String restaurantId;
    private final String restaurantName;
    private final String restaurantAbstarct;
    private final String restaurantSpecialities;
    private final String restaurantSlogan;
    private final String restaurantLogo;
    private final String restaurantWebSite;
    private final String restaurantPhone;

    public CreateRestaurantRequest(String restaurantId, String restaurantName, String restaurantAbstarct, String restaurantSpecialities, String restaurantSlogan, String restaurantLogo, String restaurantWebSite, String restaurantPhone) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.restaurantAbstarct = restaurantAbstarct;
        this.restaurantSpecialities = restaurantSpecialities;
        this.restaurantSlogan = restaurantSlogan;
        this.restaurantLogo = restaurantLogo;
        this.restaurantWebSite = restaurantWebSite;
        this.restaurantPhone = restaurantPhone;
    }

    public String restaurantId() {
        return restaurantId;
    }

    public String restaurantName() {
        return restaurantName;
    }

    public String restaurantAbstarct() {
        return restaurantAbstarct;
    }

    public String restaurantSpecialities() {
        return restaurantSpecialities;
    }

    public String restaurantSlogan() {
        return restaurantSlogan;
    }

    public String restaurantLogo() {
        return restaurantLogo;
    }

    public String restaurantWebSite() {
        return restaurantWebSite;
    }

    public String restaurantPhone() {
        return restaurantPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateRestaurantRequest)) return false;
        CreateRestaurantRequest request = (CreateRestaurantRequest) o;
        return Objects.equals(restaurantId, request.restaurantId) &&
                Objects.equals(restaurantName, request.restaurantName) &&
                Objects.equals(restaurantAbstarct, request.restaurantAbstarct) &&
                Objects.equals(restaurantSpecialities, request.restaurantSpecialities) &&
                Objects.equals(restaurantSlogan, request.restaurantSlogan) &&
                Objects.equals(restaurantLogo, request.restaurantLogo) &&
                Objects.equals(restaurantWebSite, request.restaurantWebSite) &&
                Objects.equals(restaurantPhone, request.restaurantPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, restaurantName, restaurantAbstarct, restaurantSpecialities, restaurantSlogan, restaurantLogo, restaurantWebSite, restaurantPhone);
    }
}
