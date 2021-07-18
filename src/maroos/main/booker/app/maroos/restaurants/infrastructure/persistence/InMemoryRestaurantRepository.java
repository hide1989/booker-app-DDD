package booker.app.maroos.restaurants.infrastructure.persistence;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.Service;

import java.util.HashMap;
import java.util.Optional;


public class InMemoryRestaurantRepository implements RestaurantRepository {

    private final HashMap<RestaurantId, Restaurant> restaurants = new HashMap<>();

    @Override
    public void save(Restaurant restaurant) {
        restaurants.put(restaurant.restaurantId(), restaurant);
    }

    @Override
    public Optional<Restaurant> search(RestaurantId restaurantId) {
        return Optional.ofNullable(restaurants.get(restaurantId));
    }
}
