package core;

/**
 * @author Benjamin
 */
public class Pizza {
    private int nr;
    private String name, ingredients;
    private double price;
    public Pizza(int nr, String name, String ingredients, double price){
        this.nr = nr;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }
    
    public int getNumber() {
        return nr;
    }
    
    public String getName() {
        return name;
    }
    
    public String getIngredients() {
        return ingredients;
    }
    
    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        if(name.toCharArray().length > 6)
            return nr + "# \t" + name + " \t\t" + price;
        else
            return nr + "# \t" + name + " \t\t\t" + price;
    }
}
