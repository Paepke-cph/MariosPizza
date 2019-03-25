package core;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class PizzaMenu {
    ArrayList<Pizza> menu;

    PizzaMenu(ArrayList<Pizza> menu) {
        this.menu = menu;
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
}
