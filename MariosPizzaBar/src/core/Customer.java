package core;


public class Customer {

    private String firstName;
    private String lastName;
    private String Address;
    
    public Customer(){};

    public Customer(String firstName) {
        this.firstName = firstName;
    }
    
    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Customer(String firstName, String lastName, String Address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = Address;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + Address;
    }
    
    
    
}
