package core;

//Alexander

import Storage.FileStorage;
import UI.ConsoleUI;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import toolbox.SortedQueue;

public class Order implements Comparable<Order>{

    private int orderNumber;
    private ArrayList<Pizza> pizza;
    private Customer customer;
    private double totalPrice;
    private LocalDate date = LocalDate.now();
    private LocalTime time;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    final private FileStorage fileHandler = new FileStorage();
    final private Menu menu = new Menu(new ConsoleUI());

    public Order(){
    };
    
    public Order(int orderNumber,ArrayList<Pizza> pizza, LocalDate date, LocalTime time) {
        this.orderNumber = orderNumber;
        this.pizza = pizza;
        this.date = date;
        this.time = time;
        calculateTotalPrice();
    }
    
    public Order(ArrayList<Pizza> pizza, LocalTime time) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        this.time = time;
        calculateTotalPrice();
    }

    public Order(ArrayList<Pizza> pizza, String firstName, LocalTime time) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        this.time = time;
        this.customer = new Customer(firstName);
        calculateTotalPrice();
    }

    public Order(ArrayList<Pizza> pizza, String firstName, String lastName, String address, LocalTime time) {
        this.orderNumber = nextOrderNumber();
        this.pizza = pizza;
        this.time = time;
        this.customer = new Customer(firstName, lastName, address);
        calculateTotalPrice();
    }
    
    public SortedQueue<Order> loadFromFile() {
        SortedQueue<Order> orders = new SortedQueue<>(); 
        ArrayList<String> lines = fileHandler.readFromFile("ordersToMake.txt");
        HashMap<Integer,ArrayList<Pizza>> pizzaMap = new HashMap<>();
        for (String line : lines) {
            int nr = Integer.parseInt((line.split(" "))[0]);
            int pizNr = Integer.parseInt((line.split(" "))[1]);
            Pizza pizza = menu.getPizza(pizNr);
            if(pizzaMap.containsKey(nr)) {
                pizzaMap.get(nr).add(pizza);
            }
            else{
                pizzaMap.put(nr, new ArrayList<>());
                pizzaMap.get(nr).add(pizza);
            }
        }
        ArrayList<Integer> orderDone = new ArrayList<>();
        for (String line : lines) {
            int nr = Integer.parseInt((line.split(" "))[0]);
            if(!orderDone.contains(nr)) {
                ArrayList<Pizza> pizzas = pizzaMap.get(nr);
                LocalDate date = LocalDate.parse((line.split(" "))[3]);
                LocalTime time = LocalTime.parse((line.split(" "))[4]);
                orders.add(new Order(nr,pizzas,date,time));
                orderDone.add(nr);
            }
        }
        return orders;
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
       
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public ArrayList<Pizza> getPizza() {
        return pizza;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nOrder Nummer: ").append(orderNumber);
        builder.append("\nAfhentning: ").append(date).append(" - ").append(time);
        for (Pizza piz : pizza) {
            builder.append("\n").append(piz);
        }
        return builder.toString();
                
    }

    @Override
    public int compareTo(Order other) {
        int cmp = date.compareTo(other.getDate());
        if(cmp == 0) {
            cmp = time.compareTo(other.getTime());
        }
        return cmp;
    }


}
