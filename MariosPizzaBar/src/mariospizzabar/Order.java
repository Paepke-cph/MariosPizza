package mariospizzabar;

import java.util.ArrayList;

public class Order {

    private ArrayList<Pizza> order = new ArrayList<>();
    private double subTotal;
    private Customer customer;

    public Order(Pizza pizza, Customer customer) {
        this.customer = customer;
        this.order.add(pizza);
        subTotal += pizza.getPrice();
    }

    public void addToOrder (Pizza pizza) {
        this.order.add(pizza);
        subTotal += pizza.getPrice();
    }

    public void showPizza() {
        StringBuilder sb = new StringBuilder ();
        for (Pizza pizza : order) {
            sb.append(pizza.getNum());
            sb.append (". ");
            sb.append (pizza.getName());
            sb.append (" | ");
            System.out.println (sb);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customer).append(" | ");
        sb.append("Order: ").append(order).append(" | ");
        sb.append("Subtotal: ").append(subTotal).append(",-").append(" | ");
        return sb.toString();
    }
}
