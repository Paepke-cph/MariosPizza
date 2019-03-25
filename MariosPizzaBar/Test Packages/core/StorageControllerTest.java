package core;

import io.MockStorage;
import org.junit.Test;
import static org.junit.Assert.*;

public class StorageControllerTest {
    private StorageController controller;
    private MockStorage mock;
    public StorageControllerTest() {
        String[] input = new String[] {"x","x","x"};
        mock = new MockStorage(input);
        controller = new StorageController(mock);
    }

    @Test
    public void testGetFileLines() {
        assertEquals(3,controller.getFileLines(null).length);
    }
}