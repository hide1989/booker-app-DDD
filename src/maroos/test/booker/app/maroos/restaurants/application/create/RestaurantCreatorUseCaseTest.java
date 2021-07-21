package booker.app.maroos.restaurants.application.create;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.*;
import booker.app.shared.domain.RestaurantCreatedDomainEvent;
import booker.app.shared.domain.bus.event.EventBus;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.mockito.Mockito.*;

class RestaurantCreatorUseCaseTest {


    @Test
    void save_a_restaurant() throws Exception{
        RestaurantRepository repository = mock(RestaurantRepository.class);
        EventBus eventBus = mock(EventBus.class);
        RestaurantCreatorUseCase useCase = new RestaurantCreatorUseCase(repository, eventBus);

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
        RestaurantCreatedDomainEvent domainEvent = new RestaurantCreatedDomainEvent(
                request.restaurantId(),
                request.restaurantName(),
                request.restaurantAbstarct(),
                request.restaurantSpecialities(),
                request.restaurantSlogan(),
                request.restaurantLogo(),
                request.restaurantWebSite(),
                request.restaurantPhone()
        );

        useCase.create(request);

        verify(repository, atLeastOnce()).save(restaurant);
        verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));
    }

}