package ui;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class MockUI implements UI {
    private ArrayList<String> output = new ArrayList<>();
    private String[] input;
    private int index;
    
    public MockUI(String[] input) {
        this.input = input;
    }
    
    @Override
    public String getInput() {
        return input[index++];
    }

    @Override
    public void println(String str) {
        output.add(str);
    }

}
