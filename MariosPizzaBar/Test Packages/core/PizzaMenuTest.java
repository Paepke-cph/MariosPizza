package core;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class PizzaMenuTest {

    PizzaMenu menu;
    
    public PizzaMenuTest() {
        ArrayList<Pizza> pizza = new ArrayList<>();
        pizza.add(new Pizza(1,"Vesuvio","tomatsauce, ost, skinke, oregano",57));
        pizza.add(new Pizza(2,"Amerikaner","tomatsauce, ost, oksefars, oregano",53));
        pizza.add(new Pizza(3,"Cacciatore","tomatsauce, ost, pepperoni, oregano",57));
        pizza.add(new Pizza(4,"Carbona","tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano",63));
        pizza.add(new Pizza(5,"Dennis","tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano",65));
        pizza.add(new Pizza(6,"Bertil","tomatsauce, ost, bacon, oregano",57));
        menu = new PizzaMenu(pizza);
    }
    
    @Test
    public void testGetNumberOfItems() {
        assertEquals(6,menu.getNumberOfItems());
    }
    
    @Test
    public void testAddPizzaToMenu() {
        menu.addPizza(new Pizza(7, "New Pizza", "?", 100));
        assertEquals(7, menu.getNumberOfItems());
    }
    
    @Test
    public void testRemovePizzaFromMenu_pizzaOnTheMenu(){
        boolean removed = menu.removePizza(1);
        
        assertEquals(5,menu.getNumberOfItems());
        assertTrue(removed);
    }
    
    @Test
    public void testRemovePizzaFromMenu_pizzaNotOnMenu() {
        boolean removed = menu.removePizza(77);
        
        assertEquals(6, menu.getNumberOfItems());
        assertFalse(removed);
    }
}