package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Benjamin
 */
public class FileStorage implements Storage{
    private final String MENU_FILE = "menu.txt";
    private final String ARCHIVED_ORDERS_FILE = "orders.ach";
    private final String STATS_FILE = "stats.txt";
    
    public FileStorage() {
        
    }
    
    
    @Override
    public String readAsString(String path) {
        StringBuilder builder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            String line = "";
            while((line = br.readLine()) != null) {
                builder.append(line).append("\n");
            }
            br.close();
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(FileStorage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.toString();
    }
}
