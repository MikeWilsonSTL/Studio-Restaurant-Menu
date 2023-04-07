package org.example.restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private Date updatedDate = new Date(120, Calendar.JANUARY, 1);
    private final ArrayList<MenuItem> menu = new ArrayList<>();

    private int countItems(String searchTerm){
        int counter = 0;
        for(MenuItem menuItem: menu){
            if(menuItem.getCategory() == searchTerm){
                counter++;
            }
        }
        return counter;
    }
    public void printMenu(){
        if(menu.size() < 1){
            System.out.println("ERROR: NO MENU FOUND");
        }
        else{
            int appCount = countItems("Appetizer");
            int mainCourseCount = countItems("Main Course");
            int dessertCount = countItems("Dessert");

            if(appCount > 0){
                System.out.println("=========================================");
                System.out.println("               APPETIZERS                ");
                System.out.println("=========================================");
                for (MenuItem menuItem : menu) {
                    if (menuItem.getCategory().equals("Appetizer")) {
                        if(menuItem.isNew()){
                            System.out.print("NEW!!! ");
                        }
                        System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                                + "$" + menuItem.getPrice());
                    }
                }
            }

            if(mainCourseCount > 0){
                System.out.println("=========================================");
                System.out.println("              MAIN COURSES               ");
                System.out.println("=========================================");
                for (MenuItem menuItem : menu) {
                    if (menuItem.getCategory().equals("Main Course")) {
                        if(menuItem.isNew()){
                            System.out.print("NEW!!! ");
                        }
                        System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                                + "$" + menuItem.getPrice());
                    }
                }
            }

            if(dessertCount > 0){
                System.out.println("=========================================");
                System.out.println("                DESSERTS                 ");
                System.out.println("=========================================");
                for (MenuItem menuItem : menu) {
                    if (menuItem.getCategory().equals("Dessert")) {
                        if(menuItem.isNew()){
                            System.out.print("NEW!!! ");
                        }
                        System.out.println(menuItem.getName() + ": " + menuItem.getDescription() + "\n"
                                + "$" + menuItem.getPrice());
                    }
                }
            }
        }
        System.out.println("\nUpdated on: " + updatedDate);

    }

    public void addToMenu() {
        Scanner input = new Scanner(System.in);
        String name;
        String description;
        double price;
        String category;
        boolean isNew;
        String newOrNotAnswer;

        System.out.println("Enter the name: ");
        name = input.nextLine();

        System.out.println("Enter the description: ");
        description = input.nextLine();

        System.out.println("Enter the price: ");
        price = input.nextDouble();
        input.nextLine(); //The program kept skipping the next section and I have no idea why. Maybe something involving CRLF?

        System.out.println("Enter the category: ");
        category = input.nextLine();

        System.out.println("Is the item new? (Y or N)");
        newOrNotAnswer = input.next().toUpperCase();
        isNew = newOrNotAnswer.equals("Y") || newOrNotAnswer.equals("YES");

        MenuItem newItem = new MenuItem(name, description, price, category, isNew);
        if(!alreadyExists(menu, newItem)){
            menu.add(newItem);
            System.out.println("\n" + name + " added! Re-print the menu to see.\n");
            updatedDate = new Date();
        }
        else{
            System.out.println("\nERROR: Item already exists.");
            System.out.println("Menu update cancelled. \n");
        }

    }

    public void addToMenu(String name, String description, double price, String category, boolean isNew){
        menu.add(new MenuItem(name, description, price, category, isNew));
    }

    public void removeFromMenu() {
        if(menu.size() < 1){
            System.out.println("ERROR: No menu found!");
            return;
        }
        Scanner input = new Scanner(System.in);
        int userChoice;
        String name;
        String userConfirm;

        System.out.println("Here's the current list of items.");
        System.out.println("Enter the number to delete the item.");
        for(int x = 0; x < menu.size(); x++){
            System.out.println(x + ": " + menu.get(x).getName());
        }
        userChoice = input.nextInt();
        name = menu.get(userChoice).getName();
        System.out.println("You selected: " + name + ". Are you sure? (Y/N)");
        userConfirm = input.next();

        if(userConfirm.equalsIgnoreCase("Y")){
            menu.remove(userChoice);
            System.out.println(name + " removed! Re-print the menu to see.");
            updatedDate = new Date();
        }
        else{
            System.out.println("Deletion cancelled.");
        }
    }

    public void printItem() {
        if(menu.size() < 1){
            System.out.println("ERROR: No menu found!");
            return;
        }
        Scanner input = new Scanner(System.in);
        int userChoice;

        System.out.println("Here's the current list of items.");
        System.out.println("Enter the number to print the full details of the item.");
        for(int x = 0; x < menu.size(); x++){
            System.out.println(x + ": " + menu.get(x).getName());
        }
        userChoice = input.nextInt();

        System.out.println("=========================================");
        System.out.println("SELECTED ITEM - " + menu.get(userChoice).getName().toUpperCase());
        System.out.println("=========================================");
        System.out.println("Description: " + menu.get(userChoice).getDescription());
        System.out.println("Price: $" + menu.get(userChoice).getPrice());
        System.out.println("Category: " + menu.get(userChoice).getCategory());
        System.out.println("New Item: " + menu.get(userChoice).isNew() + "\n");
    }

    public void compareItems() {
        if(menu.size() < 1){
            System.out.println("ERROR: No menu found!");
            return;
        }
        Scanner input = new Scanner(System.in);
        int userChoice1;
        int userChoice2;
        String itemOneName;
        String itemTwoName;
        String itemOneDescription;
        String itemTwoDescription;
        double itemOnePrice;
        double itemTwoPrice;

        System.out.println("Here's the current list of items.");
        System.out.println("Enter the number to select the first item to compare: ");
        for(int x = 0; x < menu.size(); x++){
            System.out.println(x + ": " + menu.get(x).getName());
        }
        userChoice1 = input.nextInt();
        System.out.println("Now select the number of the second item: ");
        userChoice2 = input.nextInt();

        itemOneName = menu.get(userChoice1).getName();
        itemOnePrice = menu.get(userChoice1).getPrice();

        itemOneDescription = menu.get(userChoice1).getDescription();
        itemTwoDescription = menu.get(userChoice2).getDescription();

        itemTwoName = menu.get(userChoice2).getName();
        itemTwoPrice = menu.get(userChoice2).getPrice();


        if(itemOneDescription.equals(itemTwoDescription) && itemOnePrice == itemTwoPrice){
            System.out.println("\nThe items " + itemOneName + " and " + itemTwoName + " are equal\n");
        }
        else{
            System.out.println("\nThe items " + itemOneName + " and " + itemTwoName + " are NOT equal\n");
        }
    }

    public boolean alreadyExists(ArrayList<MenuItem> menuToCompare, MenuItem item){
        for (MenuItem menuItem : menuToCompare) {
            if (item.getName().equals(menuItem.getName())) {
                return true;
            }
            if (item.getDescription().equals(menuItem.getDescription())) {
                return true;
            }
            if (item.getPrice() == menuItem.getPrice()) {
                return true;
            }
        }
        return false;
    }
}
