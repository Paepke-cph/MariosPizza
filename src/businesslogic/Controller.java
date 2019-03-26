package businesslogic;

import java.util.ArrayList;
import ui.UI;

/**
 * @author rando
 */
public class Controller {

    private UI ui;
    private ArrayList<Pizza> menuKort;
    private ArrayList<Bestilling> aktiveOrdrer;
    private int currentOrderNr;

    public Controller(UI ui, ArrayList<Pizza> menuKort) {
        this.ui = ui;
        this.menuKort = menuKort;
        aktiveOrdrer = new ArrayList<Bestilling>();
        currentOrderNr = 1;
    }

    public void start() {
        boolean quit = false;
        ui.visHovedMenu();
        do{
            String brugerInput = ui.hovedMenuValg();
            if(null != brugerInput)switch (brugerInput) {
                case "1":
                    visMenukort();
                    break;
                case "2":
                    opretBestilling();
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } while(!quit);
    }

    public void opretBestilling() {
        //indlæs pizzanummer
        int pizzaNummer = ui.vælgPizza();
        //opret bestilling
        Bestilling bestilling = new Bestilling(menuKort.get(pizzaNummer - 1), currentOrderNr);
        //tilføj bestilling til ordre listen som mario skal lave.
        aktiveOrdrer.add(bestilling);
        //vis ordre nummer på skærmen
        ui.visOrdreNummer(currentOrderNr);
        //vis pizzavalg
        ui.visPizzaValg(bestilling.getPizza().toString());
        //tæl ordrenummer op
        currentOrderNr++;
    }

    public ArrayList<Bestilling> getAktiveOrdrer() {
        return aktiveOrdrer;
    }

    public void visMenukort() {
        ui.visMenukort(menuKort);
    }

}
