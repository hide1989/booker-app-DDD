package booker.app.app.maroos.controllers.health_check;

import booker.app.app.maroos.controllers.RequestTestCase;
import org.junit.jupiter.api.Test;

class HealthCheckGetControllerTest extends RequestTestCase {

    @Test
    void check_health_check_is_working() throws Exception {
        assertResponse("/health-check", 200, "{'status':'ok'}");
    }

}