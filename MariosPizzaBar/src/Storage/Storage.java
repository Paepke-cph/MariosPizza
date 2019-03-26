package Storage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Alexander
 */
public interface Storage {
    
    public void completeOrder(int orderNumber);
    public void removePizza(int pizzaNumber);
    public ArrayList<String> readFromFile(String filename);
    public void writeToFile(String words, String filename);
    public ArrayList<Integer> getOrderNumbers();
}
