package core;

import io.FileStorage;
import io.Storage;
import java.util.ArrayList;
import ui.ConsoleUI;

public class Main {
    
    public static void main(String[] args) {
        
        StorageController storageController = new StorageController(new FileStorage());
        PizzaMenu menu = new PizzaMenu(storageController.getFileLines("menu.txt"));

        boolean isRunning = true;   
        UIController uiController = new UIController(new ConsoleUI());
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
                switch(currentMenu) {
                    case PIZZA_MENU:
                        uiController.displayText(menu.toString());
                        break;
                    case SEE_ORDER_MENU:
                        // Display the active orders to the screen.
                        break;
                    case CREATE_ORDER_MENU:
                        // Create an order - and add to the list of active orders
                        // When creation is done return to main menu?
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
                uiController.displayMenu(currentMenu.getText());
            }
        }
    }

}
