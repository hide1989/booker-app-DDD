package booker.app.maroos.customer.domain;

import booker.app.maroos.customer.domain.vo.*;
import booker.app.shared.domain.AggregateRoot;
import booker.app.shared.domain.CustomerCreatedDomainEvent;

import java.util.Objects;

public final class Customer extends AggregateRoot {

    private final CustomerId customerId;
    private final CustomerName customerName;
    private final CustomerPhone customerPhone;
    private final CustomerEmail customerEmail;
    private final CustomerPassword customerPassword;
    private final CustomerBirthDay customerBirthDay;

    public Customer(CustomerId customerId,
                    CustomerName customerName,
                    CustomerPhone customerPhone,
                    CustomerEmail customerEmail,
                    CustomerPassword customerPassword,
                    CustomerBirthDay customerBirthDay) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerBirthDay = customerBirthDay;
    }

    private Customer(){
        this.customerId = null;
        this.customerName = null;
        this.customerPhone = null;
        this.customerEmail = null;
        this.customerPassword = null;
        this.customerBirthDay = null;
    }

    public static Customer createProfile(
            CustomerId customerId,
            CustomerName customerName,
            CustomerPhone customerPhone,
            CustomerEmail customerEmail,
            CustomerPassword customerPassword,
            CustomerBirthDay customerBirthDay
    ) {

        Customer customer = new Customer(
                customerId,
                customerName,
                customerPhone,
                customerEmail,
                customerPassword,
                customerBirthDay
        );

        customer.record(new CustomerCreatedDomainEvent(
            customerId.value(),
            customerName.value(),
            customerPhone.value(),
            customerEmail.value(),
            customerPassword.value(),
            customerBirthDay.value()
        ));

        return customer;

    }

    public CustomerId CustomerId() {
        return customerId;
    }

    public CustomerName customerName() {
        return customerName;
    }

    public CustomerPhone customerPhone() {
        return customerPhone;
    }

    public CustomerEmail customerEmail() {
        return customerEmail;
    }

    public CustomerPassword customerPassword() {
        return customerPassword;
    }

    public CustomerBirthDay customerBirthDay() {
        return customerBirthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerPhone, customer.customerPhone) &&
                Objects.equals(customerEmail, customer.customerEmail) &&
                Objects.equals(customerPassword, customer.customerPassword) &&
                Objects.equals(customerBirthDay, customer.customerBirthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerPhone, customerEmail, customerPassword, customerBirthDay);
    }
}
