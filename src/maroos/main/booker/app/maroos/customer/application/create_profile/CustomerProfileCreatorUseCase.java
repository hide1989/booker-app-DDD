package booker.app.maroos.customer.application.create_profile;

import booker.app.maroos.customer.CustomerRepository;
import booker.app.maroos.customer.domain.Customer;
import booker.app.maroos.customer.domain.CustomerBirthDay;
import booker.app.maroos.customer.domain.vo.*;
import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.EventBus;

@Service
public class CustomerProfileCreatorUseCase {

    private final CustomerRepository repository;
    private final EventBus eventBus;

    public CustomerProfileCreatorUseCase(CustomerRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void createProfile(CreateCustomerRequest request){

        CustomerId customerId = new CustomerId(request.customerId());
        CustomerName customerName = new CustomerName(request.customerName());
        CustomerPhone customerPhone = new CustomerPhone(request.customerPhone());
        CustomerEmail customerEmail = new CustomerEmail(request.customerEmail());
        CustomerPassword customerPassword = new CustomerPassword(request.customerPassword());
        CustomerBirthDay customerBirthDay  = new CustomerBirthDay(request.customerBirthDay());

        Customer customer = Customer.createProfile(
            customerId,
            customerName,
            customerPhone,
            customerEmail,
            customerPassword,
            customerBirthDay
        );

        repository.save(customer);
        eventBus.publish(customer.pullDomainEvents());
    }
}
