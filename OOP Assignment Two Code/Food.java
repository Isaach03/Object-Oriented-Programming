//Class that defines the properties of individual food items.

public class Food {

    //The food object has the properties of name and price.
    private String name;
    private double price;

    //Food object properties are initialised.
    public Food(String foodName, double foodPrice) {
        name = foodName;
        price = foodPrice;
    }
    
    //Returns the name of the food item
    public String getName() {
        return name;
    }

    //Returns the price of the food item
    public double getPrice() {
        return price;
    }
    
}
