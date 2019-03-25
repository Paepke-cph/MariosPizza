package core;

import io.MockStorage;
import io.Storage;

/**
 * @author Benjamin
 */
public class StorageController {
    
    private Storage storage;
    
    StorageController(Storage storage) {
        this.storage = storage;
    }

    /**
     * Returns all lines from a file, using the new-line character as delimiter for when to split the string.
     * @param path The path to the file.
     * @return  A String array containing every line from the file.
     */
    public String[] getFileLines(String path) {
        String file = storage.readAsString(path);
        if(file == null) {
            return null;
        }
        else {
            return file.split("\n");        
        }
    }
}
