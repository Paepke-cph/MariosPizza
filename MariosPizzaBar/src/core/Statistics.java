package core;

//Alexander
import Storage.FileStorage;
import Storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Statistics {

    final private Storage storage;

    public Statistics(Storage storage) {
        this.storage = storage;
    }
    
    private void calculateTurnover(int startDate, int endDate) {
        ArrayList<String> numbers = storage.readFromFile("turnover.txt");
        String[] splitLine;
        double turnover = 0;
        for (String number : numbers) {
            splitLine = number.split(" ");
            if (Integer.parseInt(splitLine[2].replace("-", "")) >= startDate && Integer.parseInt(splitLine[2].replace("-", "")) <= endDate) {
                turnover += Double.parseDouble(splitLine[1]);
            }
        }
        System.out.printf("Turnover from %d to %d = %.2f kr%n", startDate, endDate, turnover);
    }

    public void turnoverLastSevenDays() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(1);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculateTurnover(start, end);
    }

    public void turnoverLastFourWeeks() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(4);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculateTurnover(start, end);
    }

    public void turnoverLastsixMonths() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(6);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculateTurnover(start, end);
    }
    
    public void turnoverLastTwelveMonths() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(12);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculateTurnover(start, end);
    }
    
    public void turnoverAllTime() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.withYear(2017);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculateTurnover(start, end);
    }
    
    private void calculatePopularPizza(int startDate, int endDate) {
        ArrayList<String> numbers = storage.readFromFile("popularPizza.txt");
        int[] pizzaCount = new int[100];
        String[] splitLine;
        for (String number : numbers) {
            splitLine = number.split(" ");
            if (Integer.parseInt(splitLine[1].replace("-", "")) >= startDate && Integer.parseInt(splitLine[1].replace("-", "")) <= endDate) {
                pizzaCount[Integer.parseInt(splitLine[0]) - 1]++;
            }
        }
        int max = 0;
        int pizzaNumber = 0;
        
        for(int i = 0; i < pizzaCount.length; i++){
            if(pizzaCount[i] > max){
                max = pizzaCount[i];
                pizzaNumber = i + 1;
            }
                
        }
        System.out.printf("Most popular pizza from %d to %d = number %d%n", startDate, endDate, pizzaNumber);
    }
    
    public void popularPizzaLastSevenDays() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(1);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculatePopularPizza(start, end);
    }

    public void popularPizzaLastFourWeeks() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusWeeks(4);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculatePopularPizza(start, end);
    }

    public void popularPizzaLastsixMonths() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(6);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculatePopularPizza(start, end);
    }
    
    public void popularPizzaLastTwelveMonths() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusMonths(12);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculatePopularPizza(start, end);
    }
    
    public void popularPizzaAllTime() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.withYear(2017);
        int start = Integer.parseInt(startDate.toString().replaceAll("-", ""));
        int end = Integer.parseInt(endDate.toString().replaceAll("-", ""));
        calculatePopularPizza(start, end);
    }
    
}
