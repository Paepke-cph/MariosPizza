package core;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class PizzaMenu {
    ArrayList<Pizza> menu;

    PizzaMenu(String[] pizza) {
        menu = new ArrayList<>();
        for (String string : pizza) {
            Pizza parsedPizza = parseString(string); 
            if(parsedPizza != null)
                menu.add(parsedPizza);
        }
    }
    
    PizzaMenu(ArrayList<Pizza> menu) {
        this.menu = menu;
    }

    /**
     * Parses a given string into the an object of type Pizza
     * @param string The string to be pased
     * @return The resulting pizza of the parsing.
     */
    public Pizza parseString(String string) {
        Pizza pizza = null;
        try {
            String[] subs = string.split(" ");
            int nr = Integer.parseInt(subs[0]);
            String name = subs[1];
            double price = Double.parseDouble(subs[2]);
            pizza = new Pizza(nr,name,"",price);
        }
        catch (NumberFormatException ex) {
            // The receiving input did not match what was expected.
        }
        return pizza;
    }
    
    public int getNumberOfItems() {
        return menu.size();
    }

    public void addPizza(Pizza pizza) {
        menu.add(pizza);
    }
    
    /**
     * Try to removed a pizza from the menu, if the index is out of bounds, a pizza will not be removed.
     * @param index The index corresponding to the pizza on the menu.
     * @return TRUE if the pizza was removed - FALSE if a pizza was not removed.
     */
    public boolean removePizza(int index) {
        try {
            menu.remove(index);
            return true;
        }
        catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Pizza pizza : menu) {
            builder.append(pizza).append("\n");
        }
        return builder.toString();
    }
}
