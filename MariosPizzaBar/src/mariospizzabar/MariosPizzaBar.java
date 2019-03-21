package mariospizzabar;

public class MariosPizzaBar {


    public static void main(String[] args) {
        Menukort menu = new Menukort();

        menu.createMenukortFromFile();

        Pizza pizza1 = new Pizza(13, "Salat", 60);
        Pizza pizza2 = new Pizza (13, "Vesuvio", 45);
        Pizza pizza3 = new Pizza(15, "Hawaii", 40);
        Kunde kunde = new Kunde("Mads", 12345, "Flensborggade 41");
        Kunde kunde2 = new Kunde("Signe", 12345, "Flensborggade 41");

        Bestilling bestilling1 = new Bestilling(pizza1, kunde);
        bestilling1.tilføjTilBestilling(pizza3);

        System.out.println (bestilling1);

        Bestilling bestilling2 = new Bestilling (pizza2, kunde2);


        BestillingsListe liste = new BestillingsListe ();

        liste.tilføjBestilling (bestilling1);
        liste.visBestillingsListe ();
        liste.tilføjBestilling (bestilling2);
    }

}
