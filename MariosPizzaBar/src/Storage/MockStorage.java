package Storage;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class MockStorage implements Storage{
    
    private ArrayList<Integer> orders;
    private ArrayList<Integer> pizzas;
    private ArrayList<String> fileLines;
    private ArrayList<String> fileOutput;
    private ArrayList<Integer> orderNumbers;
    
    public MockStorage(ArrayList<Integer> orders, ArrayList<Integer> pizzas) {
        this.orders = orders;
        this.pizzas = pizzas;
    }

    public int getOrdersSize() { return orders.size(); }
    public int getPizzasSize() { return pizzas.size(); }
    
    @Override
    public void completeOrder(int orderNumber) {
        if(orders.contains(orderNumber)) {
            orders.remove(orderNumber);
        }
    }

    @Override
    public void removePizza(int pizzaNumber) {
        if(pizzas.contains(pizzaNumber)) {
            pizzas.remove(pizzaNumber);
        }
    }
    
    public void setFileLines(ArrayList<String> fileLines) {
        this.fileLines = fileLines;
    }
    

    @Override
    public ArrayList<String> readFromFile(String filename) {
        return fileLines;
    }

    @Override
    public void writeToFile(String words, String filename) {
        fileOutput.add(words);
    }
    
    public void setOrderNumbers(ArrayList<Integer> orderNumbers) {
        this.orderNumbers = orderNumbers;
    }

    @Override
    public ArrayList<Integer> getOrderNumbers() {
        return orderNumbers;
    }

}
