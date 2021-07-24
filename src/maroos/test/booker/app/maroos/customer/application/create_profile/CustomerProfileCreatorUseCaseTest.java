package booker.app.maroos.customer.application.create_profile;

import booker.app.maroos.customer.CustomerRepository;
import booker.app.maroos.customer.domain.Customer;
import booker.app.maroos.customer.domain.CustomerBirthDay;
import booker.app.maroos.customer.domain.vo.*;
import booker.app.shared.domain.CustomerCreatedDomainEvent;
import booker.app.shared.domain.bus.event.EventBus;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerProfileCreatorUseCaseTest {

    @Test
    void save_a_valid_customer(){
        CustomerRepository repository = mock(CustomerRepository.class);
        EventBus eventBus = mock(EventBus.class);

        CustomerProfileCreatorUseCase useCase = new CustomerProfileCreatorUseCase(repository, eventBus);

        CreateCustomerRequest request = new CreateCustomerRequest(
                "1aab45ba-3c7a-4344-8936-78466eca77fa",
                "David Esneider Herrera Isaza",
                "3008985445",
                "esneider1504@gmail.com",
                "123456789",
                "24/09/1989"
        );

        Customer customer = new Customer(
            new CustomerId(request.customerId()),
            new CustomerName(request.customerName()),
            new CustomerPhone(request.customerPhone()),
            new CustomerEmail(request.customerEmail()),
            new CustomerPassword(request.customerPassword()),
            new CustomerBirthDay(request.customerBirthDay())
        );

        CustomerCreatedDomainEvent domainEvent = new CustomerCreatedDomainEvent(
            request.customerId(),
            request.customerName(),
            request.customerPhone(),
            request.customerEmail(),
            request.customerPassword(),
            request.customerBirthDay()
        );

        useCase.createProfile(request);

        verify(repository, atLeastOnce()).save(customer);
        verify(eventBus, atLeastOnce()).publish(Collections.singletonList(domainEvent));
    }

}