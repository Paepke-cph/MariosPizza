package mariospizzabar;

import java.io.*;
import java.util.ArrayList;

public class Menu {

    private ArrayList<Pizza> menukort = new ArrayList<>();


    public void createMenuFromFile() {
        String lineRead;
        String[] splitLine;
        Pizza pizza;

        try (BufferedReader reader = new BufferedReader(new FileReader("Menu.txt")))
        {
            lineRead = reader.readLine();
            while (lineRead != null) {
                splitLine = lineRead.split(" ");
                pizza = new Pizza(Integer.parseInt(splitLine[0]), splitLine[1], Double.parseDouble(splitLine[2]));
                menukort.add(pizza);
                lineRead = reader.readLine();
            }

        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void showMenu () {

        for (Pizza pizza : menukort) {
            System.out.println(pizza);
        }

    }
}