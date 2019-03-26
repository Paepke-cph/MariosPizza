package ui;

import businesslogic.Pizza;
import java.util.ArrayList;

/**
 * @author rando
 */
public interface UI {

    public int vælgPizza();

    public void visPizzaValg(String string);

    public void visOrdreNummer(int ordrenummer);

    public void visMenukort(ArrayList<Pizza> menuKort);

    public void visHovedMenu();

    public String hovedMenuValg();

}
