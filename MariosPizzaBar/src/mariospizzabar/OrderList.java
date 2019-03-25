package mariospizzabar;

import java.util.ArrayList;


public class OrderList {

    private ArrayList<Order> orders = new ArrayList<>();

    public void addOrderToList(Order order) {
        this.orders.add(order);
    }

    public void showOrderList() {
        for (Order order : orders) {
            order.showPizza();
        }
    }

    @Override
    public String toString () {
        final StringBuilder sb = new StringBuilder ("OrderList{");
        sb.append ("orders=").append (orders);
        sb.append ('}');
        return sb.toString ();
    }
}
