package io;

/**
 * @author Benjamin
 */
public class MockStorage implements Storage {

    private String[] input;
    
    public MockStorage(String[] input) {
        this.input = input;
    }
    
    @Override
    public String readAsString(String path) {
        StringBuilder builder = new StringBuilder();
        for (String string : input) {
            builder.append(string).append("\n");
        }
        return builder.toString();
    }

}
