package core;

import io.FileStorage;
import io.Storage;
import java.util.ArrayList;
import ui.ConsoleUI;

public class Main {
    
    public static void main(String[] args) {
//        ArrayList<Pizza> menu = new ArrayList<>();
//        menu.add(new Pizza(1,"Vesuvio","tomatsauce, ost, skinke, oregano",57));
//        menu.add(new Pizza(2,"Amerikaner","tomatsauce, ost, oksefars, oregano",53));
//        menu.add(new Pizza(3,"Cacciatore","tomatsauce, ost, pepperoni, oregano",57));
//        menu.add(new Pizza(4,"Carbona","tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano",63));
//        menu.add(new Pizza(5,"Dennis","tomatsauce, ost, skinke, pepperoni, cocktailpølser, oregano",65));
//        menu.add(new Pizza(6,"Bertil","tomatsauce, ost, bacon, oregano",57));
//               
//        // Make sure the program will be running
//        boolean isRunning = true;   
//        // Setup the UI-controller, and setup the staring menu.
//        UIController controller = new UIController(new ConsoleUI());
//        SystemMenu currentMenu = SystemMenu.MAIN_MENU;
//        // Display the menu.
//        controller.displayMenu(currentMenu.getText());
//        
//        while(isRunning) {
//            int choice = controller.getMenuChoice();
//            if(choice < 0) {
//                isRunning = false;
//            }
//            else if(choice >= currentMenu.getMenuSize()) {
//                controller.displayMenu("Invalid input, try again!");
//            }
//            else {
//                currentMenu = currentMenu.getMenu(choice);
//                controller.displayMenu(currentMenu.getText());
//                switch(currentMenu) {
//                    case PIZZA_MENU:
//                        // Display the menu.
//                        break;
//                    case SEE_ORDER_MENU:
//                        // Display the active orders to the screen.
//                        break;
//                    case CREATE_ORDER_MENU:
//                        // Create an order - and add to the list of active orders
//                        break;
//                    case REMOVE_ORDER_MENU:
//                        // Choose which order to remove - and save the order to file
//                        break;
//                    case ORDER_MENU: case MAIN_MENU:
//                        // There are no special functions in these menus, user simply has to pick a new sub-menu.
//                        break;
//                    default:
//                        throw new AssertionError(currentMenu.name());
//                }
//            }
//        }
    }

}
