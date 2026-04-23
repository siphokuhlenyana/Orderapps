package za.ac.cput.orderapps.domain;


import jakarta.persistence.Embeddable;

@Embeddable
public class CustomerName {
    private String firstName;
    private String middleName;
    private String lastName;

    protected CustomerName() {}
    private CustomerName(Builder builder) {
        this.firstName = builder.firstName;
        this.middleName = builder.middleName;
        this.lastName = builder.lastName;
    }

    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String middleName ;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setMiddleName(String middleName){
            this.middleName=middleName ;
            return this;

        }

        public CustomerName build() {
            if (firstName == null || firstName.isEmpty()) return null;
            if (lastName == null || lastName.isEmpty()) return null;
            if (middleName == null || middleName.isEmpty()) return null;
            return new CustomerName(this);
        }
    }
}
