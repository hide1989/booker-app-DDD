package booker.app.maroos.restaurants.infrastructure.persistence;

import booker.app.maroos.restaurants.RestaurantsModuleInfrastructureTest;
import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.vo.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional //permite realizar un Rollback de las consultas ejecutadas en cada test
class MySqlRestaurantRepositoryTest extends RestaurantsModuleInfrastructureTest {

    Restaurant restaurant;

    @BeforeEach
    void setup(){
        restaurant =  new Restaurant(
                new RestaurantId("123456789"),
                new RestaurantName("El Mejor"),
                new RestaurantAbstract("lo mejor de lo mejor"),
                new RestaurantSpecialities("Mediterranea"),
                new RestaurantSlogan("lo que hay es lo mejor"),
                new RestaurantLogo("http://logo.jpg"),
                new RestaurantWebSite("http://sitioweb.com.co"),
                new RestaurantPhone("3046518")
        );
    }

    @Test
    void save_a_restaurant() {
        mySqlRestaurantRepository.save(restaurant);
    }

    @Test
    void search_an_existing_restaurant(){
        mySqlRestaurantRepository.save(restaurant);
        Optional<Restaurant> expectedRestaurant = mySqlRestaurantRepository.search(restaurant.restaurantId());
        Assert.assertEquals(Optional.of(restaurant), expectedRestaurant);
    }

    @Test
    void if_not_exist_restaurant(){
        String noExistentRestaurantId = "5663456345";
        boolean hasRestaurant = mySqlRestaurantRepository.search(new RestaurantId(noExistentRestaurantId)).isPresent();
        Assert.assertFalse(hasRestaurant);
    }
}