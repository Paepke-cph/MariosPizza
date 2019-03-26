package core;

import java.time.LocalTime;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.MockUI;

public class UIControllerTest {

    private UIController controller;
    private MockUI mock;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private PizzaMenu menu;
    
    public UIControllerTest() {
        pizzas.add(new Pizza(1,"Vesuvio","Tomatsauce,Ost,oregano",57));
        menu = new PizzaMenu(pizzas);
    }
    
    @Test
    public void createCustomer() {
        String[] input = new String[] {"Benjamin", "30 30 30 30"};
        mock = new MockUI(input);
        controller = new UIController(mock,menu);
        
        Customer customer = controller.createCustomer();
        
        assertEquals("Benjamin", customer.getName());
        assertEquals("30 30 30 30", customer.getPhone());
    }
    
    @Test
    public void testCreateOrder_withInvalidTimeFormat() {
        String[] input = new String[] {"1","-1","11xxx30"};
        mock = new MockUI(input);
        controller = new UIController(mock,menu);       
        assertEquals(null,controller.createOrder());
    }
    
    @Test
    public void testCreateOrder() {
        String[] input = new String[] {"1","-1","10:30", "Benjamin", "30 30 30 30"};
        mock = new MockUI(input);
        controller = new UIController(mock,menu);
        
        Order order = controller.createOrder();
        assertEquals(1,order.getPizza().size());
        assertEquals(LocalTime.of(10,30),order.getPickUpTime());
        assertEquals("Benjamin", order.getCustomer().getName());
        assertEquals("30 30 30 30", order.getCustomer().getPhone());
        
    }
    
    
    @Test
    public void testCreatePizza() {
        String[] input = new String[] {"1", "New Pizza", "Pepperoni", "70"};
        mock = new MockUI(input);
        controller = new UIController(mock,null);

        Pizza result = controller.createPizza();
        assertEquals(1,result.getNumber());
        assertEquals("New Pizza",result.getName());
        assertEquals("Pepperoni",result.getIngredients());
        assertEquals(70,result.getPrice(), 0.0);
    }
    
    @Test
    public void testCreatePizza_withPriceNotBeingParsable() {
        String[] input = new String[] {"1", "New Pizza", "Pepperoni", "hej :)"};
        mock = new MockUI(input);
        controller = new UIController(mock,null);

        Pizza result = controller.createPizza();
        assertEquals(null,result);
    }
    
    
    @Test
    public void testGetMenuChoice() {
        String[] input = new String[] {"1","2","x","0"};
        mock = new MockUI(input);
        controller = new UIController(mock,null);
        
        assertEquals(0, controller.getMenuChoice());
        assertEquals(1, controller.getMenuChoice());
        assertEquals(-2, controller.getMenuChoice());
        assertEquals(-1, controller.getMenuChoice());
    }
    
    @Test
    public void testDisplayMenu() {
        String[] input = new String[] {"1","2","x","0"};
        mock = new MockUI(input);
        controller = new UIController(mock,null);
        
        controller.displayMenu("Main Menu");
        assertEquals(1,mock.getOutputSize());
    }
}