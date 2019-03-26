package businesslogic;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import ui.MockUI;

/**
 * @author rando
 */
public class OpretBestillingTest {

    @Test
    public void opretBestillingEnPizza() {
        //Arrange
        ArrayList<Pizza> menuKort = new ArrayList<>();
        menuKort.add(new Pizza(1, "Vesuvio", 57.0));
        menuKort.add(new Pizza(2, "Amerikaner", 53.0));
        String[] input = {"2"};//Test input data
        MockUI ui = new MockUI(input);
        Controller ctrl = new Controller(ui, menuKort);

        //Act
        ctrl.opretBestilling();

        //Assert
        //assertEquals("3", ui.getOutput().get(1));
        assertTrue(ui.getOutput().get(2).contains("Amerikaner"));
        assertTrue(ctrl.getAktiveOrdrer().size()==1);
        assertEquals("Amerikaner", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
    }
    
    @Test
    public void opretBestillingToPizzaer() {
        //Arrange
        ArrayList<Pizza> menuKort = new ArrayList<>();
        menuKort.add(new Pizza(1, "Vesuvio", 57.0));
        menuKort.add(new Pizza(2, "Amerikaner", 53.0));
        String[] input = {"2", "1"};//Test input data
        MockUI ui = new MockUI(input);
        Controller ctrl = new Controller(ui, menuKort);

        //Act
        ctrl.opretBestilling();
        ctrl.opretBestilling();

        //Assert
        //assertEquals("1", ui.getOutput().get(1));
        //assertEquals("2", ui.getOutput().get(4));
        assertTrue(ui.getOutput().get(2).contains("Amerikaner"));
        assertTrue(ctrl.getAktiveOrdrer().size()==2);
        assertEquals("Amerikaner", ctrl.getAktiveOrdrer().get(0).getPizza().getPizzaNavn());
    }

}
