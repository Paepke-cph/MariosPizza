package core;

import ui.UI;

/**
 * @author Benjamin
 */
public class UIController {
    private UI ui;
    
    UIController(UI ui) {
        this.ui = ui;
    }
    
    /**
     * Parses the integer value and decrements the value by one, as to get the starting index down to 0, from 1.
     * @return int corresponding to the menu which was choosen.
     */
    public int getMenuChoice() {
        int index = Integer.parseInt(ui.getInput());
        index--;
        return index;
    } 
    
    /**
     * Asks the UI to display a menu.
     * @param menu The menu to be displayed.
     */
    public void displayMenu(String menu) {
        ui.println(menu);
    }
    
    public void displayText(String text) {
        ui.println(text);
    }
}
