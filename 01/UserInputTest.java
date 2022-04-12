import java.util.Scanner;// To use the Scanner

public class UserInputTest {
    public static void main(String[] args) {
        // Declare variables
        int number_of_units;
        double price_per_units; // in JPY
        double total_price;
        // Declare a Scanner for getting the user input
        Scanner user_input_scanner = new Scanner(System.in);
        // Assign value
        price_per_units = 1.5;
        // Ask the user for input
        System.out.print("Number of unit? ");
        number_of_units = user_input_scanner.nextInt();
        user_input_scanner.close();
        // Display the information
        System.out.println("Price per unit: " + price_per_units + " JPY ");
        System.out.println("Number of unit: " + number_of_units);
        // Compute the total_price
        total_price = price_per_units * number_of_units;
        // Display the result
        System.out.println("Total price is: " + total_price + " JPY ");
    }
}
