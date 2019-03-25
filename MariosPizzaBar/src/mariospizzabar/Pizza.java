package mariospizzabar;

public class Pizza {

    private int num;
    private String name;
    private double price;

    public Pizza(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(num).append(". ");
        sb.append(name).append(" ");
        sb.append(price).append(" ");
        return sb.toString();
    }
}
