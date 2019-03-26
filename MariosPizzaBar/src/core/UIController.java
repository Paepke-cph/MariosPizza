package core;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.ArrayList;
import ui.UI;

/**
 * @author Benjamin
 */
public class UIController {
    private UI ui;
    private PizzaMenu menu;
    
    UIController(UI ui, PizzaMenu menu) {
        this.ui = ui;
        this.menu = menu;
    }
    
    /**
     * Parses the integer value and decrements the value by one, as to get the starting index down to 0, from 1.
     * @return int corresponding to the menu which was choosen.
     */
    public int getMenuChoice() {
        int index = 0;
        try {
            index = Integer.parseInt(ui.getInput());
            index--;
        }
        catch(NumberFormatException ex) {
            index = -2;
        }
        return index;
    }
    
    /**
     * Asks the UI to display a menu.
     * @param output The menu to be displayed.
     */
    public void displayMenu(String output) {
        ui.println(output);
    }
    
    public void displayText(String text) {
        ui.println(text);
    }
    
    /**
     * Creates a new pizza.
     * @return The newly created pizza, null if the pizza could not be created.
     */
    public Pizza createPizza() {
        Pizza result = null;
        try {
            ui.println("Enter the nummer for the pizza: ");
            int nr = Integer.parseInt(ui.getInput());
            ui.println("Enter the name of the pizza: ");
            String name = ui.getInput();
            ui.println("Enter the ingredients of the pizza: ");
            String ingredients = ui.getInput();
            ui.println("Enter the price of the pizza: ");
            double price = Double.parseDouble(ui.getInput());
            result = new Pizza(nr,name,ingredients,price);
        }
        catch (NumberFormatException ex) {
            // If one of the values (either int or double) could not be parsed,
            // return result as null.
        }
        return result;
    }

    public Order createOrder() {
        ArrayList<Pizza> chosenPizzas = new ArrayList<>();
        displayMenu(menu.toString());
        Order order = null;
        ui.println("Choose pizzas to include in the order: (-1 when done):");
        String line ="";
        try {
            while((line = ui.getInput()) != null || chosenPizzas.isEmpty()) {
                int choice = Integer.parseInt(line);
                if(choice == -1) {
                    break;
                }
                else {
                    if(choice-1 > menu.getNumberOfItems() || choice-1 < 0)
                        ui.println("Pizza number not on the list!");
                    else
                        chosenPizzas.add(menu.getPizza(choice-1));
                }
            }

            ui.println("When will the pizza be picked up? (example: hour:minute)");
            String[] splits = (ui.getInput()).split(":");
            LocalTime time = LocalTime.of(Integer.parseInt(splits[0]),Integer.parseInt(splits[1]));
            
            Customer customer = createCustomer();
            
            order = new Order(chosenPizzas,time,customer);
        }
        catch(NumberFormatException | DateTimeException ex) {
        }
        if(order != null)
            ui.println("Order created!\n");
        else
            ui.println("Order was not created!\n");
        return order;
    }

    public Customer createCustomer() {
        ui.println("Enter the name of the customer:");
        String name = ui.getInput();
        ui.println("Enter the phone number:");
        String phone = ui.getInput();
        return new Customer(name,phone);
    }
}
