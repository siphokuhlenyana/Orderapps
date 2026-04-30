/*
Author : Siphokuhle Nyana
25/04/26
CustomerFactory.java
 */

package za.ac.cput.orderapps.factory;


import za.ac.cput.orderapps.domain.CustomerName;
import za.ac.cput.orderapps.domain.Customer;


public class CustomerFactory {
    public static Customer createCustomer(String patientId, CustomerName name, String email, String mobileNumber) {
        return new Customer.Builder()
                .setPatientID(patientId)
                .setCustomerName(name)
                .setEmail(email)
                .setMobileNumber(mobileNumber)
                .build();
    }
}
