package core;

import Storage.MockStorage;
import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    private double val1 = 114.0, val2 = 175.0, val3 = 57.0;
    
    public StatisticsTest() {
        
    }

    @Test
    public void testCalculateTurnover() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("88 "+val1+" 2019-03-26");
        fileLines.add("89 "+val2+" 2019-03-26");
        fileLines.add("90 "+val3+" 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int startDate = 20190326, endDate = 20190326;
        String output = stats.calculateTurnover(startDate, endDate);
        String exp = String.format("Turnover from %d to %d = %.2f kr%n",
                startDate, endDate, (val1+val2+val3));
        assertEquals(exp,output);
    }

    @Test
    public void testTurnoverForDuration() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("88 "+val1+" 2019-03-26");
        fileLines.add("89 "+val2+" 2019-03-26");
        fileLines.add("90 "+val3+" 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int endDate = 20190326;
        int startDate = endDate-7;
        String output = stats.turnoverForDuration(0, 0, 1);
        String exp = String.format("Turnover from %d to %d = %.2f kr%n",
                startDate, endDate, (val1+val2+val3));
        assertEquals(exp,output);
    }

    @Test
    public void testTurnoverAllTime() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("88 "+val1+" 2019-03-26");
        fileLines.add("89 "+val2+" 2019-03-26");
        fileLines.add("90 "+val3+" 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int endDate = 20190326;
        int startDate = Integer.parseInt(LocalDate.now()
                .withYear(2017)
                .toString()
                .replace("-", ""));
        String output = stats.turnoverAllTime();
        String exp = String.format("Turnover from %d to %d = %.2f kr%n",
                startDate, endDate, (val1+val2+val3));
        assertEquals(exp,output);
    }

    @Test
    public void testCalculatePopularPizza() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("2 2019-03-26");
        fileLines.add("3 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int startDate = 20190326, endDate = 20190326;
        String output = stats.calculatePopularPizza(startDate, endDate);
        String exp = String.format("Most popular pizza from %d to %d = number %d%n",
                startDate, endDate, 1);
        assertEquals(exp,output);
    }

    @Test
    public void testPopularPizzaForDuration() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("2 2019-03-26");
        fileLines.add("3 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int endDate = 20190326;
        int startDate = endDate-7;
        
        String output = stats.popularPizzaForDuration(0, 0, 1);
        String exp = String.format("Most popular pizza from %d to %d = number %d%n",
                startDate, endDate, 1);
        assertEquals(exp,output);
    }

    @Test
    public void testPopularPizzaAllTime() {
        MockStorage mock = new MockStorage();
        ArrayList<String> fileLines = new ArrayList<>();
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("1 2019-03-26");
        fileLines.add("2 2019-03-26");
        fileLines.add("3 2019-03-26");

        mock.setFileLines(fileLines);
        Statistics stats = new Statistics(mock);
        
        int endDate = 20190326;
        int startDate = Integer.parseInt(LocalDate.now()
                .withYear(2017)
                .toString()
                .replace("-", ""));
        String output = stats.calculatePopularPizza(startDate, endDate);
        String exp = String.format("Most popular pizza from %d to %d = number %d%n",
                startDate, endDate, 1);
        assertEquals(exp,output);
    }

}