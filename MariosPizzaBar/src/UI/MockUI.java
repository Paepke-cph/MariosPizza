package UI;

import java.util.ArrayList;


public class MockUI implements UI{

    private ArrayList<String> output;
    private String[] input;
    private int inputIndex;
    private int outputIndex;

    @Override
    public String getInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void println(String words) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getOutput(){
        return "";
    }
    
    public int getOutputSize(){
        return 1;
    }

    @Override
    public void printf(String str, Object... format) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
