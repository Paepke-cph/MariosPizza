package mariospizzabar;

import java.io.*;
import java.util.ArrayList;

public class Menukort {

    private ArrayList<Pizza> menukort = new ArrayList<>();


    public void createMenukortFromFile() {
        String lineRead;
        String[] splitLine;
        Pizza pizza;

        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\madse\\Desktop\\Marios\\MariosPizza\\MariosPizzaBar\\src\\mariospizzabar\\Menukort.txt")))
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
