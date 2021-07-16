package booker.app.maroos.restaurants.application.create;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.*;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class RestaurantCreatorUseCaseTest {


    @Test
    void save_a_restaurant() throws Exception{
        RestaurantRepository repository = mock(RestaurantRepository.class);
        RestaurantCreatorUseCase useCase = new RestaurantCreatorUseCase(repository);

        CreateRestaurantRequest request = new CreateRestaurantRequest(
                "123456789",
                "El Mejor",
                "lo mejor de lo mejor",
                "Mediterranea",
                "lo que hay es lo mejor",
                "http://logo.jpg",
                "http://sitioweb.com.co",
                "3046518"
        );


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

        useCase.create(request);

        verify(repository, atLeastOnce()).save(restaurant);
    }

}