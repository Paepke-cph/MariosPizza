package core;

import ui.ConsoleUI;

public class Main {
    
    public static void main(String[] args) {
        boolean isRunning = true;
        
        UIController controller = new UIController(new ConsoleUI(),null);
        SystemMenu currentMenu = SystemMenu.MAIN_MENU;
        
        controller.displayMenu(currentMenu.getText());
        
        while(isRunning) {
            int choice = controller.getMenuChoice();
            if(choice <= 0) {
                isRunning = false;
            }
            else {
                currentMenu = currentMenu.getMenu(choice);
                controller.displayMenu(currentMenu.getText());
            }
        }
    }

}
