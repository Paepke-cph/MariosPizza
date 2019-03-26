package core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private Customer customer;
    private LocalTime pickUpTime;
    private LocalDate date;
    private double pizzaPrice1 = 59, pizzaPrice2 = 57;
    
    public OrderTest() {
        date = LocalDate.of(2000, Month.MARCH, 20);
        pickUpTime = LocalTime.of(18, 30);
        customer = new Customer("Peter Pan","11 22 33 44");
        ArrayList<Pizza> pizza = new ArrayList<>();
        pizza.add(new Pizza(2, "Amerikaner", "Pepperoni", pizzaPrice1));
        pizza.add(new Pizza(1, "Vesuvio", "tomatsauce", pizzaPrice2));
        order = new Order(1, pizza, date, pickUpTime);
    }

    @Test
    public void testGetTotalPrice() {
        assertEquals(pizzaPrice1+pizzaPrice2, order.getTotalPrice(),0.0);
    }
    
    @Test
    public void testGetOrderNumber() {
        assertEquals(1, order.getOrderNumber());
    }
    
    @Test
    public void testGetPizza() {
        assertEquals(2, order.getPizza().size());
    }
     
     @Test
     public void testGetPickUpTime() {
         assertEquals(pickUpTime, order.getTime());
     }
}