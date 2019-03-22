package core;

import java.util.ArrayList;
import ui.UI;

/**
 * @author Benjamin
 */
public class Controller {
    private ArrayList<String> items;
    
    private UI ui;
    
    Controller(UI ui, ArrayList<String> items) {
        this.ui = ui;
        this.items = items;
    }
    
    public void inputToUppercase() {
        ui.println(ui.getInput().toUpperCase());
    }
    
}
