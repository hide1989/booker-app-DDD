package booker.app.maroos.restaurants.infrastructure.persistence;

import booker.app.maroos.restaurants.domain.Restaurant;
import booker.app.maroos.restaurants.domain.RestaurantRepository;
import booker.app.maroos.restaurants.domain.vo.RestaurantId;
import booker.app.shared.domain.Service;
import org.hibernate.SessionFactory;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class MySqlRestaurantRepository implements RestaurantRepository {

    private SessionFactory sessionFactory;

    public MySqlRestaurantRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional //toda query debe tener la anotacion @Transaccional
    public void save(Restaurant restaurant) {
        sessionFactory.getCurrentSession().save(restaurant);
    }

    @Override
    public Optional<Restaurant> search(RestaurantId restaurantId) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().find(Restaurant.class, restaurantId));
    }
}
