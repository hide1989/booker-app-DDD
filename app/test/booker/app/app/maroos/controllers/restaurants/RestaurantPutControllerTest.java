package booker.app.app.maroos.controllers.restaurants;

import booker.app.app.maroos.controllers.RequestTestCase;
import org.junit.jupiter.api.Test;

class RestaurantPutControllerTest extends RequestTestCase {

    @Test
    void create_restaurant () throws Exception {
        String body = "{\"restaurantName\":\"El Milenario\",\"restaurantAbstract\":\"Un restaurante que volara tu sentido del gusto\",\"restaurantSpecialities\":\"Comida mediterranea\",\"restaurantSlogan\":\"Barriga llena corazon contento\",\"restaurantLogo\":\"http://imagenrestaurante.online.jpg\",\"restaurantWebSite\":\"http://elrestaurantebonito.com.co\",\"restaurantPhone\":\"300-595-28-63\"}";
        assertRequestWithBody("PUT", "/restaurants/create/1aab45ba-3c7a-4344-8936-78466eca77fa",body, 201);
    }

}