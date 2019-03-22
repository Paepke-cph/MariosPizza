package ui;

import java.util.Scanner;
/**
 * @author Benjamin
 */
public class ConsoleUI implements UI{

    private Scanner scanner = new Scanner(System.in);
    
    public ConsoleUI() {
    }
    
    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }

}
