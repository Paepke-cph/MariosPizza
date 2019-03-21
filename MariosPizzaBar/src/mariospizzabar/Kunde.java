package mariospizzabar;

public class Kunde {

    private String navn;
    private int telefon;
    private String addresse;

    public Kunde(String navn, int telefon, String addresse) {
        this.navn = navn;
        this.telefon = telefon;
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(navn).append(" | ").append(telefon).append(" | ").append(addresse);
        return sb.toString();
    }
}
