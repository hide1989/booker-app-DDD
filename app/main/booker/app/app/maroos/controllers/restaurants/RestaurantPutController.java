package booker.app.app.maroos.controllers.restaurants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantPutController {

    @PutMapping("/create/{id}")
    public ResponseEntity create(@PathVariable("id") String id, @RequestBody Request request){

        return new ResponseEntity(HttpStatus.CREATED);
    }
}

final class Request {
    private String restaurantName;
    private String restaurantAbstarct;
    private String restauratSpecialities;
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

    public String restauratSpecialities() {
        return restauratSpecialities;
    }

    public void setRestauratSpecialities(String restauratSpecialities) {
        this.restauratSpecialities = restauratSpecialities;
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
