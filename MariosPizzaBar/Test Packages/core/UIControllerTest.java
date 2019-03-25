package core;

import org.junit.Test;
import static org.junit.Assert.*;
import ui.MockUI;

public class UIControllerTest {

    private UIController controller;
    private MockUI mock;
    
    public UIControllerTest() {
        String[] input = new String[] {"1","2","x","0"};
        mock = new MockUI(input);
        controller = new UIController(mock);
    }
    
    @Test
    public void testGetMenuChoice() {
        assertEquals(0, controller.getMenuChoice());
        assertEquals(1, controller.getMenuChoice());
        assertEquals(-2, controller.getMenuChoice());
        assertEquals(-1, controller.getMenuChoice());
    }
    
    @Test
    public void testDisplayMenu() {
        controller.displayMenu("Main Menu");
        assertEquals(1,mock.getOutputSize());
    }
}