package businesslogic;

/**
 * @author rando
 */
class Bestilling {

    private Pizza pizza;
    private int ordreNummer;

    public Bestilling(Pizza pizza, int ordreNummer) {
        this.pizza = pizza;
        ordreNummer = ordreNummer;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getOrdreNummer() {
        return ordreNummer;
    }

    @Override
    public String toString() {
        return "Bestilling{" + "pizza=" + pizza + ", ordreNummer=" + ordreNummer + '}';
    }

}
