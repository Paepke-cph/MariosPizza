package core;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class Order {
    private final int id;
    private ArrayList<Pizza> pizza;
    private Customer customer;
    private LocalTime pickUpTime;
    
    public Order(int id, ArrayList<Pizza> pizza, Customer customer, LocalTime pickUpTime) {
        this.id = id;
        this.pizza = pizza;
        this.customer = customer;
        this.pickUpTime = pickUpTime;
    }

    public int getOrderID() {
        return id;
    }

    public ArrayList<Pizza> getPizza() {
        return pizza;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }
}
