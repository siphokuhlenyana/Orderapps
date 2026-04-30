package za.ac.cput.orderapps.domain;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    private String orderId;

    @Embedded
    private CustomerName customerName;


    private Date date;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.customerName = builder.customerName;
        this.date = builder.date;
    }

    protected Order() {}

    public String getOrderId() { return orderId; }
    public CustomerName getCustomerName() { return customerName; }
    public Date getDate() { return date; }

    public static class Builder {
        private String orderId;
        private CustomerName customerName;
        private Date date;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setCustomerName(CustomerName customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Order build() {
            if (orderId == null || orderId.isEmpty()) return null;
            if (customerName == null) return null;


            return new Order(this);
        }
    }
}
