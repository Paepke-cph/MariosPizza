package Storage;

//Alexander
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileStorage implements Storage {
    
    @Override
    public void completeOrder(int orderNumber){
        String line;
        String[] splitLine;
        ArrayList<String> orders = readFromFile("ordersToMake.txt");
        for(String order : orders){
            line = order;
            splitLine = line.split(" ");
            if (Integer.parseInt(splitLine[0]) == orderNumber)
                writeToFile(line, "allOrders.txt");
            if (Integer.parseInt(splitLine[0]) != orderNumber)
                writeToFile(line, "ordersToMakeTemp.txt");
        }
        renameFile("ordersToMakeTemp.txt", "ordersToMake.txt");
    };
    
    @Override
    public ArrayList<Integer> getOrderNumbers(){
        ArrayList<Integer> orderNumbers = new ArrayList();
        String[] splitLine;
        ArrayList<String> readOrdersToMake = readFromFile("ordersToMake.txt");
        ArrayList<String> readAllOrders = readFromFile("allOrders.txt");
        for(String order : readOrdersToMake){
            splitLine = order.split(" ");
            if(!splitLine[0].equals("") || !splitLine[0].equals(" "))
                orderNumbers.add(Integer.parseInt(splitLine[0]));
        }
        for(String order : readAllOrders){
            splitLine = order.split(" ");
            if(!splitLine[0].equals("") || !splitLine[0].equals(" "))
                orderNumbers.add(Integer.parseInt(splitLine[0]));
        }      
        return orderNumbers;
    }

    @Override
    public void removePizza(int number) {
        String line;
        String[] splitLine;
        ArrayList<String> pizza = readFromFile("Menu.txt");
        for(String piz : pizza){
            line = piz;
            splitLine = piz.split(" ");
            if (Integer.parseInt(splitLine[0]) != number) {
                    writeToFile(line, "MenuTemp.txt");
                }
        }
        renameFile("MenuTemp.txt", "Menu.txt");
    }

    @Override
    public void writeToFile(String words, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(words);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public ArrayList<String> readFromFile(String filename){
        ArrayList<String> file = new ArrayList();
        String lineRead;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) 
        {
            lineRead = reader.readLine();
            while (lineRead != null) {
                file.add(lineRead);
                lineRead = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }

    private void renameFile(String filename, String newFilename) {
        try {
            File f = new File(newFilename);
            File tf = new File(filename);
            f.delete();
            tf.renameTo(f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
