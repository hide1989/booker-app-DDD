package booker.app.maroos.restaurants.application.create;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.*;
import booker.app.shared.domain.Service;

@Service
public final class RestaurantCreatorUseCase {

    private final RestaurantRepository respository;

    public RestaurantCreatorUseCase(RestaurantRepository respository) {
        this.respository = respository;
    }

    public void create(CreateRestaurantRequest request) {

        Restaurant restaurant = new Restaurant(
                new RestaurantId(request.restaurantId()),
                new RestaurantName(request.restaurantName()),
                new RestaurantAbstract(request.restaurantAbstarct()),
                new RestaurantSpecialities(request.restaurantSpecialities()),
                new RestaurantSlogan(request.restaurantSlogan()),
                new RestaurantLogo(request.restaurantLogo()),
                new RestaurantWebSite(request.restaurantWebSite()),
                new RestaurantPhone(request.restaurantPhone())
        );
        
        respository.save(restaurant);
    }

}
