package mariospizzabar;

public class Pizza {

    private int nummer;
    private String navn;
    private double pris;

    public Pizza(int nummer, String navn, double pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nummer).append(". ");
        sb.append(navn).append(" ");
        sb.append(pris).append(" ");
        return sb.toString();
    }
}
