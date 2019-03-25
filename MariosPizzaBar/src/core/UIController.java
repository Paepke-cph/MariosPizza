package core;

import java.util.ArrayList;
import ui.UI;

/**
 * @author Benjamin
 */
public class UIController {
    private ArrayList<String> items;
    
    private UI ui;
    
    UIController(UI ui, ArrayList<String> items) {
        this.ui = ui;
        this.items = items;
    }
    
    public int getMenuChoice() {
        int index = Integer.parseInt(ui.getInput());
        index--;
        return index;
    } 
    
    public void displayMenu(String menu) {
        ui.println(menu);
    }
}
