package Storage;

import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public interface Storage {
    public static final String TURNOVER_FILE = "turnover.txt";
    public static final String POPULARPIZZA_FILE = "popularPizza.txt";
    
    public void completeOrder(int orderNumber);
    public void removePizza(int pizzaNumber);
    public ArrayList<String> readFromFile(String filename);
    public void writeToFile(String words, String filename);
    public ArrayList<Integer> getOrderNumbers();
}
