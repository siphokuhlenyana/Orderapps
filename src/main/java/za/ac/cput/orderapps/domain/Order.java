package za.ac.cput.orderapps.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;

    @Embedded
    private CustomerName customerName;

    private double amount;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customerName = builder.customerName;
        this.amount = builder.amount;
    }

    protected Order() {}

    public String getOrderId() { return orderId; }
    public CustomerName getCustomerName() { return customerName; }
    public double getAmount() { return amount; }

    public static class Builder {
        private String orderId;
        private CustomerName customerName;
        private double amount;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setCustomerName(CustomerName customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Order build() {
            if (orderId == null || orderId.isEmpty()) return null;
            if (customerName == null) return null;
            if (amount <= 0) return null;

            return new Order(this);
        }
    }
}
