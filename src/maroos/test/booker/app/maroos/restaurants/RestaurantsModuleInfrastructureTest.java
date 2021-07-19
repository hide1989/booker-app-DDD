package booker.app.maroos.restaurants;

import booker.app.maroos.MaroosContextInfrastructuraTestCase;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.infrastructure.persistence.InMemoryRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class RestaurantsModuleInfrastructureTest extends MaroosContextInfrastructuraTestCase {
    protected InMemoryRestaurantRepository inMemoryRestaurantRepository;

    @Autowired
    protected RestaurantRepository mySqlRestaurantRepository;

}
