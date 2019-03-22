package ui;

import java.util.ArrayList;

/**
 * @author Benjamin
 */
public class MockUI implements UI {
    private ArrayList<String> output = new ArrayList<>();
    private String[] input;
    private int inputIndex;
    private int outputIndex;
    
    public MockUI(String[] input) {
        this.input = input;
    }
    
    @Override
    public String getInput() {
        return input[inputIndex++];
    }

    @Override
    public void println(String str) {
        output.add(str);
    }

    public String getOutput() {
        return output.get(outputIndex++);
    }
    
    public int getOutputSize() {
        return output.size();
    }
}
