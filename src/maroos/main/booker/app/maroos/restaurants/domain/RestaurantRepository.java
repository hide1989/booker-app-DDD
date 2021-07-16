package booker.app.maroos.restaurants.domain;

import booker.app.maroos.restaurants.domain.vo.RestaurantId;

import java.util.Optional;

public interface RestaurantRepository {

    void save(Restaurant restaurant);

    Optional<Restaurant> search(RestaurantId restaurantId);
}
