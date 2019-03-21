package mariospizzabar;

import java.util.ArrayList;

public class Bestilling {

    private ArrayList<Pizza> bestilling = new ArrayList<>();
    private double subTotal;
    private Kunde kunde;

    public Bestilling(Pizza pizza, Kunde kunde) {
        this.kunde = kunde;
        this.bestilling.add(pizza);
        subTotal += pizza.getPris();
    }

    public void tilføjTilBestilling (Pizza pizza) {
        this.bestilling.add(pizza);
        subTotal += pizza.getPris();
    }

    public void visPizza () {
        StringBuilder sb = new StringBuilder ();
        for (Pizza pizza : bestilling) {
            sb.append(pizza.getNummer());
            sb.append (". ");
            sb.append (pizza.getNavn ());
            sb.append (" | ");
            System.out.println (sb);
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Kunde: ").append(kunde).append(" | ");
        sb.append("Bestilling: ").append(bestilling).append(" | ");
        sb.append("Subtotal: ").append(subTotal).append(",-").append(" | ");
        return sb.toString();
    }
}
