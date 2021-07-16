package booker.app.app.maroos.controllers.restaurants;

import booker.app.maroos.restaurants.application.create.CreateRestaurantRequest;
import booker.app.maroos.restaurants.application.create.RestaurantCreatorUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantPutController {

    private final RestaurantCreatorUseCase restaurantCreatorUseCase;

    public RestaurantPutController(RestaurantCreatorUseCase restaurantCreatorUseCase) {
        this.restaurantCreatorUseCase = restaurantCreatorUseCase;
    }

    @PutMapping("/create/{id}")
    public ResponseEntity create(@PathVariable("id") String id, @RequestBody Request request){


        restaurantCreatorUseCase.create(
                new CreateRestaurantRequest(
                        id,
                        request.restaurantName(),
                        request.restaurantAbstarct(),
                        request.restaurantSpecialities(),
                        request.restaurantSlogan(),
                        request.restaurantLogo(),
                        request.restaurantWebSite(),
                        request.restaurantPhone()
                )
        );
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

final class Request {
    private String restaurantName;
    private String restaurantAbstarct;
    private String restaurantSpecialities;
    private String restaurantSlogan;
    private String restaurantLogo;
    private String restaurantWebSite;
    private String restaurantPhone;

    public String restaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String restaurantAbstarct() {
        return restaurantAbstarct;
    }

    public void setRestaurantAbstarct(String restaurantAbstarct) {
        this.restaurantAbstarct = restaurantAbstarct;
    }

    public String restaurantSpecialities() {
        return restaurantSpecialities;
    }

    public void setRestaurantSpecialities(String restaurantSpecialities) {
        this.restaurantSpecialities = restaurantSpecialities;
    }

    public String restaurantSlogan() {
        return restaurantSlogan;
    }

    public void setRestaurantSlogan(String restaurantSlogan) {
        this.restaurantSlogan = restaurantSlogan;
    }

    public String restaurantLogo() {
        return restaurantLogo;
    }

    public void setRestaurantLogo(String restaurantLogo) {
        this.restaurantLogo = restaurantLogo;
    }

    public String restaurantWebSite() {
        return restaurantWebSite;
    }

    public void setRestaurantWebSite(String restaurantWebSite) {
        this.restaurantWebSite = restaurantWebSite;
    }

    public String restaurantPhone() {
        return restaurantPhone;
    }

    public void restaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }
}
