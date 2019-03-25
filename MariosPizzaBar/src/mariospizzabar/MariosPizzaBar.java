package mariospizzabar;

public class MariosPizzaBar {


    public static void main(String[] args) {
        Menu menu = new Menu();

        menu.createMenuFromFile();
        menu.showMenu();

        Pizza pizza1 = new Pizza(13, "Salat", 60);
        Pizza pizza2 = new Pizza (13, "Vesuvio", 45);
        Pizza pizza3 = new Pizza(15, "Hawaii", 40);
        Customer customer = new Customer("Mads", 12345, "Flensborggade 41");
        Customer customer2 = new Customer("Signe", 12345, "Flensborggade 41");

        Order order1 = new Order(pizza1, customer);
        order1.tilføjTilBestilling(pizza3);

        System.out.println (order1);

        Order order2 = new Order(pizza2, customer2);


        OrderList liste = new OrderList();

        liste.addOrderToList(order1);
        liste.showOrderList();
        liste.addOrderToList(order2);
    }

}
