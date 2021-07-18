package booker.app.maroos.restaurants;

import booker.app.maroos.restaurants.infrastructure.persistence.InMemoryRestaurantRepository;
import booker.app.shared.infrastructure.InfrastructureTestCase;
import org.springframework.beans.factory.annotation.Autowired;

public class RestaurantsModuleInfrastructureTest extends InfrastructureTestCase {
    @Autowired
    protected InMemoryRestaurantRepository inMemoryRestaurantRepository;
}
