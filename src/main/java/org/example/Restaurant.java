package org.example;
import org.example.restaurant.Menu;
import java.util.Objects;
import java.util.Scanner;

public class Restaurant {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Menu genericRestaurantMenu = new Menu();
        genericRestaurantMenu.addToMenu("Wings", "Fried Wings", 9.45, "Appetizer", false);
        genericRestaurantMenu.addToMenu("Ribs", "Smoked BBQ Ribs", 12.45, "Appetizer", false);
        genericRestaurantMenu.addToMenu("Ropa Vieja", "Braised Flank Steak", 17.55, "Main Course", false);
        genericRestaurantMenu.addToMenu("Cuban Paella", "Seafood Rice Dish", 22.55, "Main Course", false);
        genericRestaurantMenu.addToMenu("Bread Pudding", "Rum Caramel Sauce", 7.45, "Dessert", true);

        String userChoice;
        String[] actions = {"Print Menu", "Add to Menu", "Remove from Menu", "Print Item", "Compare Items",
                "Exit Program"};
        System.out.println("Welcome to Generic Restaurant™!");
        System.out.println("Enter a number to get started.\n");

        do{
            for(int x = 0; x < actions.length; x++){
                System.out.println(x + ": " + actions[x]);
            }
            System.out.println("\nMake a selection: ");
            userChoice = input.next();

            switch (userChoice) {
                case "0":  userChoice = "0";
                    genericRestaurantMenu.printMenu();
                    break;
                case "1":  userChoice = "1";
                    genericRestaurantMenu.addToMenu();
                    break;
                case "2":  userChoice = "2";
                    genericRestaurantMenu.removeFromMenu();
                    break;
                case "3":  userChoice = "3";
                    genericRestaurantMenu.printItem();
                    break;
                case "4":  userChoice = "4";
                    genericRestaurantMenu.compareItems();
                    break;
                case "5":  userChoice = "5";
                    break;
                default:
                    System.out.println("\nERROR: Invalid input.");
                    System.out.println("Please enter a number from 0 to 4.\n");
                    break;
            }
        }while (!Objects.equals(userChoice, "5"));
    }
}