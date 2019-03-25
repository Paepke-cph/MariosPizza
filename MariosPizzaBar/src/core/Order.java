package core;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class Order {
    private final int id;
    private ArrayList<Pizza> pizza;
    private Customer customer;
    
    public Order(int id, ArrayList<Pizza> pizza, Customer customer) {
        this.id = id;
        this.pizza = pizza;
        this.customer = customer;
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
}
