package booker.app.maroos.customer;

import booker.app.maroos.customer.domain.Customer;

public interface CustomerRepository {

    void save(Customer customer);
}
