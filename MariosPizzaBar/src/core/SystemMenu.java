package core;

public enum SystemMenu {
    
    
    /*
    Format of the ENUMS:
    1st param is the name of the menu
    2nd param is the text to be dispayed when entering the menu
    3rd param is the menu options from that given menu.
    */
    
    PIZZA_MENU("Pizza Menu",
            "The list of the available pizzas"),
    
    SEE_ORDER_MENU("See Orders",
            "All currently active orders"),
    CREATE_ORDER_MENU("Create Order",
            "Create a order!"),
    REMOVE_ORDER_MENU("Remove Order",
            "Complete an orde!"),
    ORDER_MENU("Order Menu",
            "What do you want to do now?",
            SEE_ORDER_MENU, CREATE_ORDER_MENU, REMOVE_ORDER_MENU),
    
    MAIN_MENU("Main Menu",
            "Main menu!"
                    + "\nTo close the program, press 0"
                    + "\nChoose one of the following menues by inputting their corresponding numbrers",
            PIZZA_MENU, ORDER_MENU);
    
    
    
    
    private String name, text;
    private SystemMenu[] otherMenu;
    SystemMenu(String name, String text,SystemMenu ... menu) {
        this.name = name;
        this.text = text;
        if(menu.length == 0) this.text += "\n1) " + "Main Menu";
        for (int i = 0; i < menu.length; i++) {
            this.text += "\n" + (i+1)+") " + menu[i].getName();
            if(i == menu.length-1 && !name.equals("Main Menu"))
                this.text += "\n" + (i+2)+") " + "Main Menu";
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
        else return otherMenu.length + 1;
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
