package za.ac.cput.orderapps.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String patientId;

    @Embedded
    private CustomerName customerName;

    private String email;
    private String mobileNumber;

    private Customer(Builder builder) {
        this.patientId = builder.patientId;
        this.customerName = builder.customerName;
        this.email = builder.email;
        this.mobileNumber = builder.mobileNumber;

    }
//    private Customer(Builder builder) {
//        this.patientId = builder.patientId;
//        this.customerName = builder.customerName;
//        this.email = builder.email;
//        this.mobileNumber = builder.mobileNumber;
//    }


    protected Customer() {
    }

    public Customer(String patientId, CustomerName customerName, String email, String mobileNumber) {
        this.patientId = patientId;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
    }

    public String getPatientID() {
        return patientId;
    }

    public CustomerName getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }


    public static class Builder {
        private String patientId;
        private CustomerName customerName;

        private String email;
        private String mobileNumber;

//        public Customer setPatientID(String patientId) {
//            this.patientId = patientId;
//            return this;
//        }


        public Builder setPatientID(String patientId) {
            this.patientId = patientId;
            return this;
        }

        public Builder setCustomerName(CustomerName customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Customer build() {
            if (patientId == null || patientId.isEmpty()) return null;
            if (customerName == null) return null;
            if (email == null) return null;
            if (mobileNumber == null) return null;


            return new Customer(this);
        }
    }
}


