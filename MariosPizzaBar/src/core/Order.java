package core;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class Order implements Comparable<Order> {
    private static int orderCount;
    private final int id;
    private ArrayList<Pizza> pizzas;
    private Customer customer;
    private LocalTime pickUpTime;
    
    public Order(ArrayList<Pizza> pizzas, LocalTime pickUpTime, Customer customer) {
        id = orderCount++;
        this.pizzas = pizzas;
        this.pickUpTime = pickUpTime;
        this.customer = customer;
    }
    
    public double getTotalPrice() {
        double sum = 0.0;
        for (Pizza piz : pizzas) {
            sum += piz.getPrice();
        }
        return sum;
    }

    public int getOrderID() {
        return id;
    }

    public ArrayList<Pizza> getPizza() {
        return pizzas;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order ID: ")
                .append(id)
                .append("\tPick-up time: ")
                .append(pickUpTime);
        builder.append("\nCustomer: ")
                .append(customer.getName())
                .append(" (").append(customer.getPhone()).append(")");
        for (Pizza pizza : pizzas) {
            builder.append("\n").append(pizza);
        }
        builder.append("\nTotal price: ")
                .append(getTotalPrice());
        return builder.toString();
    }

    @Override
    public int compareTo(Order other) {
        return pickUpTime.compareTo(other.getPickUpTime());
    }
}
