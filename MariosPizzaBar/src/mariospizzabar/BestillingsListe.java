package mariospizzabar;

import java.util.ArrayList;


public class BestillingsListe {

    private ArrayList<Bestilling> bestillinger = new ArrayList<>();

    public void tilføjBestilling (Bestilling bestilling) {
        this.bestillinger.add(bestilling);
    }

    public void visBestillingsListe () {
        for (Bestilling bestilling : bestillinger) {
            bestilling.visPizza ();
        }
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder ("BestillingsListe{");
        sb.append ("bestillinger=").append (bestillinger);
        sb.append ('}');
        return sb.toString ();
    }
}
