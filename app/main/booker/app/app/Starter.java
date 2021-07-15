package booker.app.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"booker.app.app", "booker.app.maroos"})
public class Starter {
    public static void main(String[] args){
        SpringApplication.run(Starter.class, args);
    }
}
