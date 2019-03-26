package ui;

import businesslogic.Pizza;
import java.util.ArrayList;

/**
 *
 * @author rando
 */
public class SystemUI implements UI {

    @Override
    public int vælgPizza() {
        return 1;//hardcode nr 1
    }

    @Override
    public void visPizzaValg(String str) {
        System.out.print(str);
    }

    @Override
    public void visOrdreNummer(int ordrenummer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visMenukort(ArrayList<Pizza> menuKort) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visHovedMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String hovedMenuValg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
