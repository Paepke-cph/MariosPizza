package ui;

import businesslogic.Pizza;
import java.util.ArrayList;

/**
 * @author rando
 */
public class MockUI implements UI {

    private int index = 0;
    private String[] input;
    private ArrayList<String> output = new ArrayList<>();

    public MockUI(String[] input) {
        this.input = input;
    }

    @Override
    public int vælgPizza() {
        output.add("Skriv hvilket pizzanummer kunden har bestilt");
        return Integer.parseInt(input[index++]);
    }

    @Override
    public void visPizzaValg(String str) {
        output.add(str);
    }

    public ArrayList<String> getOutput() {
        return output;
    }

    @Override
    public void visOrdreNummer(int ordrenummer) {
        output.add("" + ordrenummer);
    }

    @Override
    public void visMenukort(ArrayList<Pizza> menuKort) {
        for(Pizza pizza:menuKort){//For Each Loop
            output.add(pizza.toString());
        }
    }

    @Override
    public void visHovedMenu() {
        output.add("Vælg en af følgende mugligheder:");
        output.add("1. Vis menukort");
        output.add("2. Opret bestilling");
        output.add("3. Aflsut programmet");
    }

    @Override
    public String hovedMenuValg() {
        return (input[index++]);
    }
}
