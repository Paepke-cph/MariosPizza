package businesslogic;

/**
 * @author rando
 */
public class Pizza {

    private String pizzaNavn;
    private int pizzaNummer;
    private double pris;

    public Pizza(int pizzaNummer, String pizzaNavn, double pris) {
        this.pizzaNavn = pizzaNavn;
        this.pizzaNummer = pizzaNummer;
        this.pris = pris;
    }

    public String getPizzaNavn() {
        return pizzaNavn;
    }

    public int getPizzaNummer() {
        return pizzaNummer;
    }

    public double getPris() {
        return pris;
    }

    @Override
    public String toString() {
        return "Pizza{" + "pizzaNavn=" + pizzaNavn + ", pizzaNummer=" + pizzaNummer + ", pris=" + pris + '}';
    }
}
