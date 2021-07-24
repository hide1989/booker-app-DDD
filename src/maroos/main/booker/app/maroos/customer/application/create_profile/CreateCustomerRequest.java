package booker.app.maroos.customer.application.create_profile;

import java.util.Objects;

public class CreateCustomerRequest {

    private final String customerId;
    private final String customerName;
    private final String customerPhone;
    private final String customerEmail;
    private final String customerPassword;
    private final String customerBirthDay;

    public CreateCustomerRequest(String customerId, String customerName, String customerPhone, String customerEmail, String customerPassword, String customerBirthDay) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerBirthDay = customerBirthDay;
    }

    public String customerId() {
        return customerId;
    }

    public String customerName() {
        return customerName;
    }

    public String customerPhone() {
        return customerPhone;
    }

    public String customerEmail() {
        return customerEmail;
    }

    public String customerPassword() {
        return customerPassword;
    }

    public String customerBirthDay() {
        return customerBirthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateCustomerRequest)) return false;
        CreateCustomerRequest that = (CreateCustomerRequest) o;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(customerName, that.customerName) &&
                Objects.equals(customerPhone, that.customerPhone) &&
                Objects.equals(customerEmail, that.customerEmail) &&
                Objects.equals(customerPassword, that.customerPassword) &&
                Objects.equals(customerBirthDay, that.customerBirthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerPhone, customerEmail, customerPassword, customerBirthDay);
    }
}
