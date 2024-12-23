/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package joptionpane;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class CafeManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
       String[] coffeeTypes = {"Espresso", "Latte", "Cappuccino", "Americano"};
        double[] coffeePrices = {125.00, 150.00, 175.00, 140.00}; // Prices for each coffee type in PHP
        String[] sizes = {"Small", "Medium", "Large"};
        double[] sizePrices = {0.00, 25.00, 50.00}; // Additional prices for sizes in PHP
        String[] milkOptions = {"No Milk", "Regular Milk", "Soy Milk", "Almond Milk"};
        double milkPrice = 25.00; // Price for milk options in PHP
        String[] sugarOptions = {"No Sugar", "1 Sugar", "2 Sugars", "3 Sugars"};
        double sugarPrice = 5.00; // Price per sugar in PHP

        boolean ordering = true;

        while (ordering) {
            // Select coffee type
            String coffeeType = (String) JOptionPane.showInputDialog(null,
                    "Select your coffee type:",
                    "Coffee Shop",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    coffeeTypes,
                    coffeeTypes[0]);

            // Get the index of the selected coffee type
            int coffeeIndex = java.util.Arrays.asList(coffeeTypes).indexOf(coffeeType);

            // Select size
            String size = (String) JOptionPane.showInputDialog(null,
                    "Select size:",
                    "Coffee Shop",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    sizes,
                    sizes[0]);

            // Get the index of the selected size
            int sizeIndex = java.util.Arrays.asList(sizes).indexOf(size);

            // Select milk option
            String milk = (String) JOptionPane.showInputDialog(null,
                    "Select milk option:",
                    "Coffee Shop",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    milkOptions,
                    milkOptions[0]);

            // Select sugar option
            String sugar = (String) JOptionPane.showInputDialog(null,
                    "Select sugar option:",
                    "Coffee Shop",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    sugarOptions,
                    sugarOptions[0]);

            // Calculate total cost
            double totalCost = coffeePrices[coffeeIndex] + sizePrices[sizeIndex];

            // Add milk cost if applicable
            if (!milk.equals("No Milk")) {
                totalCost += milkPrice;
            }

            // Add sugar cost based on selection
            int sugarIndex = java.util.Arrays.asList(sugarOptions).indexOf(sugar);
            totalCost += sugarIndex * sugarPrice;

            // Create order summary
            String orderSummary = "Your Order:\n" +
                    "Coffee Type: " + coffeeType + "\n" +
                    "Size: " + size + "\n" +
                    "Milk: " + milk + "\n" +
                    "Sugar: " + sugar + "\n" +
                    "Total Cost: ₱" + String.format("%.2f", totalCost);

            // Display order summary
            JOptionPane.showMessageDialog(null, orderSummary, "Order Summary", JOptionPane.INFORMATION_MESSAGE);

            double paymentAmount = 0.0;
            boolean paymentSuccessful = false;

            while (!paymentSuccessful) {
                // Prompt user for payment
                String paymentInput = JOptionPane.showInputDialog(null, "Enter the amount of cash you are paying (in Pesos):", "Payment", JOptionPane.QUESTION_MESSAGE);

                try {
                    paymentAmount = Double.parseDouble(paymentInput);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue; // Skip to the next iteration of the loop
                }

                // Check if payment is sufficient
                if (paymentAmount >= totalCost) {
                    double change = paymentAmount - totalCost;
                    JOptionPane.showMessageDialog(null, "Payment successful! Your change is: ₱" + String.format("%.2f", change), "Payment Confirmation", JOptionPane.INFORMATION_MESSAGE);
                    paymentSuccessful = true; // Mark payment as successful
                } else {
                    double remainingAmount = totalCost - paymentAmount;
                   JOptionPane.showMessageDialog(null, "Insufficient payment. You still need to pay: ₱" + String.format("%.2f", remainingAmount), "Payment Error", JOptionPane.ERROR_MESSAGE);
                     }
            }

            // Ask if the user wants to order again
            int response = JOptionPane.showConfirmDialog(null, "Do you want to order again?", "Coffee Shop", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.NO_OPTION) {
                ordering = false; // Exit the loop if the user does not want to order again
            }
        }

        // Final message when the user decides to exit
        JOptionPane.showMessageDialog(null, "Thank you for visiting the Coffee Shop!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }
}