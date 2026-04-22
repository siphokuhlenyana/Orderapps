package za.ac.cput.orderapps.factory;

import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Order;
public class OrderFactory {
    public static Order createOrder(String id, CustomerName name, double amount) {
        return new Order.Builder()
                .setOrderId(id)
                .setCustomerName(name)
                .setAmount(amount)
                .build();
    }
}
