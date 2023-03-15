//Client class that acts as the main class. Where the main functionality is derived.

//Importing classes for user inputs and collections.
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Client {

    //Main method to execute the code.
    public static void main(String[] args) {
        play();
    }

    //Method to print out the welcome message when the code is run.
    public static void welcome() {
        System.out.println("Welcome to Isaac's restaurant!");
    }

    //Method that hosts the vending machine which is run in the main method.
    public static void play() {
        //Initialising variables used throughout the method.
        String input;
        boolean paymentType = true;
        double payment = 0;

        //Creating a menu with six items.
        Set<Food> restaurantMenu = new HashSet<Food>();
        restaurantMenu.add(new Food("Fish", 10.0));
        restaurantMenu.add(new Food("Chicken", 7.0));
        restaurantMenu.add(new Food("Rice", 6.0));
        restaurantMenu.add(new Food("Chickpeas", 5.0));
        restaurantMenu.add(new Food("Broccoli", 3.0));
        restaurantMenu.add(new Food("Spinach", 3.0));

        //Try statement to catch incorrect input value
        try (Scanner console = new Scanner(System.in)) {
            //User is welcomed and presented with the menu and price of each item.
            welcome();
            System.out.println("Here is our menu:\n"); 
            for (Food item : restaurantMenu) {
                System.out.println(item.getName() + " £" + item.getPrice() + " / $" + Currency.getDollars(item.getPrice()));
                System.out.println();
            }
            System.out.println("----------------------------------");

            //User selects what currency they would like to pay with.
            System.out.println("Would you like to pay in Pounds or Dollars?");
            input = console.nextLine();
            //Store currency in variable so it can be accounted for later
            if(input.equalsIgnoreCase("Pounds")) {
                paymentType = true;
            } else if(input.equalsIgnoreCase("Dollars")) {
                paymentType = false;
            } else {
                System.out.println("Please choose a valid command");
                play();
            }
            System.out.println("----------------------------------");
            
            //User enters the item of food they would like and are asked to pay.
            System.out.println("What food item would you like? (Type the name of the food)");
            input = console.nextLine();
            if(input.equalsIgnoreCase("Chicken") && paymentType == true) {
                System.out.println("Please enter 7");
                payment = 7;
            } else if(input.equalsIgnoreCase("Chicken") && paymentType == false) {
                System.out.println("Please enter 8.54");
                payment = 8.54;
            } else if(input.equalsIgnoreCase("Fish") && paymentType == true) {
                System.out.println("Please enter 10");
                payment = 10;
            } else if(input.equalsIgnoreCase("Fish") && paymentType == false) {
                System.out.println("Please enter 12.2");
                payment = 12.2;
            } else if(input.equalsIgnoreCase("Rice") && paymentType == true) {
                System.out.println("Please enter 6");
                payment = 6;
            } else if(input.equalsIgnoreCase("Rice") && paymentType == false) {
                System.out.println("Please enter 7.32");
                payment = 7.32;
            } else if(input.equalsIgnoreCase("Chickpeas") && paymentType == true) {
                System.out.println("Please enter 5");
                payment = 5;
            } else if(input.equalsIgnoreCase("Chickpeas") && paymentType == false) {
                System.out.println("Please enter 6.1");
                payment = 6.1;
            } else if(input.equalsIgnoreCase("Broccoli") && paymentType == true) {
                System.out.println("Please enter 3");
                payment = 3; 
            } else if(input.equalsIgnoreCase("Broccoli") && paymentType == false) {
                    System.out.println("Please enter 3.66");
                    payment = 3.66;
            } else if(input.equalsIgnoreCase("Spinach") && paymentType == true) {
                System.out.println("Please enter 3");
                payment = 3;
            } else if(input.equalsIgnoreCase("Spinach") && paymentType == false) {
                System.out.println("Please enter 3.66");
                payment = 3.66;
            } else {
                System.out.println("Please enter an item on the menu");
                play();
            }
            System.out.println("----------------------------------");

            //User has paid. User is given change if they have overpaid.
            //If user has underpaid their money is returned and they go through the process again.
            try {
            input = console.nextLine();
            double userPayment = Double.parseDouble(input);
            if(userPayment > payment && paymentType == true) {
                System.out.println("Thank you for your purchase!");
                System.out.println("Here is your change: £" + String.format("%.2f",(userPayment - payment)));
            } else if(userPayment > payment && paymentType == false) {
                System.out.println("Thank you for your purchase!");
                System.out.println("Here is your change: $" + String.format("%.2f",(userPayment - payment)));
            } else if(userPayment < payment && paymentType == true) {
                System.out.println("You did not feed me enough money");
                System.out.println("You owe me this much: £" + String.format("%.2f",(payment - userPayment)));
                System.out.println("*Money returned*");
                play();
            } else if(userPayment < payment && paymentType == false) {
                System.out.println("You did not feed me enough money");
                System.out.println("You owe me this much: $" + String.format("%.2f",(payment - userPayment)));
                System.out.println("*Money returned*");
                play();
            } else if(userPayment == payment) {
                System.out.println("Thank you for your purchase!");
            } else {
                System.out.println("Please enter a valid value");
            }
            //Catch statement in case that user does not enter a correct value 
            } catch(Exception e) {
                System.out.println("Please enter a numerical value");
            }
        }
    } 
}

