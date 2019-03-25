package core;

public enum SystemMenu {
    
    
    
    PIZZA_MENU("Pizza Menu","This is the pizza menu"),
    
    SEE_ORDER_MENU("See Orders","This is the see order menu"),
    CREATE_ORDER_MENU("Create Order","This is the create order menu"),
    REMOVE_ORDER_MENU("Remove Order","This is the remove order menu"),
    ORDER_MENU("Order Menu","This is the order list", SEE_ORDER_MENU, CREATE_ORDER_MENU, REMOVE_ORDER_MENU),
    
    MAIN_MENU("Main Menu","This is the main menu", PIZZA_MENU, ORDER_MENU);
    
    
    
    
    private String name, text;
    private SystemMenu[] otherMenu;
    SystemMenu(String name, String text,SystemMenu ... menu) {
        this.name = name;
        this.text = text + "\n";
        if(menu.length == 0) this.text += "1) " + "Main Menu";
        for (int i = 0; i < menu.length; i++) {
            this.text += (i+1)+") " + menu[i].getName() + "\n";
            if(i == menu.length-1 && !name.equals("Main Menu"))
                this.text += (i+2)+") " + "Main Menu";
        }
        otherMenu = menu;
    }
    public String getName() {
        return name;
    }
    
    public String getText() {
        return text;
    }
    
    public int getMenuSize() {
        if(otherMenu == null || otherMenu.length == 0) return 1;
        else return otherMenu.length;
    }
    
    /**
     * Finds the corresponding menu, from the current menu, if the number given is larger than
     * the total number of menus, the default option is the MAIN_MENU.
     * @param index The index of the selected menu.
     * @return The menu corresponding to the given index.
     */
    public SystemMenu getMenu(int index) {
        if(otherMenu == null || index >= otherMenu.length)
            return MAIN_MENU;
        else
            return otherMenu[index];
    }
}
