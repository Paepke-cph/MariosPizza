package core;

import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTest {
    
    private Customer customer;
    public CustomerTest() {
        customer = new Customer("Benjamin","22 22 22 22");
    }

    @Test
    public void testGetName() {
        assertEquals("Benjamin", customer.getName());
    }
    
    @Test
    public void testGetPhone() {
        assertEquals("22 22 22 22", customer.getPhone());
    }
    
    
}