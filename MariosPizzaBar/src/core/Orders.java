package core;

//Alexander

import Storage.FileHandler;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Orders {

    private int orderNumber;
    private ArrayList<Pizza> pizza;
    private Customer customer;
    private double totalPrice;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    final private FileHandler fileHandler = new FileHandler();

    public Orders(){
        
    };
    
    public Orders(ArrayList<Pizza> pizza) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        calculateTotalPrice();
    }

    public Orders(ArrayList<Pizza> pizza, String firstName) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        this.customer = new Customer(firstName);
        calculateTotalPrice();
    }

    public Orders(ArrayList<Pizza> pizza, String firstName, String lastName, String address) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        this.customer = new Customer(firstName, lastName, address);
        calculateTotalPrice();
    }
    
    private void calculateTotalPrice(){
        for(Pizza foodItem : pizza){
            totalPrice += foodItem.getPrice();
       }
    }

    public void writeOrderToFile() {
        fileHandler.writeToFile(orderNumber + " " + totalPrice + " " + date.toString(), "turnover.txt");
        for (Pizza foodItem : pizza) {
            fileHandler.writeToFile(foodItem.getNumber() + " " + date.toString(), "popularPizza.txt");
            fileHandler.writeToFile(orderNumber + " " + foodItem.getNumber() + " " + foodItem.getName() + " " + date.toString() + " " + formatter.format(time),"ordersToMake.txt");
        }
    }

    private int nextOrderNumber() {
        if (!fileHandler.getOrderNumbers().isEmpty()) {
            ArrayList<Integer> allOrderNumbers = fileHandler.getOrderNumbers();
            int[] orderNumbers = new int[allOrderNumbers.size()];
            for (int i = 0; i < orderNumbers.length; i++) {
                orderNumbers[i] = allOrderNumbers.get(i);
            }
            Arrays.sort(orderNumbers);
            return orderNumbers[orderNumbers.length - 1] + 1;
        } else {
            return 1;
        }

    }

    public void completeOrder(int orderNumber) {
        fileHandler.completeOrder(orderNumber);
    }

    public void listOrdersToMake() {
        ArrayList<String> ordersToMake = fileHandler.readFromFile("ordersToMake.txt");
        for (String order : ordersToMake) {
            System.out.println(order);
        }
    }
    
    public int[] getOrderNumbersToMake(){
       ArrayList<String> ordersToMake = fileHandler.readFromFile("ordersToMake.txt");
       String[] splitLine;
       int[] orderNumbersToMake = new int[ordersToMake.size()];
       int count = 0;
       for(String order : ordersToMake){
           splitLine = order.split(" ");
           orderNumbersToMake[count] = Integer.parseInt(splitLine[0]);
           count++;
       }
       return orderNumbersToMake;
    }

    public String[] returnOrder(){
        String[] order = new String[pizza.size()];
        int count = 0;
        for (Pizza foodItem : pizza) {
            order[count] = orderNumber + " " + foodItem.getNumber() + " " + foodItem.getName() + " " + date.toString() + " " + formatter.format(time);
            count++;
        } 
        return order;
    }
       
    
}
