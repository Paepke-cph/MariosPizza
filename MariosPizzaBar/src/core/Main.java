package core;

import io.FileStorage;
import io.Storage;
import java.util.ArrayList;
import toolbox.SortedQueue;
import ui.ConsoleUI;

public class Main {
    
    public static void main(String[] args) {
        SortedQueue<Order> orders = new SortedQueue<>();
        
        StorageController storageController = new StorageController(new FileStorage());
        PizzaMenu menu = new PizzaMenu(storageController.getFileLines("menu.txt"));

        boolean isRunning = true;   
        UIController uiController = new UIController(new ConsoleUI(),menu);
        SystemMenu currentMenu = SystemMenu.MAIN_MENU;

        uiController.displayMenu(currentMenu.getText());
        
        while(isRunning) {
            int choice = uiController.getMenuChoice();
            if(choice == -1)
                isRunning = false;
            else if(choice >= currentMenu.getMenuSize() || choice < -1)
                uiController.displayMenu("Invalid input, try again!");
            else {
                currentMenu = currentMenu.getMenu(choice);
                uiController.displayMenu(currentMenu.getText());
                switch(currentMenu) {
                    case PIZZA_MENU:
                        uiController.displayText(menu.toString());
                        break;
                    case SEE_ORDER_MENU:
                        if(orders.size() == 0) {
                            uiController.displayText("There are no active orders at the moment.");
                        }
                        else {
                            for(Order order : orders) {
                                uiController.displayText(order.toString()+"\n");
                            }
                        }
                        break;
                    case CREATE_ORDER_MENU:
                        Order order = uiController.createOrder();
                        if(order != null)
                            orders.add(order);
                        currentMenu = SystemMenu.MAIN_MENU;
                        uiController.displayMenu(currentMenu.getText());
                        break;
                    case REMOVE_ORDER_MENU:
                        // Choose which order to remove - and save the order to file
                        // When removal is done return to main menu?
                        break;
                    case ORDER_MENU: case MAIN_MENU:
                        // There are no special functions in these menus, user simply has to pick a new sub-menu.
                        break;
                    default:
                        throw new AssertionError(currentMenu.name());
                }
            }
        }
    }

}
