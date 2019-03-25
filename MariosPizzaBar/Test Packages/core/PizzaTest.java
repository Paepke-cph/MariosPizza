package core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PizzaTest {
    Pizza pizza;
    public PizzaTest() {
        pizza = new Pizza(1,"Amerikaner", "Pepperoni", 59);
    }
    
    @Test
    public void testGetNumber() {
        assertEquals(1, pizza.getNumber());
    }
    
    @Test
    public void testGetName() {
        assertEquals("Amerikaner", pizza.getName());
    }
    
    @Test
    public void testGetIngredients() {
        assertEquals("Pepperoni", pizza.getIngredients());
    }
    
    @Test
    public void testGetPrice() {
        assertEquals(59, pizza.getPrice(), 0.0);
    }


}