package core;

import org.junit.Test;
import static org.junit.Assert.*;

public class SystemMenuTest {

    SystemMenu menu;
    public SystemMenuTest() {
         menu = SystemMenu.MAIN_MENU;
    }

    @Test
    public void testGetName() {
        assertEquals("Main Menu", menu.getName());
    }

    /**
     * NOTE: Det her er ikke en super god test, da indholdet af test
     * bliver generet ved run-time og derfor ikke er lige til at definerer
     */
    @Test
    public void testGetText() {
        assertTrue(menu.getText().contains("Main menu!"));
        assertFalse(menu.getText().contains("This is the pizza menu"));
    }

    @Test
    public void testGetMenu() {
        assertEquals(SystemMenu.PIZZA_MENU, menu.getMenu(0));
        assertEquals(SystemMenu.MAIN_MENU, menu.getMenu(99));
    }
    
    @Test
    public void testGetMenuSize() {
        assertEquals(1, SystemMenu.PIZZA_MENU.getMenuSize());
    }
}