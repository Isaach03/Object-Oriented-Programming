//Class defining the currency used for payment in the vending machine.

public class Currency {

    //Currency only has one property.
    private static double pounds;

    //Returns the pounds fields.
    public static double getPounds() {
        return pounds;
    }

    //Returns the user's input converted to dollars.
    public static double getDollars(double pounds) {
        return pounds * 1.22;
    }
    
}
