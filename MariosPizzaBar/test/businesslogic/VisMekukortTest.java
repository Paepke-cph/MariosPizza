package businesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.MockUI;

/**
 * @author rando
 */
public class VisMekukortTest {

    @Test
    public void testVisMenukort(){
        //Arrange
        ArrayList<Pizza> menuKort = new ArrayList<>();
        menuKort.add(new Pizza(1, "Vesuvio", 57.0));
        menuKort.add(new Pizza(2, "Amerikaner", 53.0));
        menuKort.add(new Pizza(3, "Cacciatore", 57.0));
        String[] input = {};//Test input data
        MockUI ui = new MockUI(input);
        Controller ctrl = new Controller(ui, menuKort);
        //Act
        ctrl.visMenukort();
        //Assert
        assertTrue(ui.getOutput().get(0).contains("Vesuvio"));
    }

}
