package core;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

import ui.MockUI;

/**
 * @author Benjamin
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNameToUppercase() {
        ArrayList<String> items = new ArrayList();
        items.add("Benjamin");
        items.add("Pedro");
        MockUI mock = new MockUI(new String[]{"Benjamin"});
        Controller controller = new Controller(mock, items);
        
        controller.inputToUppercase();
        assertTrue(mock.getOutput().equals("BENJAMIN"));
        assertEquals(1, mock.getOutputSize());
    }

}