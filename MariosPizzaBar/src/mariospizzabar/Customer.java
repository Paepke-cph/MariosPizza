package mariospizzabar;

public class Customer {

    private String name;
    private int phone;
    private String address;

    public Customer(String name, int phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name).append(" | ").append(phone).append(" | ").append(address);
        return sb.toString();
    }
}
