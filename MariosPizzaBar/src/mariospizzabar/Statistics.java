package mariospizzabar;

//Alexander
import IO.FileHandler;
import java.time.LocalDate;
import java.util.ArrayList;

public class Statistics {

    final private FileHandler fileHandler = new FileHandler();

    public void calculateTurnover(int startDate, int endDate) {
        ArrayList<String> numbers = fileHandler.readFromFile("turnover.txt");
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
    
    
}
