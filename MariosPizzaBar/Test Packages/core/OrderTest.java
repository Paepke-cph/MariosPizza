package core;

import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private Customer customer;
    private LocalTime pickUpTime;
    public OrderTest() {
        pickUpTime = LocalTime.of(18, 30);
        customer = new Customer("Benjamin","11 22 33 44");
        ArrayList<Pizza> pizza = new ArrayList<>();
        pizza.add(new Pizza(1, "Amerikaner", "Pepperoni", 59));
        
        order = new Order(1, pizza, customer, pickUpTime);
    }

    @Test
    public void testGetOrderID() {
        assertEquals(1, order.getOrderID());
    }
    
    @Test
    public void testGetPizza() {
        assertEquals(1, order.getPizza().size());
    }
    
     @Test
     public void testGetCustomer() {
         assertEquals(customer, order.getCustomer());
     }
     
     @Test
     public void testGetPickUpTime() {
         assertEquals(pickUpTime, order.getPickUpTime());
     }
}