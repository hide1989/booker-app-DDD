package booker.app.maroos.restaurants.application.create;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.*;
import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.EventBus;

@Service
public final class RestaurantCreatorUseCase {

    private final RestaurantRepository respository;
    private final EventBus eventBus;

    public RestaurantCreatorUseCase(RestaurantRepository respository, EventBus eventBus) {
        this.respository = respository;
        this.eventBus = eventBus;
    }

    public void create(CreateRestaurantRequest request) {

         RestaurantId  restaurantId = new RestaurantId(request.restaurantId());
         RestaurantName  restaurantName = new RestaurantName(request.restaurantName());
         RestaurantAbstract  restaurantAbstract = new RestaurantAbstract(request.restaurantAbstarct());
         RestaurantSpecialities  restaurantSpecialities = new RestaurantSpecialities(request.restaurantSpecialities());
         RestaurantSlogan  restaurantSlogan = new RestaurantSlogan(request.restaurantSlogan());
         RestaurantLogo  restaurantLogo = new RestaurantLogo(request.restaurantLogo());
         RestaurantWebSite  restaurantWebSite = new RestaurantWebSite(request.restaurantWebSite());
         RestaurantPhone  restaurantPhone = new RestaurantPhone(request.restaurantPhone());

         Restaurant restaurant = Restaurant.create(
                 restaurantId,
                 restaurantName,
                 restaurantAbstract,
                 restaurantSpecialities,
                 restaurantSlogan,
                 restaurantLogo,
                 restaurantWebSite,
                 restaurantPhone
         );
        
        respository.save(restaurant);
        eventBus.publish(restaurant.pullDomainEvents());
    }

}
